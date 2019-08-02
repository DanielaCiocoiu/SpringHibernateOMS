package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public List<Product> findByName(String product_name);
	public Product findById(int product_id);
	public List<Product> findByCat(String cat);
	
}
