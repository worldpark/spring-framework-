package spring.mvc.member.dao;

import javax.inject.Inject;

import spring.mvc.member.dto.MemberDto;


public interface MemberDao {
	
	
	public void memberJoinMethod(MemberDto dto);

	public MemberDto login(MemberDto dto) throws Exception;

	public int idcount(String user_id);

	public int nickcount(String user_nick);

	//��������������
	public MemberDto read(String user_id);

	//��������ó��
	public void update(MemberDto dto);

	public void delete(String user_id);

	public MemberDto viewMember(MemberDto dto);


}
