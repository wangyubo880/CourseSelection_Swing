package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;


public class AdminDao extends BaseDao {
	//管理员登录
	public Admin login(Admin admin){
		String sql = "select * from admin where admin_name=? and admin_password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, admin.getAdmin_name());
			prst.setString(2, admin.getAdmin_password());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				adminRst = new Admin();  //登录后获取登录信息
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setAdmin_name(executeQuery.getString("admin_name"));
				adminRst.setAdmin_password(executeQuery.getString("admin_password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminRst;
	}
	//修改管理员密码
	public String editPassword(Admin admin,String newPassword){
		String sql = "select * from admin where id=? and admin_password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getAdmin_password());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String retString = "修改失败";
		String sqlString = "update admin set admin_password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int result = prst.executeUpdate();
			if(result > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
	}

}
