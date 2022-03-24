package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Product;

public interface ProductService {
	 List<Product> findAll();
	 List<Product> findByName(String product_name);
	 Product findById(int product_id);
	 List<Product> findByCat(String cat);
	
}
