package spring.mvc.trade.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dto.SelectTradeDto;
import spring.mvc.trade.dto.TradeDto;

@Repository
public class TradeDaoImpl implements TradeDao {

	@Inject
	SqlSession sqlsession;

	//거래요청처리
	@Override
	public void rqtrade(TradeDto dto) {
		sqlsession.insert("trade.rqtrade", dto);
		sqlsession.update("trade.payment", dto);
	}

	//구매자가 한 게시물에서 거래요청하거나 거래중인지 파악
	@Override
	public int rqcount(TradeDto tradeDto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.rqcount", tradeDto);
	}

	//거래취소처리(거래요청, 거래중 일때)
	@Override
	public void cancletrade(TradeDto trade) {
		// TODO Auto-generated method stub
		sqlsession.delete("trade.cancletrade", trade);
		sqlsession.update("trade.refund", trade);
	}

	//거래요청수락
	@Override
	public void approve(int tid) {
		// TODO Auto-generated method stub
		sqlsession.update("trade.approve", tid);
	}

	//거래중 ui구성 데이터
	@Override
	public TradeDto read(int tid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.read", tid);
	}

	//거래완료처리
	@Override
	public void fintrade(TradeDto dto) {
		// TODO Auto-generated method stub
		sqlsession.update("trade.fintrade", dto);
		sqlsession.update("trade.finproc1", dto);
		sqlsession.update("trade.finproc2", dto);
	}

	// 페이징리스트게시물 수(거래완료)
	@Override
	public int getTradeListCntaft(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCntaft", id);
	}

	// 페이징리스트(거래완료)
	@Override
	public List<TradeDto> getTradeListaft(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.pagingaft", dto);
	}

	//페이징리스트게시물 수(거래중)
	@Override
	public int getTradeListCnting(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCnting", id);
	}

	//페이징리스트(거래중)
	@Override
	public List<TradeDto> getTradeListing(Pagination pagination, String id) {
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.paginging", dto);
	}

	// 페이징리스트게시물 수(거래요청)
	@Override
	public int getTradeListCntbefore(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCntbefore", id);
	}

	// 페이징리스트(거래요청)
	@Override
	public List<TradeDto> getTradeListbefore(Pagination pagination, String id) {
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.pagingbefore", dto);
	}

}
