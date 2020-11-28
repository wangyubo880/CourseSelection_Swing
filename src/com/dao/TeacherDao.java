package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Teacher;
import com.db.StringUtil;

public class TeacherDao extends BaseDao {
	//添加教师
	public boolean addTeacher(Teacher teacher){
		String sql = "insert into teacher values(null,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTeacher_name());
			preparedStatement.setString(2, teacher.getTeacher_password());
			preparedStatement.setString(3, teacher.getTeacher_title());
			
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//获取教师列表
	public List<Teacher> getTeacherList(Teacher teacher) {
		// TODO Auto-generated method stub
		List<Teacher> retList = new ArrayList<Teacher>();
		StringBuffer sqlString = new StringBuffer("select * from teacher");
		if(!StringUtil.isEmpty(teacher.getTeacher_name())){
			sqlString.append(" where teacher_name like '%"+teacher.getTeacher_name()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Teacher t = new Teacher();
				t.setTeacher_id(executeQuery.getInt("teacher_id"));
				t.setTeacher_name(executeQuery.getString("teacher_name"));
				t.setTeacher_title(executeQuery.getString("teacher_title"));
				t.setTeacher_password(executeQuery.getString("teacher_password"));
				retList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	//删除教师
	public boolean delete(int id){
		String sql = "delete from teacher where teacher_id=?";
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
	//修改教师信息
	public boolean update(Teacher teacher){
		String sql = "update teacher set teacher_name=?,teacher_title=?,teacher_password=? where teacher_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getTeacher_name());
			preparedStatement.setString(2, teacher.getTeacher_title());
			preparedStatement.setString(3, teacher.getTeacher_password());
			preparedStatement.setInt(4, teacher.getTeacher_id());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//教师登录
	public Teacher login(Teacher teacher){
		String sql = "select * from teacher where teacher_name=? and teacher_password=?";
		Teacher teacherRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, teacher.getTeacher_name());
			prst.setString(2, teacher.getTeacher_password());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				teacherRst = new Teacher();
				teacherRst.setTeacher_id(executeQuery.getInt("teacher_id"));
				teacherRst.setTeacher_name(executeQuery.getString("teacher_name"));
				teacherRst.setTeacher_password(executeQuery.getString("teacher_password"));
				teacherRst.setTeacher_title(executeQuery.getString("teacher_title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherRst;
	}
	//修改密码
	public String editPassword(Teacher teacher,String newPassword){
		String sql = "select * from teacher where teacher_id=? and teacher_password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, teacher.getTeacher_id());
			prst.setString(2, teacher.getTeacher_password());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("teacher_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String retString = "修改失败";
		String sqlString = "update teacher set teacher_password = ? where teacher_id = ?";
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
}
