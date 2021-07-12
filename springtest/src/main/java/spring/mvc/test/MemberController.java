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

	//ȸ������â
	@RequestMapping("/regist")
	public String regist() {

		String rtnPage = "member/regist";

		return rtnPage;
	}

	// ajax�� �̿��� ���̵� �ߺ�üũ
	@RequestMapping("/idcheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		//�ߺ����̵� üũ
		count = memberservice.idcheck(id);
		System.out.println("count�� : " + count);
		map.put("cnt", count);

		return map;
	}

	// ajax�� �̿��� �г��� �ߺ�üũ
	@RequestMapping("/nickcheck")
	@ResponseBody
	public Map<Object, Object> nickcheck(@RequestBody String nickname) {
		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		//�ߺ��г��� üũ
		count = memberservice.nickcheck(nickname);
		System.out.println("count�� : " + count);
		map.put("cnt", count);

		return map;
	}

	// ȸ������ó��
	@RequestMapping(value = "/memberjoinpro.do", method = RequestMethod.POST)
	public ModelAndView memberJoinPro(MemberDto dto) {

		ModelAndView mav = new ModelAndView();

		memberservice.memberJoinProcess(dto);

		mav.setViewName("member/registsuc");

		return mav;
	}

	// �α���ó��
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

	// �α׾ƿ�ó��
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:/index";
	}

	//����������
	@RequestMapping(value = "/member/mypage")
	public ModelAndView mypage(HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/mypage");
		
		String id = (String) session.getAttribute("id");
		
		//ȸ������ ������
		mav.addObject("dto", memberservice.read(id));

		return mav;
	}

	//���̵�޴�â
	@RequestMapping(value = "/member/sidebar")
	public String sidemenu() throws Exception {

		return "member/sidebar";
	}

	// ��������������
	@RequestMapping(value = "/member/memberupdate", method = RequestMethod.POST)
	public ModelAndView update_write(@RequestParam String id, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("�� �� : " + id);

		mav.setViewName("member/memberupdate");
		mav.addObject("dto", memberservice.read(id));

		return mav;
	}

	// ��������ó��
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(HttpSession session, @ModelAttribute MemberDto dto) throws Exception {
		memberservice.update(dto);
		
		//���� ���� �ڵ�
		MemberDto mem = (MemberDto) session.getAttribute("member");
		String id = mem.getId();
		MemberDto check = memberservice.read(id);
		session.setAttribute("member", check);

		return "redirect:../index";
	}

	//ȸ�� Ż��ó��
	@RequestMapping("/member/delete")
	public String delete(HttpSession session, @RequestParam String id) throws Exception {
		memberservice.delete(id);
		session.invalidate();

		return "redirect:../index";
	}

}
