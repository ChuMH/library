package com.heike.dao;

import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;

public interface UpdateDao {
	void updateT(Teacher t);
	void updateS(Students stu);
	void updateH(House house);
	void updateAudit(Integer s_id);
}
