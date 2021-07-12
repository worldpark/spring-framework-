package spring.mvc.trade.dto;

import java.sql.Date;

public class TradeDto {
	
	private int tid;
	private String sellerid;
	private String sellernickname;
	private String buyerid;
	private String buyernickname;
	private String tradegoods;
	private String status;
	private int tradepoint;
	private Date trededate;
	private int bid;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellernickname() {
		return sellernickname;
	}
	public void setSellernickname(String sellernickname) {
		this.sellernickname = sellernickname;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public String getBuyernickname() {
		return buyernickname;
	}
	public void setBuyernickname(String buyernickname) {
		this.buyernickname = buyernickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTradepoint() {
		return tradepoint;
	}
	public void setTradepoint(int tradepoint) {
		this.tradepoint = tradepoint;
	}
	public Date getTrededate() {
		return trededate;
	}
	public void setTrededate(Date trededate) {
		this.trededate = trededate;
	}
	public String getTradegoods() {
		return tradegoods;
	}
	public void setTradegoods(String tradegoods) {
		this.tradegoods = tradegoods;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	

}
