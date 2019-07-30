package com.home.springboot.OMS.dao;

import java.util.List;

import com.home.springboot.OMS.entity.Product;

public interface ProductDAO {

	public List<Product> findAll();
	public Product findByName(String theproduct_name);
	public Product findById(int theId);
}
