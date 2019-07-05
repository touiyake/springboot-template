package com.spring.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.template.dto.User;
import com.spring.template.layer.service.UserServiceJdbc;

@RestController
@RequestMapping("/jdbc")
public class UserJdbcController {

	@Autowired
	private UserServiceJdbc<User> serviceUser;
	
	@PostMapping("/user/create")
	public ResponseEntity<Void> create(@RequestBody User user) {
		boolean response = this.serviceUser.create(user);
		if (response) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/user/id/{id}")
	public ResponseEntity<User> findOneById(@PathVariable("id") long id) {
		User user = this.serviceUser.findOneById(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = this.serviceUser.findAll();
		if (list.size() > 0) {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		boolean result = this.serviceUser.update(user);
		if (result) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/user/delete")
	public ResponseEntity<Void> delete(@RequestBody User user) {
		boolean result = this.serviceUser.delete(user);
		if (result) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}