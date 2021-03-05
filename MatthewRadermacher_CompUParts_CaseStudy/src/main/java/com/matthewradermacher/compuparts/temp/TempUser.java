package com.matthewradermacher.compuparts.temp;

public class TempUser {

	private String userName;
	private String password;
	
	public TempUser() {
		
	}
	
	public TempUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
