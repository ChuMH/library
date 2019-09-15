package com.heike.services;

import com.heike.domain.House;
import com.heike.domain.Students;
import com.heike.domain.Teacher;

public interface UpdateService {
	void updateT(Teacher t);
	void updateS(Students stu);
	void updateH(House house);
	void updateAudit(Integer s_id);
}
