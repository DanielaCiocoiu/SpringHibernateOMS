package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findById(int theId);
	
}
