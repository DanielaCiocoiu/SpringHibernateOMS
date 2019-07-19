package com.home.springboot.OMS.dao;

import java.util.List;


import com.home.springboot.OMS.entity.User;

public interface UserDAO {
	public List<User> findAll();
	public User findById(int theId);
	public void save(User theUser);
	public void update(User theUser); 
}
