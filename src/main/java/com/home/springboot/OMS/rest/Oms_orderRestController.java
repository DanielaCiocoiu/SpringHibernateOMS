package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.entity.Oms_order;
import com.home.springboot.OMS.entity.Product;
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

		if (theOms_order == null) {
			throw new RuntimeException("Oms_order id not found - " + oms_order_id);
		}

		return theOms_order;
	}
	
	// Retrieve Order GET …/{username}/orders/{id}
	// http://localhost:8080/api/oms_orders/5?Petro
	@GetMapping("/{username}/oms_orders/{oms_order_id}")
	public Oms_order getOms_order(@RequestParam(value = "username", required = true) String username,

			@PathVariable int oms_order_id) {

		Oms_order theOms_order = oms_orderService.findById(oms_order_id);

		if (theOms_order == null) {
			throw new RuntimeException("Oms_order id not found - " + oms_order_id);
		}

		return theOms_order;
	}
	

	@PostMapping("/oms_orders")
	public Oms_order addOms_order(@RequestBody Oms_order theOms_order) {

		theOms_order.setOrder_id(0); // setId(0);

		oms_orderService.save(theOms_order);

		return theOms_order;
	}
	

//  Create Order  POST …/{username}/orders
	@PostMapping("/{username}/oms_orders")
	public Oms_order addOms_order(
			
			@RequestBody Oms_order theOms_orderUser,
			@RequestParam(value = "username", required = true) String username,
			@PathVariable int oms_order_id) {

		theOms_orderUser.setOrder_id(0);

		oms_orderService.save(theOms_orderUser);

		return theOms_orderUser;
	}
	

	@PutMapping("/oms_orders")
	public Oms_order updateOms_order(@RequestBody Oms_order theOms_order) {
		if(theOms_order.getOrder_id() == 0){
			throw new RuntimeException("order_id is 0 or not present in the request");
		}
		oms_orderService.save(theOms_order);

		return theOms_order;
	}
	
	
//	Update Order  PUT …/{username}/orders/{id}
	@PutMapping("/{username}/oms_order_id")
	public Oms_order updateOms_order(
			@RequestBody Oms_order theOms_orderPutUser,
			@RequestParam(value = "username", required = true) String username,
			@PathVariable int oms_order_id) {

		if(theOms_orderPutUser.getOrder_id() == 0){
			throw new RuntimeException("order_id is 0 or not present in the request");
		}
		oms_orderService.save(theOms_orderPutUser);

		return theOms_orderPutUser;
	}
	
}
