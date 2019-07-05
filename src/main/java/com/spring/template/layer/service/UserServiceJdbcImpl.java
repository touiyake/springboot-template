package com.spring.template.layer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.template.abstracts.AbstractJdbcService;
import com.spring.template.abstracts.BasicOperations;
import com.spring.template.dto.User;
import com.spring.template.layer.dao.UserDaoJdbc;

@Service
public class UserServiceJdbcImpl extends AbstractJdbcService<User> 
	implements UserServiceJdbc<User> {

	@Autowired
	private UserDaoJdbc<User> dao;
	
	public UserServiceJdbcImpl() {
		super();
	}
	
	@Override
	protected BasicOperations<User> getDao() {
		return this.dao;
	}

}
