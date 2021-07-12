package spring.mvc.trade.dao;

import java.util.List;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dto.TradeDto;

public interface TradeDao {

	void rqtrade(TradeDto dto);

	int rqcount(TradeDto tradeDto);

	void cancletrade(TradeDto trade);

	void approve(int tid);

	TradeDto read(int tid);

	void fintrade(TradeDto dto);
	
	public int getTradeListCntaft(String id);
	
	List<TradeDto> getTradeListaft(Pagination pagination, String id);
	
	public int getTradeListCnting(String id);
	
	List<TradeDto> getTradeListing(Pagination pagination, String id);
	
	public int getTradeListCntbefore(String id);
	
	List<TradeDto> getTradeListbefore(Pagination pagination, String id);

}
