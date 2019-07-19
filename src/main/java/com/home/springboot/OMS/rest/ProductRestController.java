package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.ProductDAO;
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
	
//	@GetMapping(path = {"/{id}"})
//	public ResponseEntity<Product> findById(@PathVariable int id){
//	  return repository.findById(id)
//	          .map(record -> ResponseEntity.ok().body(record))
//	          .orElse(ResponseEntity.notFound().build());
//	}
}
