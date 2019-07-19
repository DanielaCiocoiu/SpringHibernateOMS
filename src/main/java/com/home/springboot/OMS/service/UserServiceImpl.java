package com.home.springboot.OMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.home.springboot.OMS.dao.UserDAO;

import com.home.springboot.OMS.entity.User;
@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theuserDAO) {
		userDAO = theuserDAO;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	

	@Override
	@Transactional
	public User findById(int theId) {
		return userDAO.findById(theId);
		
	}


	@Override
	public void save(User theUser) {
		userDAO.save(theUser);
		
	}

	@Override
	public void update(User theUser) {
		userDAO.update(theUser);
		
	}

}
