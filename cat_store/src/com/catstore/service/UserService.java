package com.catstore.service;

import java.sql.SQLException;

import com.catstore.domain.User;

public interface UserService {

	User findByUsername(String username) throws SQLException;

	void save(User user) throws SQLException;

}
