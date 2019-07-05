package com.spring.template.layer.dao;

import java.io.Serializable;

import com.spring.template.abstracts.BasicOperations;

public interface UserDao<T extends Serializable> extends BasicOperations<T> {

}