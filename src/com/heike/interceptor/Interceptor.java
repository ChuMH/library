package com.heike.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.heike.domain.Admin;
import com.heike.domain.Teacher;

public class Interceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("a pre Handle");
		HttpSession session = request.getSession();
		Object o =session.getAttribute("user");
		if(o==null) {
			if(o instanceof Admin)
				response.sendRedirect(request.getContextPath()+"/adminuser.html");
			else if(o instanceof Teacher)
				response.sendRedirect(request.getContextPath()+"/adminuser.html");
			else 
				response.sendRedirect(request.getContextPath()+"/stulogin.html");
			return false;
		}else
			return true;
	}
}
