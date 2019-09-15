package com.heike.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heike.dao.SelectDao;
import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Task;
import com.heike.domain.Teacher;
import com.heike.services.SelectService;

@Service
public class SelectServiceImpl implements SelectService{
	@Resource
	private SelectDao selectdao;
	@Override
	public List<House> selectH() {
		return selectdao.selectH();
	}
	@Override
	public Teacher selectTById(Integer t_id) {
		return selectdao.selectTById(t_id);
	}
	@Override
	public Students selectSById(Integer stu_id) {
		return selectdao.selectSById(stu_id);
	}

	
	public int getTotalTeacherCount() {
		return selectdao.getTotalTeacherCount();
	}

	public List<Teacher> selectAllTeacher(Map map) {
		return selectdao.selectAllTeacher(map);
	}



	public House selectHById(Integer h_id) {
		return selectdao.selectHById(h_id);
	}

	public List<Students> selectAllStudents(Map map) {
		
		return selectdao.selectAllStudents(map);
	}

	public int getTotalStudentCount() {
		return selectdao.getTotalStudentCount();
	}

	public List<Students> selectBadStudents(Map map) {
		
		return selectdao.selectBadStudents(map);
	}

	public int getBadStudentCount() {
		
		return selectdao.getBadStudentCount();
	}

	public List<House> showAllH() {
		
		return selectdao.showAllH();
	}

	public List<Students> showMyS(Integer h_id) {
		
		return selectdao.showMyS(h_id);
	}

	public Teacher searchT(Integer t_no) {
		
		return selectdao.searchT(t_no);
	}

	/*public Students searchS(Integer stu_no) {
		
		return selectdao.searchS(stu_no);
	}*/
	public List<Students> searchS(Map map) {
		return selectdao.searchS(map);
	}
	
	
	
	
	
	@Override
	public int getHstudentCount(Integer houseid) {
		return selectdao.getHstudentCount(houseid);
	}
	@Override
	public List<Students> selectHStudents(Map map) {
		return selectdao.selectHStudents(map);
	}
	@Override
	public int getTotalTask(Integer stu_id) {
		return selectdao.getTotalTask(stu_id);
	}
	@Override
	public List<Task> selectAllTask(Map map) {
		return selectdao.selectAllTask(map);
	}
	@Override
	public List<Admin> selectAdmin() {
		return selectdao.selectAdmin();
	}
	@Override
	public List<Teacher> selectTeacher() {
		return selectdao.selectTeacher();
	}
	@Override
	public List<Students> selectStudent() {
		return selectdao.selectStudent();
	}
	

}
