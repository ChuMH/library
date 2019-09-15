package com.heike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heike.domain.Admin;
import com.heike.domain.AdminUser;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginService logins;
	
	@RequestMapping("/adminlogin")
	public String adminLogin(AdminUser u,HttpSession session) {
		Admin admin = logins.selectAdmin(u);
		Teacher teacher = logins.selectTeacher(u);
		if(admin!=null) {
			session.setAttribute("user", admin);
			return "admin";
		}else {
			if(teacher!=null) {
				session.setAttribute("user", teacher);
				return "teacher";
			}else
				return "redirect:/adminuser.html";
		}
	}
	@RequestMapping("/stulogin")
	public String adminLogin(Students stu,HttpSession session) {
		Students s = logins.selectStudent(stu);
		if(s!=null) {
			session.setAttribute("user", s);
			return "student";
		}else
			return "redirect:/stulogin.html";
	}
}
