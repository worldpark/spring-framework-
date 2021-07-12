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

	//����Ʈ ��û �㰡 ó��
	@Override
	public void ProcessPList(PointDto point) {
		// TODO Auto-generated method stub
		pointDao.ProcessPList(point);
	}

	//����Ʈ ����ó��
	@Override
	public void request(PointDto dto) {
		// TODO Auto-generated method stub
		pointDao.request(dto);
	}

	// ����¡����Ʈ
	@Override
	public List<PointDto> getRqpointList(Pagination pagination) {
		// TODO Auto-generated method stub
		return pointDao.getRqpointList(pagination);
	}

	// ����¡����Ʈ �Խù� ��
	@Override
	public int getRqpointListCnt() {
		// TODO Auto-generated method stub
		return pointDao.getRqpointListCnt();
	}

	//�����Ա� ó��(member���̺��� point�� ����ó��)
	@Override
	public void passbook(MemberDto dto) {
		// TODO Auto-generated method stub
		pointDao.passbook(dto);
	}

}
