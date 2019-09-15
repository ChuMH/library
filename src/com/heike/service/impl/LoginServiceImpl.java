package com.heike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.LoginDao;
import com.heike.domain.Admin;
import com.heike.domain.AdminUser;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.LoginService;

@Service("adminlogin")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao logindao;
	
	@Override
	public Admin selectAdmin(AdminUser u) {
		return logindao.selectAdmin(u);
	}

	@Override
	public Teacher selectTeacher(AdminUser u) {
		return logindao.selectTeacher(u);
	}

	@Override
	public Students selectStudent(Students stu) {
		return logindao.selectStudent(stu);
	}

}
