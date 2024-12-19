package com.psj.BlogApplicationrestapis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

public class UserDto {
	
	private int user_id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be minimum 4 characters")
	private String name;
	
	@Email(message = "must be a well-formed email address")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be minimum 3 characters and maximum 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public UserDto(int user_id, String name, String email, String password, String about) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
