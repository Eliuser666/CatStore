package com.catstore.web.servlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catstore.domain.User;
import com.catstore.service.UserService;
import com.catstore.service.impl.UserServiceImpl;
import com.catstore.utils.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 跳转到注册页面的执行的方法：registUI
	 */
	public String registUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/regist.jsp";
	}

	public String checkUsername(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username = req.getParameter("username");
			UserService userService = new UserServiceImpl();

			User existUser = userService.findByUsername(username);
			if (existUser == null) {
				resp.getWriter().println("1");

			} else {
				resp.getWriter().println("2");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

		return null;

	}
}
