package com.home.springboot.OMS.service;

import java.util.List;

import com.home.springboot.OMS.entity.Oms_user;

public interface Oms_userService {
	 List<Oms_user> findAll();
	 Oms_user findById(int theId);
	 void save(Oms_user theOms_user);
	 void update(Oms_user theOms_user);
	
}
