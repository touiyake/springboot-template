package com.spring.template.abstracts;

import java.io.Serializable;

import com.google.common.base.Preconditions;

public abstract class AbstractDao<T extends Serializable> 
	implements BasicOperations<T> {

	protected Class<T> klazz;
	
	protected final void setKlazz(final Class<T> klazz) {
		this.klazz = Preconditions.checkNotNull(klazz);
	}

}