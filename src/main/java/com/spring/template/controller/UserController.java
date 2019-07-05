package com.spring.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.template.dto.User;
import com.spring.template.layer.service.UserService;
import com.spring.template.layer.service.UserServiceJdbc;

@RestController
public class UserController {
	
	@Autowired
	private UserService<User> serviceUser;
	
	@Autowired
	private UserServiceJdbc<User> serviceUserJdbc;
		
	@GetMapping("/test")
	public ResponseEntity<Void> test() {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/save-user")
	public ResponseEntity<Void> saveUser(@RequestBody User user) {
		boolean result = this.serviceUser.create(user);
		System.out.println("Result: " + result);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") long id) {
		User user = null;
		try {
			user = this.serviceUserJdbc.findOneById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
		}
	}

}