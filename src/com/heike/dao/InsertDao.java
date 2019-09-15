package com.heike.dao;

import java.util.Map;

import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;

public interface InsertDao {
	void insertAdmin(Admin admin);
	void insertT(Teacher t);
	
	void insertS(Students s);
	void insertH(House h);
	
	void addtask(Map map);
	
	void addAudit(Map map);
}
