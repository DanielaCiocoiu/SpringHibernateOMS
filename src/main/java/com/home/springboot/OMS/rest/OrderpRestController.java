package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.OrderpDAO;
import com.home.springboot.OMS.entity.Orderp;

@RestController
@RequestMapping("/api")
public class OrderpRestController {

	private OrderpDAO orderpDAO;
	
	
	@Autowired
	public OrderpRestController(OrderpDAO theOrderpDAO) {
		orderpDAO = theOrderpDAO;
	}
	

	
	@GetMapping("/orderps")
	public List<Orderp> findAll(){
		return orderpDAO.findAll();
	}
	
}
