package com.catstore.service.impl;

import java.sql.SQLException;

import com.catstore.dao.UserDao;
import com.catstore.dao.impl.UserDaoImpl;
import com.catstore.domain.User;
import com.catstore.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String username) throws SQLException {
		UserDao userDao = new UserDaoImpl();
		return userDao.findByUsername(username);
	}

}
