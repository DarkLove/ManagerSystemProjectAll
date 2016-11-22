package com.style.bean;

public class LoginBean {
	private int userId ;
	private String name ;
	private String password ;
	private int limits ;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLimits() {
		return limits;
	}
	public void setLimits(int limits) {
		this.limits = limits;
	}
	@Override
	public String toString() {
		return "LoginBean [userId=" + userId + ", name=" + name + ", password="
				+ password + ", limits=" + limits + "]";
	}
	
	
}
