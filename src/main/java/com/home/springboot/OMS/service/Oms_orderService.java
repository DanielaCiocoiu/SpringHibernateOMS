package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Oms_order;

public interface Oms_orderService {
	public List<Oms_order> findAll();
	public Oms_order findById(int theId);
	public void save(Oms_order theOms_order);
	public Oms_order findByUserName(String user_name);
	
	
}
