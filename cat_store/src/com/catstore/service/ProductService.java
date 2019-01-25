package com.catstore.service;

import java.sql.SQLException;
import java.util.List;

import com.catstore.domain.PageBean;
import com.catstore.domain.Product;

public interface ProductService {

	List<Product> findByHot() throws SQLException;

	List<Product> findByDiscounts() throws SQLException;

	Product findByPid(String pid) throws SQLException;

	PageBean<Product> findByPageCid(String cid, Integer currPage) throws SQLException;

	PageBean<Product> findByPage(Integer currPage) throws SQLException;

	void save(Product product) throws SQLException;

	void update(Product product) throws SQLException;

	List<Product> findByPushDown() throws SQLException;




}
