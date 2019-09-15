package com.heike.domain;

public class Students {
	private Integer stu_id;
	private String stu_name;
	private String stu_sex;
	private Integer stu_houseid;
	private Integer stu_no;
	private String stu_username;
	private String stu_password;
	private String stu_photo;
	private Integer stu_audit;
	private House house;
	private String stu_hobby;
	
	public String getStu_hobby() {
		return stu_hobby;
	}

	public void setStu_hobby(String stu_hobby) {
		this.stu_hobby = stu_hobby;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Integer getStu_id() {
		return stu_id;
	}

	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public Integer getStu_houseid() {
		return stu_houseid;
	}

	public void setStu_houseid(Integer stu_houseid) {
		this.stu_houseid = stu_houseid;
	}

	public Integer getStu_no() {
		return stu_no;
	}

	public void setStu_no(Integer stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_username() {
		return stu_username;
	}

	public void setStu_username(String stu_username) {
		this.stu_username = stu_username;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_photo() {
		return stu_photo;
	}

	public void setStu_photo(String stu_photo) {
		this.stu_photo = stu_photo;
	}

	public Integer getStu_audit() {
		return stu_audit;
	}

	public void setStu_audit(Integer stu_audit) {
		this.stu_audit = stu_audit;
	}

	public String toString() {
		return "Students [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", stu_houseid="
				+ stu_houseid + ", stu_no=" + stu_no + ", stu_username=" + stu_username + ", stu_password="
				+ stu_password + ", stu_photo=" + stu_photo + ", stu_audit=" + stu_audit + ", house=" + house
				+ ", stu_hobby=" + stu_hobby + "]";
	}
}
