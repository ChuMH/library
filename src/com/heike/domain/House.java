package com.heike.domain;

public class House {
	private Integer house_id;
	private String house_name;
	public Integer getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	@Override
	public String toString() {
		return "House [house_id=" + house_id + ", house_name=" + house_name + "]";
	}
	
}
