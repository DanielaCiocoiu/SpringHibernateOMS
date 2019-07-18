package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Orderp;

public interface OrderpService {
	public List<Orderp> findAll();
	public Orderp findById(int theId);
	public void save(Orderp theOrderp); 
	
}
