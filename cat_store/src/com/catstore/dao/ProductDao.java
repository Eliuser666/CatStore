package com.catstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.catstore.domain.Product;

public interface ProductDao {

	List<Product> findByHot() throws SQLException;

	List<Product> findByDiscounts() throws SQLException;

	Product findByPid(String pid) throws SQLException;

	Integer findCountByCid(String cid) throws SQLException;

	List<Product> findPageByCid(String cid, int begin, Integer pageSize) throws SQLException;

}
