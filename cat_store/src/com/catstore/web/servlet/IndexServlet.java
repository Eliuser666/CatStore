package com.catstore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catstore.utils.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public String index(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/index.jsp";
	}
	

}
