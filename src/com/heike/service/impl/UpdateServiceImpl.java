package com.heike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heike.dao.UpdateDao;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;
import com.heike.services.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService{
	@Resource
	private UpdateDao updatedao;
	@Override
	public void updateT(Teacher t) {
		updatedao.updateT(t);
	}
	@Override
	public void updateS(Students stu) {
		updatedao.updateS(stu);
	}
	@Override
	public void updateH(House house) {
		updatedao.updateH(house);
	}
	public void updateAudit(Integer s_id) {
		updatedao.updateAudit(s_id);
	}

}
