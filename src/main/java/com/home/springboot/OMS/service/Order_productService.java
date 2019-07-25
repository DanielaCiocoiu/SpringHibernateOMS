package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Order_product;

public interface Order_productService {
	public List<Order_product> findAll();
	public Order_product findById(int theId);
	
}
