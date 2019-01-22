package com.catstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.catstore.domain.Category;

/**
 * 分类的DAO的接口
 * @author admin
 *
 */
public interface CategoryDao {

	List<Category> findAll() throws SQLException;

}
