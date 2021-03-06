package com.catstore.service.impl;

import java.sql.SQLException;

import com.catstore.dao.UserDao;
import com.catstore.dao.impl.UserDaoImpl;
import com.catstore.domain.User;
import com.catstore.service.UserService;
import com.catstore.utils.BeanFactory;
import com.catstore.utils.UUIDUtils;

public class UserServiceImpl implements UserService {

	@Override
	public User findByUsername(String username) throws SQLException {
		UserDao userDao =(UserDao) BeanFactory.getBean("userDao");
//		UserDao userDao = new UserDaoImpl();
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) throws SQLException {
	
//		UserDao userDao = new UserDaoImpl();
		UserDao userDao =(UserDao) BeanFactory.getBean("userDao");
		user.setUid(UUIDUtils.getUUID());
		user.setState(1);//1代表未激活，2代表已激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();//64位激活码
		user.setCode(code);
		userDao.save(user);
	}

	@Override
	public User login(User user) throws SQLException {
		// TODO Auto-generated method stub
//		UserDao userDao = new UserDaoImpl();
		UserDao userDao =(UserDao) BeanFactory.getBean("userDao");
		return userDao.login(user);
	}

}

