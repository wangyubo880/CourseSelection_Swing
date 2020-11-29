package com.bean;

public class Course {
	private int course_id;
	private String course_name;
	private int teacher_id;
	private int maxNumber;
	private int selectedNum=0;
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getSelectedNum() {
		return selectedNum;
	}

	public void setSelectedNum(int selectedNum) {
		this.selectedNum = selectedNum;
	}

	public String toString() {
		return this.course_name;
	}

}
