package com.home.springboot.OMS.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.home.springboot.OMS.dao.Oms_orderDAO;
import com.home.springboot.OMS.dao.Oms_userDAO;
import com.home.springboot.OMS.entity.Oms_order;

@Service
public class Oms_orderServiceImpl implements Oms_orderService {

	private Oms_orderDAO oms_orderDAO;
	private Oms_userDAO oms_userDAO;
	
	@Autowired
	public Oms_orderServiceImpl(Oms_orderDAO theOms_orderDAO, Oms_userDAO theOms_userDAO) {
		oms_orderDAO = theOms_orderDAO;
		oms_userDAO = theOms_userDAO;
	}
	
	@Override
	@Transactional
	public List<Oms_order> findAll() {
		return oms_orderDAO.findAll();
	}

	@Override
	@Transactional
	public Oms_order findById(int theId) {
		return oms_orderDAO.findById(theId);
	}

	@Override
	public List<Oms_order> findByUserName(String user_name) {
		return oms_orderDAO.findByUserName(user_name);
	}
	
  @Override
	public void save(Oms_order theOms_order) {
		oms_orderDAO.save(theOms_order);
	}
	
	@Override
	public void save (Oms_order oms_order, String user_name) {
		 oms_orderDAO.save( oms_order, user_name); 
	}
	
	
}

