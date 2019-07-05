package com.spring.template.abstracts;

import com.library.jdbc.database.DbWrapper;
import com.library.jdbc.database.DbWrapperFactory;

public abstract class AbstractCommon {

	protected DbWrapper db = DbWrapperFactory.getDb();
	
}
