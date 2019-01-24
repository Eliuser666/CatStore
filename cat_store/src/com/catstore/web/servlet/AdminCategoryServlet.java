package com.catstore.web.servlet;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catstore.service.CategoryService;
import com.catstore.service.impl.CategoryServiceImpl;
import com.catstore.utils.BaseServlet;

/**
 * Servlet implementation class AdminCategoryServlet
 */
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 后台查询所有分类的执行的方法:findAll
	 * @param req
	 * @param resp
	 * @return
	 */
//	public String findAll(HttpServletRequest req,HttpServletResponse resp){
//		// 调用业务层
//		CategoryService categoryService = new CategoryServiceImpl();
//		//CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
//		try {
//			List<Category> list = categoryService.findAll();
//			// 存入req域中，完成页面跳转:
//			req.setAttribute("list", list);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "/admin/category/list.jsp";
//	}
}
