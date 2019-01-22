package com.catstore.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.catstore.dao.UserDao;
import com.catstore.domain.User;
import com.catstore.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

	@Override
	public void save(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode() };
		queryRunner.update(sql, params);
	}

	@Override
	public User login(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User existuser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		return existuser;
		
	}
}
