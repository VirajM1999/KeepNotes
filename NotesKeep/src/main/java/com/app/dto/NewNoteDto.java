package com.app.dto;

public class NewNoteDto {
	private Integer userid;
	private String title;
	private String description;
	private String creationTimestamp;
	private String updationTimestamp;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public String getUpdationTimestamp() {
		return updationTimestamp;
	}
	public void setUpdationTimestamp(String updationTimestamp) {
		this.updationTimestamp = updationTimestamp;
	}
	public NewNoteDto(Integer userid, String title, String description, String creationTimestamp,
			String updationTimestamp) {
		super();
		this.userid = userid;
		this.title = title;
		this.description = description;
		this.creationTimestamp = creationTimestamp;
		this.updationTimestamp = updationTimestamp;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public NewNoteDto() {
		// TODO Auto-generated constructor stub
	}
}
