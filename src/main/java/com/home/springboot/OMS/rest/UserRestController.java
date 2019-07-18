package com.home.springboot.OMS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.springboot.OMS.dao.UserDAO;
import com.home.springboot.OMS.entity.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserDAO userDAO;
	
	//injectez product dao
	@Autowired
	public UserRestController(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	//expun "/products" si returnez lista de produse
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userDAO.findAll();
	}
	
}
