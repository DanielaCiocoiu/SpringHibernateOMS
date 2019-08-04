package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.home.springboot.OMS.entity.Oms_order;
import com.home.springboot.OMS.service.Oms_orderService;

@RestController
@RequestMapping("/api")
public class Oms_orderRestController {

	private Oms_orderService oms_orderService;
	
	@Autowired
	public Oms_orderRestController(Oms_orderService theOms_orderService) {
		oms_orderService = theOms_orderService;
	}

	@GetMapping("/oms_orders")
	public List<Oms_order> findAll() {
		return oms_orderService.findAll();
	}
	
	@GetMapping("/oms_orders/{oms_order_id}")
	public Oms_order getOms_order(@PathVariable int oms_order_id) {
		Oms_order theOms_order = oms_orderService.findById(oms_order_id);
		return theOms_order;
	}
	// localhost:8080/api/Petro/oms_orders
	@GetMapping("/{user_name}/oms_orders")
	public List<Oms_order> getOms_order(
		@PathVariable String user_name) {
		List<Oms_order> theOms_userOrder = oms_orderService.findByUserName(user_name);
		return theOms_userOrder;
	}
	//Create Order  POST …/{user_name}/orders
	@PostMapping(value = "/{user_name}/oms_orders") 
	public Oms_order saveOms_order(
		@PathVariable String user_name,
		@RequestBody Oms_order order) { 
		order.setOrder_id(0);
		oms_orderService.save(order, user_name);
		return order; 
		
	}
	
	@PostMapping("/oms_orders")
	public Oms_order addOms_order(@RequestBody Oms_order theOms_order) {
	theOms_order.setOrder_id(0); 
		oms_orderService.save(theOms_order);
		return theOms_order;
	}
	
	@PutMapping("/oms_orders")
	public Oms_order updateOms_order(@RequestBody Oms_order theOms_order) {
		
		oms_orderService.save(theOms_order);

		return theOms_order;
	}
}
