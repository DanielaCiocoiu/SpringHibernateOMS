package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findByName(String productproduct_name);
	public Product findById(int theId);
	
}
