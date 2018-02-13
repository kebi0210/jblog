package com.javaex.vo;

public class UserVo {

	private int userno;
	private String id;
	private String username;
	private String password;
	private String joindate;
	
	public UserVo() {
		super();
	}

	public UserVo(int userno, String id, String username, String password, String joindate) {
		super();
		this.userno = userno;
		this.id = id;
		this.username = username;
		this.password = password;
		this.joindate = joindate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "UserVo [userno=" + userno + ", id=" + id + ", username=" + username + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}
	
	
}
