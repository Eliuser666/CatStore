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
import java.util.List;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest req,HttpServletResponse resp){

		try{
//			查询热门商品
			ProductService productService=new ProductServiceImpl();
			List<Product> hotList=productService.findByHot();
//			查询优惠促销
			List<Product> discountsList=productService.findByDiscounts();
			req.setAttribute("hotList", hotList);
			req.setAttribute("discountsList", discountsList);
				
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return "/jsp/index.jsp";
	}
	

}
