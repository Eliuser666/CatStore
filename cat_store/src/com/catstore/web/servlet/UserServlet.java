package com.catstore.web.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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

	/**
	 * 用户注册
	 */

	public String regist(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 接收数据
			Map<String, String[]> map = req.getParameterMap();
			// 封装数据
			User user=new User();
			BeanUtils.populate(user, map);
			// 调用业务层
			UserService userService = new UserServiceImpl();
			userService.save(user);
			// 页面跳转
			req.setAttribute("msg", "注册成功！请去邮箱激活！");
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
