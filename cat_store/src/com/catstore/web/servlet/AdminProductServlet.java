package com.catstore.web.servlet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catstore.domain.Category;
import com.catstore.domain.PageBean;
import com.catstore.domain.Product;
import com.catstore.service.CategoryService;
import com.catstore.service.ProductService;
import com.catstore.utils.BaseServlet;
import com.catstore.utils.BeanFactory;
import com.catstore.utils.CookieUtils;

/**
 * Servlet implementation class AdminProductServlet
 */
public class AdminProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品分页查询的Servlet:
	 * 
	 * @return
	 */
	public String findByPage(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 接收参数:
			Integer currPage = Integer.parseInt(req.getParameter("currPage"));
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			PageBean<Product> pageBean = productService.findByPage(currPage);

			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/list.jsp";
	}

	/**
	 * 跳转到添加页面的执行的方法:
	 */
	public String saveUI(HttpServletRequest req, HttpServletResponse resp) {
		// 查询所有分类:
		try {
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/add.jsp";
	}

	/**
	 * 下架商品的方法:pushDown
	 */
	public String pushDown(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 接收参数:
			String pid = req.getParameter("pid");
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			product.setPflag(1);

			productService.update(product);

			resp.sendRedirect(req.getContextPath() + "/AdminProductServlet?method=findByPage&currPage=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询已经下架的商品:
	 */
	public String findByPushDown(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			List<Product> list = productService.findByPushDown();
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/pushDown_list.jsp";
	}

	/**
	 * 上架商品:
	 */
	public String pushUp(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 接收参数:
			String pid = req.getParameter("pid");
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			product.setPflag(0);

			productService.update(product);

			resp.sendRedirect(req.getContextPath() + "/AdminProductServlet?method=findByPage&currPage=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 跳转到编辑页面的执行的方法:
	 */
	public String editUI(HttpServletRequest req, HttpServletResponse resp) {

		try {
			// 接收参数:
			String pid = req.getParameter("pid");
			// 调用业务层:
			ProductService productService = (ProductService) BeanFactory.getBean("productService");
			Product product = productService.findByPid(pid);
			req.setAttribute("p", product);
			// 页面跳转:product为根据pid查出的商品，以productlist的名字传到edit.jsp"，在edit.jsp中调用p
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryService");
			List<Category> list = categoryService.findAll();
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/product/edit.jsp";
	}

}
