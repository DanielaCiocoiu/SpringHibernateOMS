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

import com.home.springboot.OMS.dao.OrderDAO;
import com.home.springboot.OMS.entity.Order;
import com.home.springboot.OMS.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderRestController {

	private OrderService orderService;
	
	
	@Autowired
	public OrderRestController(OrderService theOrderService) {
		orderService = theOrderService;
	}
	

	
	@GetMapping("/orders")
	public List<Order> findAll(){
		return orderService.findAll();
	}
	
	
	// mapez GET /orde/{orderId}
	
		@GetMapping("/orders/{orderId}")
		public Order getOrder(@PathVariable int orderId) {
			
			Order theOrder = orderService.findById(orderId);
			
			if (theOrder == null) {
				throw new RuntimeException("Order id not found - " + orderId);
			}
			
			return theOrder;
		}
		
		// aduc new ordep
		
		@PostMapping("/orders")
		public Order addOrder(@RequestBody Order theOrder) {
			
			// daca trimit un id in JSON il setez la 0
			// fortez salvarea unui nou item in loc sa fac update
			
			theOrder.setId(0);
			
			orderService.save(theOrder);
			
			return theOrder;
		}
		
		
		
		@PutMapping("/orders")
		public Order updateOrder(@RequestBody Order theOrder) {
			
			orderService.save(theOrder);
			
			return theOrder;
		}
		
}
