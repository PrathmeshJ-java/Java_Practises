package com.psj.BlogApplicationrestapis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	
	private int category_id;
	
	@NotBlank
	@Size(min = 4)
	private String category_title;
	
	@NotBlank
	@Size(min = 10)
	private String category_description;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_title() {
		return category_title;
	}

	public void setCategory_title(String category_title) {
		this.category_title = category_title;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
