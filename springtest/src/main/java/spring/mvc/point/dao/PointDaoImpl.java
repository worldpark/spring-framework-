package spring.mvc.point.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.member.dto.MemberDto;
import spring.mvc.point.dto.PointDto;
import spring.mvc.point.dto.SelectPointDto;
import spring.mvc.test.Pagination;

@Repository
public class PointDaoImpl implements PointDao {

	@Inject
	SqlSession sqlsession;

	// ����Ʈ ��û �㰡 ó��
	@Override
	public void ProcessPList(PointDto point) {
		// TODO Auto-generated method stub
		sqlsession.delete("point.propoint", point);
		sqlsession.update("point.propoint2", point);
	}

	// ����Ʈ ����ó��
	@Override
	public void request(PointDto dto) {
		// TODO Auto-generated method stub
		sqlsession.insert("point.request", dto);
	}

	// ����¡����Ʈ �Խù� ��
	@Override
	public int getRqpointListCnt() {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("point.getRqpointListCnt");
	}

	// ����¡����Ʈ
	@Override
	public List<PointDto> getRqpointList(Pagination pagination) {

		SelectPointDto dto = new SelectPointDto();

		dto.setPagination(pagination);

		return sqlsession.selectList("point.paging", dto);
	}

	//�����Ա� ó��(member���̺��� point�� ����ó��)
	@Override
	public void passbook(MemberDto dto) {
		// TODO Auto-generated method stub
		sqlsession.update("point.passbook", dto);
	}

}
