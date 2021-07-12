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
	
	//ajax�� �̿��� ���̵��ߺ�üũ
	@Override
	public int idcount(String user_id) {
		// TODO Auto-generated method stub
		
		int count = sqlsession.selectOne("member.idcount", user_id); 
		
		return count;
	}

	//ajax�� �̿��� �г��� �ߺ�üũ
	@Override
	public int nickcount(String user_nick) {
		
		int count = sqlsession.selectOne("member.nickcount", user_nick); 
		
		return count;
	}
	
	//ȸ������ó��
	@Override
	public void memberJoinMethod(MemberDto dto) {
		sql.insert("member.join", dto);
	}

	//�α���ó��
	@Override
	public MemberDto login(MemberDto dto) throws Exception {

		return sqlsession.selectOne(namespace + ".login", dto);
	}
	
	//��������������
	@Override
	public MemberDto read(String user_id) {
		return sqlsession.selectOne("member.view", user_id);
	}

	// ��������ó��
	@Override
	public void update(MemberDto dto) {
		sqlsession.update("member.update", dto);
	}

	//ȸ�� Ż��ó��
	@Override
	public void delete(String user_id) {
		sqlsession.delete("member.delete", user_id);
		
	}

	//��������Ʈ
	@Override
	public MemberDto viewMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("member.viewMember", dto);
	}

}
