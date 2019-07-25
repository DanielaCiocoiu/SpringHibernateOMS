package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category findById(int theId);
	
}
