package spring.mvc.board.dto;

import java.sql.Date;

public class BoardDto {
	private int bid;
	private String subject;
	private String tradegoods; 
	private String content;
	private String nickname;
	private Date createdate;
	private int price;
	private String id;
	private String gdsImg;
	private String gdsThumbImg;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTradegoods() {
		return tradegoods;
	}
	public void setTradegoods(String tradegoods) {
		this.tradegoods = tradegoods;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
}
