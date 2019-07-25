package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.ProductDAO;
import com.home.springboot.OMS.entity.Category;
import com.home.springboot.OMS.entity.Oms_user;
import com.home.springboot.OMS.entity.Product;
import com.home.springboot.OMS.service.CategoryService;
import com.home.springboot.OMS.service.ProductService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	private CategoryService categoryService;
	
	//injectez product dao
	@Autowired
	public CategoryRestController(CategoryService theCategoryService) {
		categoryService = theCategoryService;
	}
	
	//expun "/products" si returnez lista de produse
	
	@GetMapping("/category")
	public List<Category> findAll(){
		return categoryService.findAll();
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

}
