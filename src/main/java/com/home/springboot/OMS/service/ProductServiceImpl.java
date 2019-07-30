package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO theProductDAO) {
		productDAO = theProductDAO;
	}
	
	
	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	
	@Override
	@Transactional
	public Product findByName(String theproduct_name) {
		return productDAO.findByName(theproduct_name);
		
	}
	@Override
	@Transactional
		public Product findById(int theId) {
		return productDAO.findById(theId);
	}

}
