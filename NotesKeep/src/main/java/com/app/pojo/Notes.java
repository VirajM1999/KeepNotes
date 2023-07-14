package com.app.pojo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity

@Table(name="notes")
public class Notes extends Baseclass{
	private String title;
	private String description;
	private LocalDateTime creationTimestamp;
	@CreationTimestamp
	private LocalDateTime updationTimestamp;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
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
	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public LocalDateTime getUpdationTimestamp() {
		return updationTimestamp;
	}
	public void setUpdationTimestamp(LocalDateTime updationTimestamp) {
		this.updationTimestamp = updationTimestamp;
	}
	public Notes(String title, String description, LocalDateTime creationTimestamp, User user) {
		this.title = title;
		this.description = description;
		this.creationTimestamp = creationTimestamp;
		this.user = user;
	}
	public Notes() {
		// TODO Auto-generated constructor stub
	}
	
	
}