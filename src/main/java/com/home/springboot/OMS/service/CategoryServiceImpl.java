package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.CategoryDAO;
import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Category;
import com.home.springboot.OMS.entity.Product;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	
	@Autowired
	public CategoryServiceImpl(CategoryDAO theCategoryDAO) {
		categoryDAO = theCategoryDAO;
	}
	
	
	//@Qualifier("productDAOJpaImpl")
	
	@Override
	@Transactional
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	

	@Override
	@Transactional
	public Category findById(int theId) {
		return categoryDAO.findById(theId);
		
	}

}
