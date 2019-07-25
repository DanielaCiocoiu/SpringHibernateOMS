package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.entity.Oms_user;

public interface Oms_userService {
	public List<Oms_user> findAll();
	public Oms_user findById(int theId);
	public void save(Oms_user theOms_user); 
	public void update(Oms_user theOms_user); 
}
