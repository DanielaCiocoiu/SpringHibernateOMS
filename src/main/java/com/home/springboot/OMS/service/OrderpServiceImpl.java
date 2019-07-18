package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.OrderpDAO;
import com.home.springboot.OMS.entity.Orderp;



@Service
public class OrderpServiceImpl implements OrderpService {

	private OrderpDAO orderpDAO;
	
	@Autowired
	public OrderpServiceImpl(OrderpDAO theOrderpDAO) {
		orderpDAO = theOrderpDAO;
	}
	
	@Override
	@Transactional
	public List<Orderp> findAll() {
		return orderpDAO.findAll();
	}

	

	@Override
	@Transactional
	public Orderp findById(int theId) {
		return orderpDAO.findById(theId);
		
	}


	@Override
	public void save(Orderp theOrderp) {
		orderpDAO.save(theOrderp);
		
	}

}
