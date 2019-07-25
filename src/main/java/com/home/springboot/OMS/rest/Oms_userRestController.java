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

import com.home.springboot.OMS.entity.Oms_user;
import com.home.springboot.OMS.service.Oms_userService;

@RestController
@RequestMapping("/api")
public class Oms_userRestController {

	private Oms_userService oms_userService;
	
	//injectez user dao
	@Autowired
	public Oms_userRestController(Oms_userService theOms_userService) {
		oms_userService = theOms_userService;
	}
	
	//expun "/users" si returnez lista de useri
	
	@GetMapping("/oms_users")
	public List<Oms_user> findAll(){
		return oms_userService.findAll();
	}
	
	@GetMapping("/oms_users/{oms_userId}")
	public Oms_user getOms_user(@PathVariable int oms_userId) { 
	//deleg catre user service
		Oms_user theOms_user= oms_userService.findById(oms_userId);
	if(theOms_user==null) {
		throw new RuntimeException("Oms_user is not found - " + oms_userId);
	}
	return theOms_user;
	}
	
	
	@PostMapping("/oms_users")
	public Oms_user saveOms_user(@RequestBody Oms_user theOms_user) {
		
		// daca trimit un id in JSON il setez la 0
		// fortez salvarea unui nou item in loc sa fac update
		
		theOms_user.setId(0);
		
		oms_userService.save(theOms_user);
		
		return theOms_user;
	}
	

	
	@PutMapping("/oms_users")
	public Oms_user updateOms_user(@RequestBody Oms_user theOms_user) {
		
		oms_userService.update(theOms_user);
		
		return  theOms_user;
	}
}
