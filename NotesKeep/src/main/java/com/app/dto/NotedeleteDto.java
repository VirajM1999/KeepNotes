package com.app.dto;

public class NotedeleteDto {
    private Integer userId;
    private Integer noteId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public NotedeleteDto(Integer userId, Integer noteId) {
		super();
		this.userId = userId;
		this.noteId = noteId;
	}
	public NotedeleteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
