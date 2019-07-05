package com.spring.template.abstracts;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractHibernateService<T extends Serializable> extends AbstractService<T>
	implements BasicOperations<T> {
	
	/** 
	 * Will automatically use all the superclass' (AbstractService) methods
	 * 
	 * */

}