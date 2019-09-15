package com.heike.dao;

import java.util.List;
import java.util.Map;

import com.heike.domain.Admin;
import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Task;
import com.heike.domain.Teacher;

public interface SelectDao {
	List<House> selectH();
	Teacher selectTById(Integer t_id);
	Students selectSById(Integer stu_id);
	
	List<Teacher> selectAllTeacher(Map map);
	int getTotalTeacherCount();
	int getBadStudentCount();
	List<Students> selectAllStudents(Map map);
	int getTotalStudentCount();
	List<Students> selectBadStudents(Map map);
	House selectHById(Integer h_id);
	
	List<House> showAllH();
	List<Students> showMyS(Integer h_id);
	
	Teacher searchT(Integer t_no);
	//Students searchS(Integer stu_no);
	List<Students> searchS(Map map);
	
	int getHstudentCount(Integer houseid);
	List<Students> selectHStudents(Map map);
	
	Teacher selectTeaById(Integer tid);
	List<Task> selectAllTask(Map map);
	int getTotalTask(Integer stu_id);
	
	List<Admin> selectAdmin();
	List<Teacher> selectTeacher();
	List<Students> selectStudent();
}
