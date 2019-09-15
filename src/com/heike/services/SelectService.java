package com.heike.services;

import java.util.List;
import java.util.Map;

import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Task;
import com.heike.domain.Teacher;

public interface SelectService {
	List<House> selectH();
	Teacher selectTById(Integer t_id);
	Students selectSById(Integer stu_id);
	
	int getBadStudentCount();
	List<Teacher> selectAllTeacher(Map map);
	int getTotalTeacherCount();
	List<Students> selectAllStudents(Map map);
	int getTotalStudentCount();
	List<Students> selectBadStudents(Map map);
	House selectHById(Integer h_id);
	List<House> showAllH();
	List<Students> showMyS(Integer h_id);
	//按条件查询
	Teacher searchT(Integer t_no);
	//Students searchS(Integer stu_no);
	List<Students> searchS(Map map);
	
	int getHstudentCount(Integer houseid);
	List<Students> selectHStudents(Map map);
	
	int getTotalTask(Integer stu_id);
	List<Task> selectAllTask(Map map);
	//验证重复注册
	List<Admin> selectAdmin();
	List<Teacher> selectTeacher();
	List<Students> selectStudent();
}
