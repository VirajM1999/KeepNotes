package com.app.dto;

public class LoginDto {
	private String password;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public LoginDto(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
