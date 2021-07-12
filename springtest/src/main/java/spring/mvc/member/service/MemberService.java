package spring.mvc.member.service;

import javax.servlet.http.HttpSession;

import spring.mvc.member.dto.MemberDto;

public interface MemberService {
	
	public void memberJoinProcess(MemberDto dto);

	//�α���
	public MemberDto login(MemberDto dto) throws Exception;

	public int idcheck(String user_id);

	public int nickcheck(String user_nick);

	//��������������
	public MemberDto read(String user_id);

	//��������ó��
	public void update(MemberDto dto);

	public void delete(String user_id);	

}
