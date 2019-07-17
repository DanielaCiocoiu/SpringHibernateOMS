package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Product;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductDAO productDAO;
	
	//injectez product dao
	@Autowired
	public ProductRestController(ProductDAO theProductDAO) {
		productDAO = theProductDAO;
	}
	
	//expun "/products" si returnez lista de produse
	
	@GetMapping("/products")
	public List<Product> findAll(){
		return productDAO.findAll();
	}
	
}
