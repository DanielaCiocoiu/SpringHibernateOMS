package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.entity.Oms_order;
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

	@GetMapping("/products/{productId}")
	public Product getProductId(@PathVariable int productId) {
		Product theProduct = productService.findById(productId);
		if (theProduct == null) {
			throw new RuntimeException("Product ID is not found - " + productId);
		}
		return theProduct;
	}

	@GetMapping("/{product_name}/products")
	public List<Product> getProductName(@PathVariable String product_name) {
		List<Product> theProductName = productService.findByName(product_name);

		return theProductName;
	}

	// localhost:8080/api/?cat=TV/product
	@GetMapping("/?cat=TV/product")
	public List<Product> getProduct(@RequestParam(value = "TV", required = true) String cat) {
		List<Product> theCatProduct = productService.findByCat(cat); // lista de produse
		if (theCatProduct == null) {
			throw new RuntimeException("Product is not found - " + cat);
		}
		return theCatProduct;
	}

}
