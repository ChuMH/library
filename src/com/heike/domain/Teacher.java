package com.heike.domain;

public class Teacher {
	private Integer t_id;
	private String t_name;
	private Integer t_houseid;
	private String t_username;
	private String t_password;
	private House house;
	private Integer t_no;
	public Integer getT_no() {
		return t_no;
	}

	public void setT_no(Integer t_no) {
		this.t_no = t_no;
	}

	public String getT_username() {
		return t_username;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public void setT_username(String t_username) {
		this.t_username = t_username;
	}

	public String getT_password() {
		return t_password;
	}

	public void setT_password(String t_password) {
		this.t_password = t_password;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public Integer getT_houseid() {
		return t_houseid;
	}

	public void setT_houseid(Integer t_houseid) {
		this.t_houseid = t_houseid;
	}

	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", t_name=" + t_name + ", t_houseid="
				+ t_houseid + ", t_username=" + t_username + ", t_password="
				+ t_password + ", house=" + house + ", t_no=" + t_no + "]";
	}

}
