package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Order;

public interface OrderService {
	public List<Order> findAll();
	public Order findById(int theId);
	public void save(Order theOrder); 
	
}
