package spring.mvc.test;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.member.dto.MemberDto;
import spring.mvc.member.service.MemberService;
import spring.mvc.point.dto.PointDto;
import spring.mvc.point.service.PointService;

@Controller
@RequestMapping("point")
public class PointController {

	@Inject
	PointService service;
	PointDto pointdto;
	MemberDto memberdto;

	@Autowired
	private MemberService memberservice;

	// ����¡����Ʈ
	@RequestMapping(value = "/pointlist", method = RequestMethod.GET)
	public String paging(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) throws Exception {

		// ��ü �Խñ� ��
		int listCnt = service.getRqpointListCnt();

		// Pagination��ü ����
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);

		model.addAttribute("pagination", pagination);
		model.addAttribute("rqlist", service.getRqpointList(pagination));

		System.out.println("listcnt : " + listCnt);
		System.out.println("page : " + page);
		System.out.println("range : " + range);
		System.out.println("rangeSize : " + pagination.getRangeSize());
		System.out.println("endPage : " + pagination.getEndPage());

		return "point/pointlist";
	}

	// ����Ʈ ��û �㰡 ó��
	@RequestMapping("/processpoint")
	public String processpoint(@RequestParam(value = "chbox[]") List<String> chArr, PointDto point, HttpSession session)
			throws Exception {
		System.out.println("����");

		String allid = "";

		int rid = 0;
		String id = "";
		int rpoint = 0;

		// �ݺ������� ������ ó��
		for (String i : chArr) {
			allid = i;

			rid = Integer.parseInt(allid.split(";")[0]);
			id = allid.split(";")[1];
			rpoint = Integer.parseInt(allid.split(";")[2]);

			point.setRid(rid);
			point.setId(id);
			point.setRpoint(rpoint);

			System.out.println("all : " + allid);
			System.out.println("rid : " + rid + " id : " + id + " rpoint : " + rpoint);

			service.ProcessPList(point);

		}

		// ���� ���� �ڵ�
		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id2 = mem.getId();
		MemberDto check = memberservice.read(id2);
		session.setAttribute("member", check);

		return "redirect:/point/pointlist";

	}

	// ����Ʈ ��ûâ ���̵��
	@RequestMapping("/rqpointsidebar")
	public String rqpointsidebar() {
		return "/point/rqpointsidebar";
	}

	// ����Ʈ ��ûâ ����â
	@RequestMapping("/deposit")
	public String deposit() {
		return "/point/deposit";
	}

	// ����Ʈ ��ûâ ����
	@RequestMapping("/rqpage")
	public String rqpage() {
		return "/point/rqpage";
	}

	// ����Ʈ ����ó��
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public String payment(@ModelAttribute PointDto dto) throws Exception {
		service.request(dto);

		return "/point/requesting";
	}
	
	// �����Ա�������
	@RequestMapping("passbook")
	public String passbook() throws Exception {

		return "/point/passbook";
	}
	
	//�����Ա� ó��(member���̺��� point�� ����ó��)
	@RequestMapping(value = "pbsuc", method = RequestMethod.POST)
	public String pbsuc(Model model, HttpSession session, MemberDto dto, String searchBank, String AcNum)
	{
		System.out.println("point : " + dto.getId());
		System.out.println("id : " + dto.getPoint());
		System.out.println("searchBank : " + searchBank);
		System.out.println("AcNum : " + AcNum);
		
		service.passbook(dto);
		
		//���� ���� �ڵ�
		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();
		MemberDto check = memberservice.read(id);
		session.setAttribute("member", check);
		
		model.addAttribute("searchBank", searchBank);
		model.addAttribute("AcNum", AcNum);
		
		return "/point/pbsuc";
	}
	
}
