package com.yablokovs.microservices.model;

import java.time.LocalDate;
import java.util.Date;

public class User {
	
	private Long id;
	
	private String name;
	
	private LocalDate birthDate;
	
	public User() {}

	public User(Long id, String name, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public User(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Long getId() {
		return id;
	}
	
	public boolean setId(Long id) {
		this.id = id;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
