package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.OrderDAO;
import com.home.springboot.OMS.entity.Order;



@Service
public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	@Autowired
	public OrderServiceImpl(OrderDAO theOrderDAO) {
		orderDAO = theOrderDAO;
	}
	
	@Override
	@Transactional
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

	

	@Override
	@Transactional
	public Order findById(int theId) {
		return orderDAO.findById(theId);
		
	}


	@Override
	public void save(Order theOrder) {
		orderDAO.save(theOrder);
		
	}

}
