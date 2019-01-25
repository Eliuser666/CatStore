package com.catstore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catstore.domain.Product;
import com.catstore.service.ProductService;
import com.catstore.service.impl.ProductServiceImpl;
import com.catstore.utils.BaseServlet;
import com.catstore.utils.BeanFactory;

import java.util.List;

/**
 * Servlet implementation class IndexServlet
 * 
 * request.setAttribute("result",username);
 * 在request对象中加入名为result的属性并附值为username，因为request对象是可以更改的，你可以在同一个请求中象这样访问这个属性。
 * 虽然类似session，但与session是有所区别的，request.setAttribute设置的属性只能在当前request只使用，
 * 比如你在Action中设置result属性，需要到jsp页面中读取： request.setAttribute("result",username);
 * requests.getRequestDispatcher("result.jsp").forward(request, response);
 * jsp页面获取该值： request.getAttribute( "result"); return
 * super.execute();是返回父类调用execute()方法的值
 */
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest req, HttpServletResponse resp) {

		try {
			// 查询热门商品
		//	ProductService productService = new ProductServiceImpl();
			ProductService productService = (ProductService)BeanFactory.getBean("productService");
			List<Product> hotList = productService.findByHot();
			// 查询优惠促销
			List<Product> discountsList = productService.findByDiscounts();
			req.setAttribute("hotList", hotList);
			req.setAttribute("discountsList", discountsList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		return "/jsp/index.jsp";
	}

}
