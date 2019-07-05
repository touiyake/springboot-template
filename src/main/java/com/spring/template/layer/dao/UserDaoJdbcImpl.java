package com.spring.template.layer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.collection.DataRow;
import com.spring.template.abstracts.AbstractJdbcDao;
import com.spring.template.dto.User;
import com.spring.template.util.Db;

@Repository
public class UserDaoJdbcImpl extends AbstractJdbcDao 
	implements UserDaoJdbc<User> {

	@Override
	public User findOneById(long id) {
		try {
			super.newObject();
			super.sql.append("SELECT * FROM account_user WHERE id=?");
			super.params.add(id);
			DataRow row = super.executeDataRow();
			User user = new User();
			user.setId(row.getLong(Db.Columns.Fields.id));
			user.setUsername(row.getString(Db.Columns.Fields.username));
			user.setFirstName(row.getString(Db.Columns.Fields.firstname));
			user.setLastName(row.getString(Db.Columns.Fields.lastname));
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
		try {
			super.newObject();
			super.sql.append("SELECT * FROM account_user ORDER BY 1");
			List<User> list = new ArrayList<User>();
			super.executeDataRows()
				.forEach(row -> {
					User user = new User();
					user.setId(row.getLong(Db.Columns.Fields.id));
					user.setUsername(row.getString(Db.Columns.Fields.username));
					user.setFirstName(row.getString(Db.Columns.Fields.firstname));
					user.setLastName(row.getString(Db.Columns.Fields.lastname));
					list.add(user);
				});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<User>();
		}
	}

	@Override
	public boolean create(User entity) {
		try {
			super.newObject();
			super.sql.append("INSERT INTO account_user(id, username, firstname, lastname) VALUES(?,?,?,?)");
			super.params.add(entity.getId());
			super.params.add(entity.getUsername());
			super.params.add(entity.getFirstName());
			super.params.add(entity.getLastName());
			return super.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User entity) {
		try {
			super.newObject();
			super.sql.append("UPDATE account_user SET firstname=?, lastname=? WHERE username=? OR id=?");
			super.params.add(entity.getFirstName());
			super.params.add(entity.getLastName());
			super.params.add(entity.getUsername());
			super.params.add(entity.getId());
			return super.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean merge(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User entity) {
		try {
			super.newObject();
			super.sql.append("DELETE FROM account_user WHERE id=?");
			super.params.add(entity.getId());
			return super.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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