package spring.mvc.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession sqlsession;
	
	@Inject
	private SqlSessionTemplate sql;
	
	private static String namespace = "member";
	
	//ajax를 이용한 아이디중복체크
	@Override
	public int idcount(String user_id) {
		// TODO Auto-generated method stub
		
		int count = sqlsession.selectOne("member.idcount", user_id); 
		
		return count;
	}

	//ajax를 이용한 닉네임 중복체크
	@Override
	public int nickcount(String user_nick) {
		
		int count = sqlsession.selectOne("member.nickcount", user_nick); 
		
		return count;
	}
	
	//회원가입처리
	@Override
	public void memberJoinMethod(MemberDto dto) {
		sql.insert("member.join", dto);
	}

	//로그인처리
	@Override
	public MemberDto login(MemberDto dto) throws Exception {

		return sqlsession.selectOne(namespace + ".login", dto);
	}
	
	//정보수정페이지
	@Override
	public MemberDto read(String user_id) {
		return sqlsession.selectOne("member.view", user_id);
	}

	// 정보수정처리
	@Override
	public void update(MemberDto dto) {
		sqlsession.update("member.update", dto);
	}

	//회원 탈퇴처리
	@Override
	public void delete(String user_id) {
		sqlsession.delete("member.delete", user_id);
		
	}

	//유저리스트
	@Override
	public MemberDto viewMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("member.viewMember", dto);
	}

}
