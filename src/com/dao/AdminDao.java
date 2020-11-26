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

}
