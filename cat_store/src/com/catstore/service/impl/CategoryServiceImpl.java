package com.catstore.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.catstore.dao.CategoryDao;
import com.catstore.dao.impl.CategoryDaoImpl;
import com.catstore.domain.Category;
import com.catstore.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> findAll() throws SQLException {
		// TODO Auto-generated method stub
		CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.findAll();
	}

}
