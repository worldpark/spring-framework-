package spring.mvc.point.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.mvc.member.dto.MemberDto;
import spring.mvc.point.dao.PointDao;
import spring.mvc.point.dto.PointDto;
import spring.mvc.test.Pagination;

@Service
public class PointServiceImpl implements PointService {
	
	@Inject
	PointDao pointDao;

	//포인트 요청 허가 처리
	@Override
	public void ProcessPList(PointDto point) {
		// TODO Auto-generated method stub
		pointDao.ProcessPList(point);
	}

	//포인트 결제처리
	@Override
	public void request(PointDto dto) {
		// TODO Auto-generated method stub
		pointDao.request(dto);
	}

	// 페이징리스트
	@Override
	public List<PointDto> getRqpointList(Pagination pagination) {
		// TODO Auto-generated method stub
		return pointDao.getRqpointList(pagination);
	}

	// 페이징리스트 게시물 수
	@Override
	public int getRqpointListCnt() {
		// TODO Auto-generated method stub
		return pointDao.getRqpointListCnt();
	}

	//계좌입금 처리(member테이블의 point만 감산처리)
	@Override
	public void passbook(MemberDto dto) {
		// TODO Auto-generated method stub
		pointDao.passbook(dto);
	}

}
