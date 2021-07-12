package spring.mvc.point.service;

import java.util.List;

import spring.mvc.member.dto.MemberDto;
import spring.mvc.point.dto.PointDto;
import spring.mvc.test.Pagination;

public interface PointService {

	void ProcessPList(PointDto point);

	void request(PointDto dto);
	
	List<PointDto> getRqpointList(Pagination pagination);
	
	public int getRqpointListCnt();

	void passbook(MemberDto dto);

}
