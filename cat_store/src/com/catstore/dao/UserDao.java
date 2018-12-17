package com.catstore.dao;

import java.sql.SQLException;

import com.catstore.domain.User;

public interface UserDao {

	User findByUsername(String username) throws SQLException;

}
