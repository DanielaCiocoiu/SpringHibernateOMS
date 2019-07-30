package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService theProductService) {
		productService = theProductService;
	}

	@GetMapping("/products")

	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product theProduct = productService.findById(productId);
		if (theProduct == null) {
			throw new RuntimeException("Product is not found - " + productId);
		}
		return theProduct;
	}

	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId,
			@RequestParam(value = "product_name", required = true) String product_name,
			@RequestParam(value = "category_id", required = true) String category_id,
			@RequestParam(value = "description", required = true) String description) {

		// deleg catre user service
		Product theProduct = productService.findById(productId);
		if (theProduct == null) {
			throw new RuntimeException("Product is not found - " + productId);
		}
		return theProduct;
	}

	// http://localhost:8080/api/products/2?product_name=TV&category_id=2

//	@GetMapping("/product/{theproduct_name}")
//	public Product getProduct(@PathVariable String theproduct_name) { 
//
//		Product theProduct= productService.findByName(theproduct_name);
//	if(theProduct==null) {
//		throw new RuntimeException("Product is not found - " + theproduct_name);
//	}
//	return theProduct;
//	}

//	@GetMapping("/productNames/{productId}")
//	@ResponseBody
//	public String getProductName (
//			@PathVariable(value="productId") int productId,
//			@RequestParam(value="product_name", required=true) String product_name, 
//			@RequestParam (value="category_id", required=true) String category_id
//			){
//		
//		return "product_name: " + product_name + " " + "category_id: " + category_id;
//	}

}
