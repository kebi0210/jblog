package com.javaex.vo;

public class CategoryVo {

	private int cateno;
	private int userno;
	private String catename;
	private String description;
	private String regdate;
	
	public CategoryVo() {
		super();
	}

	public CategoryVo(int cateno, int userno, String catename, String description, String regdate) {
		super();
		this.cateno = cateno;
		this.userno = userno;
		this.catename = catename;
		this.description = description;
		this.regdate = regdate;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CategoryVo [cateno=" + cateno + ", userno=" + userno + ", catename=" + catename + ", description="
				+ description + ", regdate=" + regdate + "]";
	}
	
	
	
}
