package spring.mvc.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.board.service.BoardService;
import spring.mvc.member.dto.MemberDto;
import spring.mvc.member.service.MemberService;

@Controller
public class HomeController {

	@Inject
	BoardService boardservice;

	@Autowired
	private MemberService memberservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping("/index")
	public String index(MemberDto dto, HttpSession session/*, HttpServletRequest req*/) {
			
		MemberDto mem = (MemberDto) session.getAttribute("member");
		
		int point = 0;
		String nickname = "";
		String name = "";
		String address = "";
		String ph = "";
		
		if(mem == null)
		{
			
		}
		else
		{
			String id = mem.getId();
			System.out.println("id : " + id);
			
			MemberDto check = memberservice.read(id);
			
			session.setAttribute("member", check);
			
			MemberDto check2 = (MemberDto) session.getAttribute("member");
			
			point = check2.getPoint();
			nickname = check2.getNickname();
			name = check2.getName();
			address = check2.getAddress();
			ph = check2.getPh();
		}		
		
		String rtnPage = "index";
		
		return rtnPage;
	}
	
	@RequestMapping("test")
	public String test() {
		
		return "test";
	}
	
	@RequestMapping("logform")
	public String logform() {
		
		return "/member/logform";
	}
	
	@RequestMapping("/blank")
	public String blank()
	{
		return "/blank";
	}
}
