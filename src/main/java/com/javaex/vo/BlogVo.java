package com.javaex.vo;

public class BlogVo {

	private int userno;
	private String bolgtitle;
	private String logofile;
	
	public BlogVo() {
		super();
	}

	public BlogVo(int userno, String bolgtitle, String logofile) {
		super();
		this.userno = userno;
		this.bolgtitle = bolgtitle;
		this.logofile = logofile;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getBolgtitle() {
		return bolgtitle;
	}

	public void setBolgtitle(String bolgtitle) {
		this.bolgtitle = bolgtitle;
	}

	public String getLogofile() {
		return logofile;
	}

	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}

	@Override
	public String toString() {
		return "BlogVo [userno=" + userno + ", bolgtitle=" + bolgtitle + ", logofile=" + logofile + "]";
	}
	
	
}
