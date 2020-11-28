package com.bean;

public class Course {
	private Integer course_id;
	private String course_name;
	private Integer teacher_id;
	private Integer maxNumber;
	private Integer selectedNum=0;
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Integer getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}
	public Integer getSelectedNum() {
		return selectedNum;
	}
	public void setSelectedNum(Integer selectedNum) {
		this.selectedNum = selectedNum;
	}
	public String toString() {
		return this.course_name;
	}

}
