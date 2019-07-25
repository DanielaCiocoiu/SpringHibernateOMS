package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Oms_user;
import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductService productService;
	
	//injectez product dao
	@Autowired
	public ProductRestController(ProductService theProductService) {
		productService = theProductService;
	}
	
	//expun "/products" si returnez lista de produse
	
	@GetMapping("/products")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	
//	@GetMapping("/product/{productId}")
//	public Product getProduct(@PathVariable int productId) { 
//	//deleg catre user service
//		Product theProduct= productService.findById(productId);
//	if(theProduct==null) {
//		throw new RuntimeException("Product is not found - " + productId);
//	}
//	return theProduct;
//	}
//	
	
	@GetMapping("/product/{productproduct_name}")
	public Product getProduct(@PathVariable String productproduct_name) { 
	//deleg catre user service
		Product theProduct= productService.findByName(productproduct_name);
	if(theProduct==null) {
		throw new RuntimeException("Product is not found - " + productproduct_name);
	}
	return theProduct;
	}
	


}
