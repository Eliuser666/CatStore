package com.catstore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.catstore.domain.User;
import com.catstore.service.UserService;
import com.catstore.service.impl.UserServiceImpl;
import com.catstore.utils.BaseServlet;
import com.catstore.utils.BeanFactory;

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
			UserService userService = (UserService) BeanFactory.getBean("userService");
//			UserService userService = new UserServiceImpl();
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
			ConvertUtils.register(new com.catstore.utils.MyDateConverter(), Date.class);
			BeanUtils.populate(user, map);
			// 调用业务层
//			UserService userService = new UserServiceImpl();
			UserService userService = (UserService) BeanFactory.getBean("userService");
			userService.save(user);
			// 页面跳转
			user.setState(2);//已注册
			req.setAttribute("msg", "注册成功！请去登录！");
			//user.setState(2); // 设置激活的状态为已经激活.
			//user.setCode(null);
			//userService.update(user);
			return "/jsp/msg.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 跳转到登录页面的执行的方法:loginUI
	 */
	public String loginUI(HttpServletRequest req,HttpServletResponse resp){
		return "/jsp/login.jsp";
	}
	/**
	 * 用户登录的执行的方法:login
	 */
	public String login(HttpServletRequest req,HttpServletResponse resp){
		try{
			// 一次性验证码程序:
			String code1 = req.getParameter("code");
			//code2为验证码，code1为输入的验证码
			String code2 = (String)req.getSession().getAttribute("code");
			req.getSession().removeAttribute("code");
			if(!code1.equalsIgnoreCase(code2)){
				req.setAttribute("msg", "验证码输入错误!请重新输入");
				return "/jsp/login.jsp";
			}
			
			// 接收参数:
			Map<String,String[]> map = req.getParameterMap();
			// 封装数据：
			User user = new User();
			BeanUtils.populate(user, map);
			// 调用业务层:
			UserService userService = (UserService) BeanFactory.getBean("userService");
		//	UserService userService=new UserServiceImpl();
			User existUser = userService.login(user);
			if(existUser == null){
				req.setAttribute("msg", "用户名或密码错误！");
				return "/jsp/login.jsp";
			}else{
				// 登录成功:自动登录
				String autoLogin = req.getParameter("autoLogin");
				if("true".equals(autoLogin)){
					Cookie cookie = new Cookie("autoLogin", existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath("/cat_store");
					cookie.setMaxAge(7* 24 * 60 * 60);
					resp.addCookie(cookie);
				}
				
				// 记住用户名:
				String remember = req.getParameter("remember");
				if("true".equals(remember)){
					Cookie cookie = new Cookie("username",existUser.getUsername());
					cookie.setPath("/cat_store");
					cookie.setMaxAge(24 * 60 * 60);
					resp.addCookie(cookie);
				}
				
				req.getSession().setAttribute("existUser", existUser);
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				return null;
			}
			// 页面跳转
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 用户退出功能的方法:logOut
	 * @param req
	 * @param resp
	 * @return
	 */
	public String logOut(HttpServletRequest req,HttpServletResponse resp){
		
		
		try {
			// 销毁session
			req.getSession().invalidate();
			// 清空自动登录的Cookie:
			Cookie cookie = new Cookie("autoLogin","");
			cookie.setPath("/cat_store");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
