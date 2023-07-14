package com.app.dto;

public class ResponseApi {
	private Integer userid;
	private String message;
	private Integer statuscode;
	private String name;
	private String username;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
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
	public ResponseApi(Integer userid, String message, Integer statuscode, String name, String username) {
		super();
		this.userid = userid;
		this.message = message;
		this.statuscode = statuscode;
		this.name = name;
		this.username = username;
	}
	public ResponseApi() {
		// TODO Auto-generated constructor stub
	}
}