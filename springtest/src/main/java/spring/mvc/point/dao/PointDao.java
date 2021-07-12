package spring.mvc.point.dao;

import java.util.List;

import spring.mvc.member.dto.MemberDto;
import spring.mvc.point.dto.PointDto;
import spring.mvc.test.Pagination;

public interface PointDao {

	void ProcessPList(PointDto point);

	void request(PointDto dto);
	
	
	public int getRqpointListCnt();
	
	List<PointDto> getRqpointList(Pagination pagination);

	void passbook(MemberDto dto);
}
