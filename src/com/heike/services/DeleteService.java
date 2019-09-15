package com.heike.services;

public interface DeleteService {
	void deleteH(Integer house_id);
	void deleteT(Integer t_id);
	void deleteS(Integer stu_id);
	void refuseS(Integer s_id);
	void deleteTask(Integer task_id);
}
