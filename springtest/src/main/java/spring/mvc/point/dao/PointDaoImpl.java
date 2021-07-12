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

	// 포인트 요청 허가 처리
	@Override
	public void ProcessPList(PointDto point) {
		// TODO Auto-generated method stub
		sqlsession.delete("point.propoint", point);
		sqlsession.update("point.propoint2", point);
	}

	// 포인트 결제처리
	@Override
	public void request(PointDto dto) {
		// TODO Auto-generated method stub
		sqlsession.insert("point.request", dto);
	}

	// 페이징리스트 게시물 수
	@Override
	public int getRqpointListCnt() {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("point.getRqpointListCnt");
	}

	// 페이징리스트
	@Override
	public List<PointDto> getRqpointList(Pagination pagination) {

		SelectPointDto dto = new SelectPointDto();

		dto.setPagination(pagination);

		return sqlsession.selectList("point.paging", dto);
	}

	//계좌입금 처리(member테이블의 point만 감산처리)
	@Override
	public void passbook(MemberDto dto) {
		// TODO Auto-generated method stub
		sqlsession.update("point.passbook", dto);
	}

}
