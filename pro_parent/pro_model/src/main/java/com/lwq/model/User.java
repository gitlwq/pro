package com.lwq.model;

public class User {
		
	
	private String usrname;
	private String password;
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String usrname, String password) {
		super();
		this.usrname = usrname;
		this.password = password;
	}
	
	
	
}
