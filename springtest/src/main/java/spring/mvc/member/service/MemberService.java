package spring.mvc.member.service;

import javax.servlet.http.HttpSession;

import spring.mvc.member.dto.MemberDto;

public interface MemberService {
	
	public void memberJoinProcess(MemberDto dto);

	//로그인
	public MemberDto login(MemberDto dto) throws Exception;

	public int idcheck(String user_id);

	public int nickcheck(String user_nick);

	//정보수정페이지
	public MemberDto read(String user_id);

	//정보수정처리
	public void update(MemberDto dto);

	public void delete(String user_id);	

}
