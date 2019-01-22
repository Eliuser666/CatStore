package com.catstore.service;

import java.sql.SQLException;
import java.util.List;

import com.catstore.domain.Category;

public interface CategoryService {

	List<Category> findAll() throws SQLException;

}
