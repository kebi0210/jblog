package com.javaex.vo;

public class PostVo {

	
	private int postno;
	private int cateno;
	private String posttitle;
	private String postcontent;
	private String regdate;
	
	public PostVo() {
		super();
	}

	public PostVo(int postno, int cateno, String posttitle, String postcontent, String regdate) {
		super();
		this.postno = postno;
		this.cateno = cateno;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
		this.regdate = regdate;
	}

	public int getPostno() {
		return postno;
	}

	public void setPostno(int postno) {
		this.postno = postno;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PostVo [postno=" + postno + ", cateno=" + cateno + ", posttitle=" + posttitle + ", postcontent="
				+ postcontent + ", regdate=" + regdate + "]";
	}
	
	
	
}
