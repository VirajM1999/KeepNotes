package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotesUpdateDto {
	
	private Integer notesId;
	
	private String Description;
	
	private LocalDateTime updatedate;

	

	public NotesUpdateDto(Integer notesId, String description, LocalDateTime updatedate) {
		super();
		this.notesId = notesId;
		Description = description;
		this.updatedate = updatedate;
	}

	public Integer getNotesId() {
		return notesId;
	}

	public void setNotesId(Integer notesId) {
		this.notesId = notesId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDateTime getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDateTime updatedate) {
		this.updatedate = updatedate;
	}

	public NotesUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NotesUpdateDto [Description=" + Description + ", updatedate=" + updatedate + "]";
	}
	
	
	
}
