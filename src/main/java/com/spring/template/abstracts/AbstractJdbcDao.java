package com.spring.template.abstracts;

import java.util.ArrayList;
import java.util.List;

import com.library.collection.DataRow;
import com.library.collection.DataRowCollection;
import com.library.jdbc.database.DbWrapper;
import com.library.jdbc.database.DbWrapperFactory;
import com.spring.template.exception.DaoException;

public abstract class AbstractJdbcDao {

	protected DbWrapper db = DbWrapperFactory.getDb();
	protected StringBuilder sql;
	protected List<Object> params;
	
	protected void newObject() {
		this.sql = new StringBuilder();
		this.params = new ArrayList<Object>();
	}

	protected boolean executeUpdate() throws Exception {
		if (!(this.db.QueryUpdate(this.sql.toString(), this.params) > 0)) {
			throw new DaoException("QueryUpdate failed.");
		}
		return true;
	}
	
	protected DataRow executeDataRow() throws Exception {
		DataRow row = this.db.QueryDataRow(this.sql.toString(), this.params);
		if (row != null && !row.isEmpty()) {
			return row;
		}
		throw new DaoException("No record found.");
	}
	
	protected DataRowCollection executeDataRows() throws Exception {
		DataRowCollection rows =  this.db.QueryDataRows(this.sql.toString(), this.params);
		if (rows.size() > 0) {
			return rows;
		}
		throw new DaoException("No record(s) found.");
	}

}