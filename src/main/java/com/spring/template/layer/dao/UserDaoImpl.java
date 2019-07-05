package com.spring.template.layer.dao;

import org.springframework.stereotype.Repository;

import com.spring.template.abstracts.AbstractHibernateDao;
import com.spring.template.dto.User;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> 
	implements UserDao<User> {

	public UserDaoImpl() {
		super();
		super.setKlazz(User.class);
	}
	
}
