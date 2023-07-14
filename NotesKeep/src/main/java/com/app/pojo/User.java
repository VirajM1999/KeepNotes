package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User extends Baseclass {
	
	@Column(length=25,nullable = false)
	private String name;
	@Column(unique = true,length=25,nullable = false)
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Notes> notes=new ArrayList<>();
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User( String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addnotes(Notes note){
		this.notes.add(note);
	}
	public void removenote(Notes note){
		this.notes.remove(note);
	}
	public List<Notes> getNotes() {
		return notes;
	}
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}
	
	
	

}
