package com.heike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heike.dao.DeleteDao;
import com.heike.services.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService{
	@Resource
	DeleteDao deldao;
	@Override
	public void deleteT(Integer t_id) {
		//int i = 10/0;
		deldao.deleteT(t_id);
	}
	@Override
	public void deleteS(Integer stu_id) {
		deldao.deleteS(stu_id);
	}
	@Override
	public void deleteH(Integer house_id) {
		deldao.deleteH(house_id);
	}
	@Override
	public void refuseS(Integer s_id) {
		deldao.refuseS(s_id);
	}
	@Override
	public void deleteTask(Integer task_id) {
		deldao.deleteTask(task_id);
	}

}
