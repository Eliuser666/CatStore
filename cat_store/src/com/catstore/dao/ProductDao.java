package com.catstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.catstore.domain.Product;

public interface ProductDao {

	List<Product> findByHot() throws SQLException;

	List<Product> findByDiscounts() throws SQLException;

}
