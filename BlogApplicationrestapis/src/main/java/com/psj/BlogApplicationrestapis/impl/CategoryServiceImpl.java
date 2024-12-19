package com.psj.BlogApplicationrestapis.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psj.BlogApplicationrestapis.Entities.Category;
import com.psj.BlogApplicationrestapis.exceptions.ResourceNotFoundException;
import com.psj.BlogApplicationrestapis.payloads.CategoryDto;
import com.psj.BlogApplicationrestapis.repositories.CategoryRepository;
import com.psj.BlogApplicationrestapis.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository cateRepository;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	@Override
	public CategoryDto createCategory(CategoryDto category) {
		Category cat = this.modelMapper.map(category, Category.class);
		Category addCategory = this.cateRepository.save(cat);
		return this.modelMapper.map(addCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto category, int categoryId) {
		Optional<Category> existingCategory = Optional.of(this.cateRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id" , categoryId)));
		Category cat = existingCategory.get();
		cat.setCategory_title(category.getCategory_title());
		cat.setCategory_description(category.getCategory_description());
		Category updateCategory = this.cateRepository.save(cat);
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int categoryId) {
		Optional<Category> existingcategory = Optional.of(this.cateRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id" , categoryId)));
		if(existingcategory.isPresent()) {
			this.cateRepository.deleteById(categoryId);
		}
	}

	@Override
	public CategoryDto getCategory(int categoryId) {
		Optional<Category> existingcategory = Optional.of(this.cateRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id" , categoryId)));
		return this.modelMapper.map(existingcategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.cateRepository.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map((cat)-> 
		                                   this.modelMapper.map(cat, CategoryDto.class)).
				                           collect(Collectors.toList());
		return categoryDtos;
	}

}
