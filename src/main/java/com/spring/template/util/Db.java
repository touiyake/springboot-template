package com.spring.template.util;

import lombok.experimental.FieldNameConstants;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Db {

	@FieldNameConstants
	public class Columns {
		
		public String id;
		public String username;
		public String firstname;
		public String lastname;
		
	}
	
}
