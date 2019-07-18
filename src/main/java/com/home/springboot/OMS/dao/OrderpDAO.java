package com.home.springboot.OMS.dao;

import java.util.List;



import com.home.springboot.OMS.entity.Orderp;

public interface OrderpDAO {
	public List<Orderp> findAll();
	public Orderp findById(int theId);
	public void save(Orderp theOrderp);
	
	
}
