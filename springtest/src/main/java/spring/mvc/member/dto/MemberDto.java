package spring.mvc.member.dto;

public class MemberDto {
	
	private String id;
	private String nickname;
	private int rank;
	private String name;
	private String password;
	private String address;
	private String ph;
	private int point;
	private int buypenpoint;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getBuypenpoint() {
		return buypenpoint;
	}
	public void setBuypenpoint(int buypenpoint) {
		this.buypenpoint = buypenpoint;
	}
}
