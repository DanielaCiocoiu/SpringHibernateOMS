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
	public List<Product> findByName(String product_name) {
		return productDAO.findByName(product_name);
		
	}
	@Override
	@Transactional
		public Product findById(int product_id) {
		return productDAO.findById(product_id);
	}


	@Override
	public List<Product> findByCat(String cat) {
		return productDAO.findByCat(cat);
	}

}
