package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Oms_order> findAll(){
		return oms_orderService.findAll();
	}
	
	
	// mapez GET /orde/{orderId}
	
		@GetMapping("/oms_orders/{oms_orderId}")
		public Oms_order getOms_order(@PathVariable int oms_orderId) {
			
			Oms_order theOms_order = oms_orderService.findById(oms_orderId);
			
			if (theOms_order == null) {
				throw new RuntimeException("Oms_order id not found - " + oms_orderId);
			}
			
			return theOms_order;
		}
		
		// aduc new ordep
		
		@PostMapping("/oms_orders")
		public Oms_order addOms_order(@RequestBody Oms_order theOms_order) {
			
			// daca trimit un id in JSON il setez la 0
			// fortez salvarea unui nou item in loc sa fac update
			
			theOms_order.setOrder_id(0);  //setId(0);
			
			oms_orderService.save(theOms_order);
			
			return theOms_order;
		}
		
		
		
		@PutMapping("/oms_orders")
		public Oms_order updateOms_order(@RequestBody Oms_order theOms_order) {
			
			oms_orderService.save(theOms_order);
			
			return theOms_order;
		}
		
}
