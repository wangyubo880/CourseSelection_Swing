package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.db.StringUtil;


public class CourseDao extends BaseDao {
	//添加课程
	public boolean addCourse(Course course){
		String sql = "insert into course values(null,?,?,?,0)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, course.getCourse_name());
			preparedStatement.setInt(2, course.getTeacher_id());
			preparedStatement.setInt(3, course.getMaxNumber());
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//获取课程列表
	public List<Course> getCourseLists(Course course){
		List<Course> retList = new ArrayList<Course>();
		StringBuffer sqlString = new StringBuffer("select * from course");
		if(!StringUtil.isEmpty(course.getCourse_name())){
			sqlString.append(" and course_name like '%"+course.getCourse_name()+"%'");
		}
//		System.out.println(course.getCourse_name());
//		System.out.println(course.getTeacher_id());  //测试
		if(course.getTeacher_id() != 0){   //判断角色
			sqlString.append(" and teacher_id ="+course.getTeacher_id());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Course c = new Course();
				c.setCourse_id(executeQuery.getInt("course_id"));
				c.setCourse_name(executeQuery.getString("course_name"));
				c.setTeacher_id(executeQuery.getInt("teacher_id"));
				c.setMaxNumber(executeQuery.getInt("maxNumber"));
				c.setSelectedNum(executeQuery.getInt("selectedNum"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public List<Course> getCourseList(Course course){
		List<Course> retList = new ArrayList<Course>();
		StringBuffer sqlString = new StringBuffer("select * from course");
		if(!StringUtil.isEmpty(course.getCourse_name())){
			sqlString.append(" and course_name like '%"+course.getCourse_name()+"%'");
		}
//		System.out.println(course.getCourse_name());
//		System.out.println(course.getTeacher_id());  //测试
		//if(!StringUtil.isEmpty(course.getTeacher_id())){
		if(course.getTeacher_id() != null){   //判断角色
			sqlString.append(" and teacher_id ="+course.getTeacher_id());
		}
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Course c = new Course();
				c.setCourse_id(executeQuery.getInt("course_id"));
				c.setCourse_name(executeQuery.getString("course_name"));
				c.setTeacher_id(executeQuery.getInt("teacher_id"));
				c.setMaxNumber(executeQuery.getInt("maxNumber"));
				c.setSelectedNum(executeQuery.getInt("selectedNum"));
				retList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	//删除课程
	public boolean delete(int id){
		String sql = "delete from course where course_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改课程
	public boolean update(Course course){
		String sql = "update course set course_name=?, teacher_id=?,maxNumber=? where course_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, course.getCourse_name());
			preparedStatement.setInt(2, course.getTeacher_id());
			preparedStatement.setInt(3, course.getMaxNumber());
			preparedStatement.setInt(4, course.getCourse_id());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//是否满员
	public boolean selectedEnable(int course_id){
		String sql = "select * from course where course_id=?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, course_id);
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				int max_student_num = executeQuery.getInt("maxNumber");
				int selected_num = executeQuery.getInt("selectedNum");
				if(selected_num >= max_student_num)
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	//人数
	public boolean updateSelectedNum(int course_id,int num){
		String sql = "update course set selectedNum = selectedNum + ? where course_id = ?";
		if(num < 0){
			sql = "update course set selectedNum = selectedNum - ? where course_id = ?";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, course_id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}

}
