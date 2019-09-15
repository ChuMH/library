package com.heike.dao;

import com.heike.domain.Admin;
import com.heike.domain.AdminUser;
import com.heike.domain.Students;
import com.heike.domain.Teacher;

public interface LoginDao {
	Admin selectAdmin(AdminUser u);
	Teacher selectTeacher(AdminUser u);
	
	Students selectStudent(Students stu);
}
