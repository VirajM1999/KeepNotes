package com.app.dto;


public class Userdto {
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	private String name;
	private String username;

	public Userdto(Integer userId, String name, String username) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Userdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
