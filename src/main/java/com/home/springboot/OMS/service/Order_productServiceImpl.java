package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.Order_productDAO;
import com.home.springboot.OMS.entity.Order_product;

@Service
public class Order_productServiceImpl implements Order_productService {

	private Order_productDAO order_productDAO;
	
	@Autowired
	public Order_productServiceImpl(Order_productDAO theOrder_productDAO) {
		order_productDAO = theOrder_productDAO;
	}
	
	
	//@Qualifier("productDAOJpaImpl")
	
	@Override
	@Transactional
	public List<Order_product> findAll() {
		return order_productDAO.findAll();
	}

	

	@Override
	@Transactional
	public Order_product findById(int theId) {
		return order_productDAO.findById(theId);
		
	}

}
