package com.catstore.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.catstore.dao.CategoryDao;
import com.catstore.dao.impl.CategoryDaoImpl;
import com.catstore.domain.Category;
import com.catstore.service.CategoryService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> findAll() throws SQLException {
		/*CategoryDao categoryDao = new CategoryDaoImpl();
		return categoryDao.findAll();*/
		/**
		 * 使用缓存优化程序,先从缓存中获取数据
		 *   * 获取到:直接返回
		 *   * 获取不到:查询数据库,将记录存入到缓存中.
		 */
		// 读取配置文件
		CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// 从配置文件中获取名称为categoryCache缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		// 判断缓存中是否有list集合:
		Element element = cache.get("list");
		List<Category> list = null;
		if(element == null){
			// 缓存中没有数据
			System.out.println("缓存中没有数据 ,查询数据库=====");
			
			CategoryDao categoryDao = new CategoryDaoImpl();
		//	CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
			list = categoryDao.findAll();
			element = new Element("list",list); 
			cache.put(element);
		}else{
			// 缓存中已经存在数据
			System.out.println("缓存中有数据 ,没有查询数据库=====");
			list = (List<Category>)element.getObjectValue();
		}
		return list;
	}

}
