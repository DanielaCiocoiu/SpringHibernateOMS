package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	
	//@Qualifier("productDAOJpaImpl")
	
	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	

	@Override
	@Transactional
	public Product findByName(String productproduct_name) {
		return productDAO.findByName(productproduct_name);
		
	}

}
