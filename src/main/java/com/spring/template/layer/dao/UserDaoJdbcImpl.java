package com.spring.template.layer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.collection.DataRow;
import com.spring.template.abstracts.AbstractJdbcDao;
import com.spring.template.dto.User;

@Repository
public class UserDaoJdbcImpl extends AbstractJdbcDao 
	implements UserDaoJdbc<User> {

	@Override
	public User findOneById(long id) {
		try {
			super.newObject();
			super.sql.append("SELECT * FROM account_user WHERE ID=?");
			super.params.add(id);
			DataRow row = super.executeDataRow();
			User user = new User();
			user.setId(row.getLong("id"));
			user.setUsername(row.getString("username"));
			user.setFirstName(row.getString("firstname"));
			user.setLastName(row.getString("lastname"));
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findOneByKeyVal(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllByKeyVal(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean merge(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(long entityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}