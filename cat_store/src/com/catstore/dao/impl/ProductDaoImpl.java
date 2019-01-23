package com.catstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.catstore.dao.ProductDao;
import com.catstore.domain.Product;
import com.catstore.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	public List<Product> findByHot() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? and is_hot = ? order by pdate desc limit ?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),0,1,9);
		return list;
	}

	public List<Product> findByDiscounts() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? order by pdate desc limit ?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0,9);
		return list;
	}

	@Override
	public Product findByPid(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
