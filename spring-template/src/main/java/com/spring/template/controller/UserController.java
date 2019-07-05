package com.spring.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.template.dto.User;
import com.spring.template.layer.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService<User> serviceUser;
		
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
	
}