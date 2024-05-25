package com.kh.app.board.vo;

public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String categoryNo;
	private String writerNo;
	private String hit;
	private String createDate;
	private String delYn;
	private String categoryName;
	private String nick;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String no, String title, String content, String categoryNo, String writerNo, String hit,
			String createDate, String delYn, String categoryName, String nick) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.categoryNo = categoryNo;
		this.writerNo = writerNo;
		this.hit = hit;
		this.createDate = createDate;
		this.delYn = delYn;
		this.categoryName = categoryName;
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", categoryNo=" + categoryNo
				+ ", writerNo=" + writerNo + ", hit=" + hit + ", createDate=" + createDate + ", delYn=" + delYn
				+ ", categoryName=" + categoryName + ", nick=" + nick + "]";
	}
	
	

}
