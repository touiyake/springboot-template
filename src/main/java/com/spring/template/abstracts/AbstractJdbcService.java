package com.spring.template.abstracts;

import java.io.Serializable;

public abstract class AbstractJdbcService<T extends Serializable> extends AbstractService<T>
	implements BasicOperations<T> {

	/** 
	 * Will automatically use all the superclass' (AbstractService) methods
	 * 
	 * */

}
