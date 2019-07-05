package com.spring.template.layer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.template.abstracts.AbstractHibernateService;
import com.spring.template.abstracts.BasicOperations;
import com.spring.template.dto.User;
import com.spring.template.layer.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl extends AbstractHibernateService<User> 
	implements UserService<User> {

	@Autowired
	private UserDao<User> dao;
	
	public UserServiceImpl() {
		super();
	}
	
	@Override
	protected BasicOperations<User> getDao() {
		return this.dao;
	}

	
}
