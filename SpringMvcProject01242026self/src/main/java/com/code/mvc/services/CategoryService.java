package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.Category;

public interface CategoryService {
	// declare the method that we want for the student
	public int add(Category category);

	public int update(Category category);

	public int delete(Category category);

	public int delete(int id);

	// create some method to get the student
	public List<Category> getAll();

	public Category getById(int id);

	public Category getCategoryByName(String catname);

	public List<Category> search(String catname);
}
