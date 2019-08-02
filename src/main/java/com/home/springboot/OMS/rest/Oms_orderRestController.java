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

	// Retrieve Order GET …/{user_name}/oms_orders
	// localhost:8080/api/Petro/oms_orders
	@GetMapping("/{user_name}/oms_orders")
	public List<Oms_order> getOms_order(
		@PathVariable String user_name) {
		List<Oms_order> theOms_userOrder = oms_orderService.findByUserName(user_name);
		return theOms_userOrder;
	}

	//  Create Order  POST …/{user_name}/orders
	@PostMapping("/{user_name}/oms_orders") 
	public Oms_order addOms_order(

		@RequestBody Oms_order theOms_orderUser, 
		@PathVariable String user_name) { //de injectat user service, look up dupa user name si de salvat in order

		theOms_orderUser.setOrder_id(0);

		oms_orderService.save(theOms_orderUser);
		
		return theOms_orderUser;
	}


	// Update Order PUT …/{user_name}/orders/{id}
	@PutMapping("/{user_name}/oms_order_id")
	public Oms_order updateOms_order(@RequestBody Oms_order theOms_orderPutUser,
			@RequestParam(value = "user_name", required = true) String user_name, @PathVariable int oms_order_id) {

		if (theOms_orderPutUser.getOrder_id() == 0) {
			throw new RuntimeException("order_id is 0 or not present in the request");
		}
		oms_orderService.save(theOms_orderPutUser);

		return theOms_orderPutUser;
	}

//	@PostMapping("/oms_orders")
//	public Oms_order addOms_order(@RequestBody Oms_order theOms_order) {
//
//		theOms_order.setOrder_id(0); // setId(0);
//
//		oms_orderService.save(theOms_order);
//
//		return theOms_order;
//	}
	
//	@PutMapping("/oms_orders")
//	public Oms_order updateOms_order(@RequestBody Oms_order theOms_order) {
//		if (theOms_order.getOrder_id() == 0) {
//			throw new RuntimeException("order_id is 0 or not present in the request");
//		}
//		oms_orderService.save(theOms_order);
//
//		return theOms_order;
//	}
}
