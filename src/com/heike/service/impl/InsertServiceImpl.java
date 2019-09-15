package com.heike.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heike.dao.InsertDao;
import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.InsertService;

@Service
public class InsertServiceImpl implements InsertService {
	@Resource
	private InsertDao insertdao;
	@Override
	public void insertAdmin(Admin admin) {
		insertdao.insertAdmin(admin);
	}
	@Override
	public void insertT(Teacher t) {
		insertdao.insertT(t);
	}
	@Override
	public void insertS(Students s) {
		insertdao.insertS(s);
	}
	@Override
	public void insertH(House h) {
		insertdao.insertH(h);
	}
	@Override
	public void addtask(Map map) {
		insertdao.addtask(map);
	}
	@Override
	public void addAudit(Map map) {
		insertdao.addAudit(map);
	}
}
