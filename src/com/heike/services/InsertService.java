package com.heike.services;

import java.util.List;
import java.util.Map;

import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;

public interface InsertService {
	void insertAdmin(Admin admin);
	void insertT(Teacher t);
	void insertS(Students s);
	void insertH(House h);
	void addtask(Map map);
	void addAudit(Map map);
}
