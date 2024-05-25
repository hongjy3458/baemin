package com.kh.app.board.vo;

public class CategoryVo {
	
	private String no;
	private String name;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + "]";
	}
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryVo(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	

}
