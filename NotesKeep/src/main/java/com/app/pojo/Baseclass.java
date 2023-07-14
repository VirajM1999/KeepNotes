package com.app.pojo;

import javax.persistence.*;

import lombok.*;

@MappedSuperclass

public class Baseclass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Baseclass(Integer id) {
		super();
		Id = id;
	}

	public Baseclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
