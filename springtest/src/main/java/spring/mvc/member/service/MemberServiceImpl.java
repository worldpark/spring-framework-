package spring.mvc.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.member.dao.MemberDao;
import spring.mvc.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate membersqlsession;
	
	@Inject
	private MemberDao memberdao;
	

	//ajax�� �̿��� ���̵� �ߺ�üũ
	@Override
	public int idcheck(String user_id) {
		// TODO Auto-generated method stub
		
		int count;
		
		count = memberdao.idcount(user_id);
		
		return count;
	}

	//ajax�� �̿��� �г��� �ߺ�üũ
	@Override
	public int nickcheck(String user_nick) {
		// TODO Auto-generated method stub
		int count;
		
		count = memberdao.nickcount(user_nick);
		
		return count;
	}

	//ȸ������ó��
	@Override
	public void memberJoinProcess(MemberDto dto) {
		memberdao.memberJoinMethod(dto);
	}

	//�α���ó��
	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.login(dto);
	}
	
	//��������������
	@Override
	public MemberDto read(String user_id) {
		return memberdao.read(user_id);
		
	}

	//ȸ������ó��
	@Override
	public void update(MemberDto dto) {
		memberdao.update(dto);
	}

	//Ż��ó��
	@Override
	public void delete(String user_id) {
		memberdao.delete(user_id);
	}

}
