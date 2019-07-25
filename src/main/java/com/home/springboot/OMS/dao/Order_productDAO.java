package com.home.springboot.OMS.dao;

import java.util.List;

import com.home.springboot.OMS.entity.Oms_user;
import com.home.springboot.OMS.entity.Order_product;


public interface Order_productDAO {
	public List< Order_product> findAll();
	public  Order_product findById(int theId);
	 
}
