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

import com.home.springboot.OMS.entity.Order;
import com.home.springboot.OMS.entity.User;
import com.home.springboot.OMS.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;
	
	//injectez user dao
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	//expun "/users" si returnez lista de useri
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) { 
	//deleg catre user service
	User theUser= userService.findById(userId);
	if(theUser==null) {
		throw new RuntimeException("User is not found - " + userId);
	}
	return theUser;
	}
	
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User theUser) {
		
		// daca trimit un id in JSON il setez la 0
		// fortez salvarea unui nou item in loc sa fac update
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	

	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.update(theUser);
		
		return  theUser;
	}
}
