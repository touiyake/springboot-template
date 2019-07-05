package com.spring.template.layer.service;

import java.io.Serializable;

import com.spring.template.abstracts.BasicOperations;

public interface UserService<T extends Serializable> extends BasicOperations<T> {

}