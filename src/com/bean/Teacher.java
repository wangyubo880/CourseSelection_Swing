package com.bean;

public class Teacher {
	private int teacher_id;
	private String teacher_name;
	private String teacher_password;
	private String teacher_title;

	
	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getTeacher_password() {
		return teacher_password;
	}


	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}


	public String getTeacher_title() {
		return teacher_title;
	}


	public void setTeacher_title(String teacher_title) {
		this.teacher_title = teacher_title;
	}


	@Override
	public String toString() {
		return this.teacher_name;
	}

	
}
