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
QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where username=?";
		User user=queryRunner.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

}
