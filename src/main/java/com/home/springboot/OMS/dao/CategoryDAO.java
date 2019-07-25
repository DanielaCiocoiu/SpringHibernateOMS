package com.home.springboot.OMS.dao;

import java.util.List;

import com.home.springboot.OMS.entity.Category;


public interface CategoryDAO {

	public List<Category> findAll();
	public Category findById(int theId);

}
