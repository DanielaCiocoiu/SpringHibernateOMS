package com.home.springboot.OMS.dao;

import java.util.List;

import com.home.springboot.OMS.entity.Product;

public interface ProductDAO {

	public List<Product> findAll();
	public List<Product> findByName(String product_name);
	public Product findById(int product_id);
	public List<Product> findByCat(String cat);
}
