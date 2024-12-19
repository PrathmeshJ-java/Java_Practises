package com.psj.BlogApplicationrestapis.services;

import java.util.List;

import com.psj.BlogApplicationrestapis.payloads.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto category);
	
	CategoryDto updateCategory(CategoryDto category, int categoryId);
	
	void deleteCategory(int categoryId);
	
	CategoryDto getCategory(int categoryId);
	
	List<CategoryDto> getAllCategory();
	
}
