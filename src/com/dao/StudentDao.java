package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.db.StringUtil;


public class StudentDao extends BaseDao {
	//添加学生
	public boolean addStudent(Student student){
		String sql = "insert into student values(null,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getStudent_name());
			preparedStatement.setString(2, student.getStudent_password());
			preparedStatement.setString(3, student.getStudent_number());
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//获取学生列表
	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from student");
		if(!StringUtil.isEmpty(student.getStudent_name())){
			sqlString.append(" and student_name like '%"+student.getStudent_name()+"%'");
		}
		if(!StringUtil.isEmpty(student.getStudent_number())){
			sqlString.append(" and student_number like '%"+student.getStudent_number()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setStudent_id(executeQuery.getInt("student_id"));
				s.setStudent_name(executeQuery.getString("student_name"));
				s.setStudent_number(executeQuery.getString("student_number"));
				s.setStudent_password(executeQuery.getString("student_password"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}

}
