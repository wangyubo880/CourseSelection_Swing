package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;


public class AdminDao extends BaseDao {
	//����Ա��¼
	public Admin login(Admin admin){
		String sql = "select * from admin where admin_name=? and admin_password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1, admin.getAdmin_name());
			prst.setString(2, admin.getAdmin_password());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				adminRst = new Admin();  //��¼���ȡ��¼��Ϣ
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
