package com.heike.domain;

public class Task {
	private Integer task_id;
	private Teacher teacher;
	private String information;
	private String task_time;
	public String getTask_time() {
		return task_time;
	}
	public void setTask_time(String task_time) {
		this.task_time = task_time;
	}
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", teacher=" + teacher + ", information=" + information + ", task_time="
				+ task_time + "]";
	}

	
}
