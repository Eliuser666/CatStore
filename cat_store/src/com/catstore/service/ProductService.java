package com.catstore.service;

import java.sql.SQLException;
import java.util.List;
import com.catstore.domain.Product;

public interface ProductService {

	List<Product> findByHot() throws SQLException;

	List<Product> findByDiscounts() throws SQLException;



}
