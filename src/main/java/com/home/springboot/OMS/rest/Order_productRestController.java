package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Oms_user;
import com.home.springboot.OMS.entity.Order_product;
import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.service.Order_productService;
import com.home.springboot.OMS.service.ProductService;

@RestController
@RequestMapping("/api")
public class Order_productRestController {

	private Order_productService order_productService;
	
	//injectez product dao
	@Autowired
	public Order_productRestController(Order_productService theOrder_productService) {
		order_productService = theOrder_productService;
	}
	
	//expun "/products" si returnez lista de produse
	
	@GetMapping("/order_products")
	public List<Order_product> findAll(){
		return order_productService.findAll();
	}
	
	@GetMapping("/order_products/{order_productsId}")
	public Order_product getOrder_product(@PathVariable int order_productsId) { 
	//deleg catre user service
		Order_product theOrder_product= order_productService.findById(order_productsId);
	if(theOrder_product==null) {
		throw new RuntimeException("Order_product is not found - " + order_productsId);
	}
	return theOrder_product;
	}
	
	


}
