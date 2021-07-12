package spring.mvc.test;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.member.dto.MemberDto;
import spring.mvc.member.service.MemberService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberservice;

	//회원가입창
	@RequestMapping("/regist")
	public String regist() {

		String rtnPage = "member/regist";

		return rtnPage;
	}

	// ajax를 이용한 아이디 중복체크
	@RequestMapping("/idcheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		//중복아이디 체크
		count = memberservice.idcheck(id);
		System.out.println("count값 : " + count);
		map.put("cnt", count);

		return map;
	}

	// ajax를 이용한 닉네임 중복체크
	@RequestMapping("/nickcheck")
	@ResponseBody
	public Map<Object, Object> nickcheck(@RequestBody String nickname) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		//중복닉네임 체크
		count = memberservice.nickcheck(nickname);
		System.out.println("count값 : " + count);
		map.put("cnt", count);

		return map;
	}

	// 회원가입처리
	@RequestMapping(value = "/memberjoinpro.do", method = RequestMethod.POST)
	public ModelAndView memberJoinPro(MemberDto dto) {

		ModelAndView mav = new ModelAndView();

		memberservice.memberJoinProcess(dto);

		mav.setViewName("member/registsuc");

		return mav;
	}

	// 로그인처리
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(MemberDto dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		HttpSession session = req.getSession();
		MemberDto login = memberservice.login(dto);
		
		if(login == null)
		{
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/logform";
		}
		else
		{
			session.setAttribute("member", login);
			session.setAttribute("id", login.getId());
		}
		
		return "/member/logsuc";
	}

	// 로그아웃처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:/index";
	}

	//마이페이지
	@RequestMapping(value = "/member/mypage")
	public ModelAndView mypage(HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/mypage");
		
		String id = (String) session.getAttribute("id");
		
		//회원정보 데이터
		mav.addObject("dto", memberservice.read(id));

		return mav;
	}

	//사이드메뉴창
	@RequestMapping(value = "/member/sidebar")
	public String sidemenu() throws Exception {

		return "member/sidebar";
	}

	// 정보수정페이지
	@RequestMapping(value = "/member/memberupdate", method = RequestMethod.POST)
	public ModelAndView update_write(@RequestParam String id, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("들어갈 값 : " + id);

		mav.setViewName("member/memberupdate");
		mav.addObject("dto", memberservice.read(id));

		return mav;
	}

	// 정보수정처리
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(HttpSession session, @ModelAttribute MemberDto dto) throws Exception {
		memberservice.update(dto);
		
		//세션 갱신 코드
		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();
		MemberDto check = memberservice.read(id);
		session.setAttribute("member", check);

		return "redirect:../index";
	}

	//회원 탈퇴처리
	@RequestMapping("/member/delete")
	public String delete(HttpSession session, @RequestParam String id) throws Exception {
		memberservice.delete(id);
		session.invalidate();

		return "redirect:../index";
	}

}
