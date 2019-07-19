package com.home.springboot.OMS.dao;

import java.util.List;

import com.home.springboot.OMS.entity.Order;


public interface OrderDAO {
	public List<Order> findAll();
	public Order findById(int theId);
	public void save(Order theOrder);
	
	
}
