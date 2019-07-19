package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int theId);
	public void save(User theUser); 
	public void update(User theUser); 
}
