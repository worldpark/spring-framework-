package spring.mvc.trade.service;

import java.util.List;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dto.TradeDto;

public interface TradeService {

	void rqtrade(TradeDto dto);

	int rqcount(int bid, String buyerid, TradeDto TradeDto);

	void cancletrade(TradeDto trade);

	void approve(int tid);

	TradeDto read(int tid);

	void fintrade(TradeDto dto);
	
	
	List<TradeDto> getTradeListaft(Pagination pagination, String id);
	
	public int getTradeListCntaft(String id);
	
	List<TradeDto> getTradeListing(Pagination pagination, String id);
	
	public int getTradeListCnting(String id);
	
	List<TradeDto> getTradeListbefore(Pagination pagination, String id);
	
	public int getTradeListCntbefore(String id);

}
