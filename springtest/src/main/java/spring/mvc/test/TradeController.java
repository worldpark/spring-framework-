package spring.mvc.test;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.member.dto.MemberDto;
import spring.mvc.member.service.MemberService;
import spring.mvc.point.dto.PointDto;
import spring.mvc.trade.dto.TradeDto;
import spring.mvc.trade.service.TradeService;

@Controller
@RequestMapping("trade/*")
public class TradeController {

	@Inject
	TradeService tradeservice;
	TradeDto tradedto;

	@Autowired
	private MemberService memberservice;

	// 페이징리스트(거래중)
	@RequestMapping(value = "/tradelist", method = RequestMethod.GET)
	public String paginging(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range, HttpSession session) throws Exception {

		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();

		// 전체 게시글 수
		int listCnt = tradeservice.getTradeListCnting(id);

		// Pagination객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);

		model.addAttribute("pagination", pagination);
		model.addAttribute("trlist", tradeservice.getTradeListing(pagination, id));

		System.out.println("listcnt : " + listCnt);
		System.out.println("page : " + page);
		System.out.println("range : " + range);
		System.out.println("rangeSize : " + pagination.getRangeSize());
		System.out.println("endPage : " + pagination.getEndPage());

		return "trade/tradelist";
	}

	// 페이징리스트(거래완료)
	@RequestMapping(value = "/tradehistory", method = RequestMethod.GET)
	public String pagingaft(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range, HttpSession session) throws Exception {

		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();

		// 전체 게시글 수
		int listCnt = tradeservice.getTradeListCntaft(id);

		// Pagination객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);

		model.addAttribute("pagination", pagination);
		model.addAttribute("trlist", tradeservice.getTradeListaft(pagination, id));

		System.out.println("listcnt : " + listCnt);
		System.out.println("page : " + page);
		System.out.println("range : " + range);
		System.out.println("rangeSize : " + pagination.getRangeSize());
		System.out.println("endPage : " + pagination.getEndPage());

		return "trade/tradehistory";
	}

	// 페이징리스트(거래요청)
	@RequestMapping(value = "/rqtradelist", method = RequestMethod.GET)
	public String pagingbefore(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range, HttpSession session) throws Exception {

		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();

		// 전체 게시글 수
		int listCnt = tradeservice.getTradeListCntbefore(id);

		// Pagination객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);

		model.addAttribute("pagination", pagination);
		model.addAttribute("rqlist", tradeservice.getTradeListbefore(pagination, id));

		System.out.println("listcnt : " + listCnt);
		System.out.println("page : " + page);
		System.out.println("range : " + range);
		System.out.println("rangeSize : " + pagination.getRangeSize());
		System.out.println("endPage : " + pagination.getEndPage());

		return "trade/rqtradelist";
	}

	// 거래요청처리
	@RequestMapping(value = "/rqtrade")
	public String rqtrade(@ModelAttribute TradeDto dto, HttpSession session) throws Exception {

		MemberDto mem = (MemberDto) session.getAttribute("member");

		if (mem.getPoint() < dto.getTradepoint()) {
			System.out.println("포인트부족");
			return "redirect:../board/board";
		} else {

			System.out.println("tradepoint : " + dto.getTradepoint());
			tradeservice.rqtrade(dto);

			// 세션 갱신 코드
			MemberDto mem2 = (MemberDto) session.getAttribute("member");
			String id = mem2.getId();

			MemberDto check = memberservice.read(id);

			int point = check.getPoint();
			System.out.println("point : " + point);

			session.setAttribute("member", check);

			return "redirect:../index";
		}

	}

	// 거래취소처리(거래요청일때)
	@RequestMapping("/cancletrade")
	public String processpoint(@RequestParam(value = "chbox[]") List<String> chArr, TradeDto trade, HttpSession session)
			throws Exception {
		String allrq = "";

		int tid = 0;
		String buyerid = "";
		int tradepoint = 0;

		// 반복문으로 여러번 처리
		for (String i : chArr) {
			allrq = i;

			tid = Integer.parseInt(allrq.split(";")[0]);
			buyerid = allrq.split(";")[1];
			tradepoint = Integer.parseInt(allrq.split(";")[2]);

			trade.setTid(tid);
			trade.setBuyerid(buyerid);
			trade.setTradepoint(tradepoint);

			tradeservice.cancletrade(trade);
		}

		return "trade/rqtradelist";

	}

	// 거래요청수락
	@RequestMapping(value = "trade", method = RequestMethod.GET)
	public ModelAndView approve(@RequestParam int tid, String buyerid, String sellerid, int check) throws Exception {
		System.out.println("buyerid : " + buyerid);
		System.out.println("sellerid : " + sellerid);
		System.out.println("check : " + check);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("trade/trade");

		if (check == 1) {
			tradeservice.approve(tid);
		}

		// 거래중 ui구성 데이터
		mav.addObject("tdto", tradeservice.read(tid));
		mav.addObject("bmdto", memberservice.read(buyerid));
		mav.addObject("smdto", memberservice.read(sellerid));

		return mav;
	}

	// 거래완료처리
	@RequestMapping(value = "fintrade", method = RequestMethod.POST)
	public String fintrade(@ModelAttribute TradeDto dto) throws Exception {
		tradeservice.fintrade(dto);

		return "redirect:/trade/tradehistory";
	}

	// 거래취소처리(거래중일때)
	@RequestMapping(value = "cancletrading", method = RequestMethod.POST)
	public String cancletrading(TradeDto trade) throws Exception {
		tradeservice.cancletrade(trade);

		return "redirect:/trade/tradelist";
	}
}
