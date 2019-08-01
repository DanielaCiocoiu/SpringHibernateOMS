package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.OMS.dao.Oms_orderDAO;
import com.home.springboot.OMS.dao.Oms_userDAO;

import com.home.springboot.OMS.entity.Oms_user;
@Service
public class Oms_userServiceImpl implements Oms_userService {

	private Oms_userDAO oms_userDAO;
	

	@Autowired
	public Oms_userServiceImpl(Oms_userDAO theOms_userDAO) {
		oms_userDAO = theOms_userDAO;
	}
	
	@Override
	@Transactional
	public List<Oms_user> findAll() {
		return oms_userDAO.findAll();
	}

	@Override
	@Transactional
	public Oms_user findById(int theId) {
		return oms_userDAO.findById(theId);
		
	}
	@Override
	public void save(Oms_user theOms_user) {
		oms_userDAO.save(theOms_user);
		
	}

	@Override
	public void update(Oms_user theOms_user) {
		oms_userDAO.update(theOms_user);
		
	}



}
