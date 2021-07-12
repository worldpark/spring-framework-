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
	

	//ajax를 이용한 아이디 중복체크
	@Override
	public int idcheck(String user_id) {
		// TODO Auto-generated method stub
		
		int count;
		
		count = memberdao.idcount(user_id);
		
		return count;
	}

	//ajax를 이용한 닉네임 중복체크
	@Override
	public int nickcheck(String user_nick) {
		// TODO Auto-generated method stub
		int count;
		
		count = memberdao.nickcount(user_nick);
		
		return count;
	}

	//회원가입처리
	@Override
	public void memberJoinProcess(MemberDto dto) {
		memberdao.memberJoinMethod(dto);
	}

	//로그인처리
	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.login(dto);
	}
	
	//정보수정페이지
	@Override
	public MemberDto read(String user_id) {
		return memberdao.read(user_id);
		
	}

	//회원수정처리
	@Override
	public void update(MemberDto dto) {
		memberdao.update(dto);
	}

	//탈퇴처리
	@Override
	public void delete(String user_id) {
		memberdao.delete(user_id);
	}

}
