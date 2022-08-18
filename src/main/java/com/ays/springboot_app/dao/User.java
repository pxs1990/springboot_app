package com.ays.springboot_app.dao;

public class User {

	private String username;
	private String password;
	private String loginMsg;
	
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
	public String getLoginMsg() {
		return loginMsg;
	}
	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password.substring(0, 2)+"********" + ", loginMsg=" + loginMsg + "]";
	}
	
}
