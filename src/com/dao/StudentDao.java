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
	//删除学生
	public boolean delete(int student_id){
		String sql = "delete from student where student_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, student_id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改学生信息
	public boolean update(Student student){
		String sql = "update student set student_name=?,student_password=? where student_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getStudent_name());
			preparedStatement.setString(2, student.getStudent_password());
			preparedStatement.setInt(3, student.getStudent_id());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//修改学生密码
	public String editPassword(Student student,String newPassword){
		String sql = "select * from student where student_id=? and student_password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, student.getStudent_id());
			prst.setString(2, student.getStudent_password());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("student_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update student set student_password = ? where student_id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
	//学生登录
	public Student login(Student student){
		String sql = "select * from student where student_name=? and student_password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, student.getStudent_name());
			prst.setString(2, student.getStudent_password());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				studentRst = new Student();
				studentRst.setStudent_id(executeQuery.getInt("student_id"));
				studentRst.setStudent_name(executeQuery.getString("student_name"));
				studentRst.setStudent_password(executeQuery.getString("student_password"));
				studentRst.setStudent_number(executeQuery.getString("student_number"));  //+
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}

}
