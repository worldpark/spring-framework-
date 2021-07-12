package spring.mvc.point.dto;

import spring.mvc.test.Pagination;

public class SelectPointDto {
	
	private Pagination pagination;
	private String selectstring;
	private int selectint;
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public String getSelectstring() {
		return selectstring;
	}
	public void setSelectstring(String selectstring) {
		this.selectstring = selectstring;
	}
	public int getSelectint() {
		return selectint;
	}
	public void setSelectint(int selectint) {
		this.selectint = selectint;
	}
	
	

}
