package com.springbootsql.dto;

import java.util.List;

import com.springbootsql.Entities.Hotel;
import com.springbootsql.Entities.Rating;

import lombok.Builder;

@Builder

public class UserDto {

	private String id;

	private String name;
	private String email;
	private String about;
	private List<Rating> rating;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

}
