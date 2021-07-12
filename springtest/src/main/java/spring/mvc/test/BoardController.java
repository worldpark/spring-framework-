package spring.mvc.test;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.board.service.BoardService;
import spring.mvc.member.dto.MemberDto;
import spring.mvc.trade.dto.TradeDto;
import spring.mvc.trade.service.TradeService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	BoardDto boardDto;

	@Inject
	TradeService tradeservice;
	
	//�Խ��� �۾���â
	@RequestMapping("/write")
	public String boardwrite() {
		
		return "/board/write";
	}
	
	//�Խù� ����
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bid, HttpSession session) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/view");
		mav.addObject("dto", service.read(bid));
		
		MemberDto mdto = (MemberDto) session.getAttribute("member");

		TradeDto TradeDto = new TradeDto();
		
		String buyerid = mdto.getId();

		if(tradeservice.rqcount(bid, buyerid, TradeDto) >= 1)
		{
			mav.addObject("rqcount", tradeservice.rqcount(bid, buyerid, TradeDto));
		}
		System.out.println("rqcount : " + tradeservice.rqcount(bid, buyerid, TradeDto));
		
		return mav;
	}
	
	//�Խù� ����������
	@RequestMapping(value="update_write", method = RequestMethod.POST)
	public ModelAndView update_write(@RequestParam int bid, HttpSession session) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/update_write");
		mav.addObject("dto", service.read(bid));
		
		return mav;
	}

	//�Խù� ����ó��
	@RequestMapping("delete")
	public String delete(@RequestParam int bid) throws Exception
	{
		service.delete(bid);
		return "redirect:board";
	}
	
	
	
	
	//����¡����Ʈ
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String paging(Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "tradegoods") String searchType,
			@RequestParam(required = false) String keyword
			) throws Exception
	{
		
		SelectBoardDto selectBoardDto = new SelectBoardDto();	//�˻���� ��ü
		selectBoardDto.setSearchType(searchType);
		selectBoardDto.setKeyword(keyword);
		
		//��ü �Խñ� ��
		int listCnt = service.getBoardListCnt(selectBoardDto);
		
		selectBoardDto.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination",selectBoardDto);
		model.addAttribute("boardList",service.getBoardList(selectBoardDto));
		
		return "board/board";
	}
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	//�Խù� ����
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardDto dto, MultipartFile file) throws Exception
	{
		String imgUploadPath = uploadPath + File.separator + "imgUpload";	//���ε� ���� �������
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "")	//������ ������
		{
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		}
		else
		{
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		service.create(dto);
		return "redirect:/board/board";
	}
	
	//�Խù� ����ó��
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDto dto, MultipartFile file, HttpServletRequest req) throws Exception
	{
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "")
		{
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();

			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}
		else
		{
			dto.setGdsImg(req.getParameter("gdsImg"));
			dto.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		service.update(dto);
		
		return "redirect:board";
	}

}
