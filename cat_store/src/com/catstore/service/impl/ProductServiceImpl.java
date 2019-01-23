package com.catstore.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.catstore.dao.ProductDao;
import com.catstore.dao.impl.ProductDaoImpl;
import com.catstore.domain.Product;
import com.catstore.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findByHot() throws SQLException {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findByHot();
	}

	@Override
	public List<Product> findByDiscounts() throws SQLException {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findByDiscounts();
	}

}
