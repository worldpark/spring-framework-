package spring.mvc.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dao.TradeDao;
import spring.mvc.trade.dto.TradeDto;

@Service
public class TradeServiceImpl implements TradeService {

	@Inject
	TradeDao tradedao;

	//거래요청처리
	@Override
	public void rqtrade(TradeDto dto) {
		tradedao.rqtrade(dto);
	}

	//구매자가 한 게시물에서 거래요청하거나 거래중인지 파악
	@Override
	public int rqcount(int bid, String buyerid, TradeDto TradeDto) {
		
		TradeDto.setBid(bid);
		TradeDto.setBuyerid(buyerid);
		
		return tradedao.rqcount(TradeDto);
	}

	//거래취소처리(거래요청, 거래중 일때)
	@Override
	public void cancletrade(TradeDto trade) {
		// TODO Auto-generated method stub
		tradedao.cancletrade(trade);
	}

	//거래요청수락
	@Override
	public void approve(int tid) {
		tradedao.approve(tid);
	}

	//거래중 ui구성 데이터
	@Override
	public TradeDto read(int tid) {
		// TODO Auto-generated method stub
		return tradedao.read(tid);
	}

	//거래완료처리
	@Override
	public void fintrade(TradeDto dto) {
		// TODO Auto-generated method stub
		tradedao.fintrade(dto);
	}

	
	// 페이징리스트(거래완료)
	@Override
	public List<TradeDto> getTradeListaft(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListaft(pagination, id);
	}

	// 페이징리스트게시물 수(거래완료)
	@Override
	public int getTradeListCntaft(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCntaft(id);
	}

	//페이징리스트(거래중)
	@Override
	public List<TradeDto> getTradeListing(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListing(pagination, id);
	}

	//페이징리스트게시물 수(거래중)
	@Override
	public int getTradeListCnting(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCnting(id);
	}

	// 페이징리스트(거래요청)
	@Override
	public List<TradeDto> getTradeListbefore(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListbefore(pagination, id);
	}

	// 페이징리스트게시물 수(거래요청)
	@Override
	public int getTradeListCntbefore(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCntbefore(id);
	}

}
