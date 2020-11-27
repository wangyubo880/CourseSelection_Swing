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
	//�޸Ĺ���Ա����
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
				String retString = "���������";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String retString = "�޸�ʧ��";
		String sqlString = "update admin set admin_password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int result = prst.executeUpdate();
			if(result > 0){
				retString = "�����޸ĳɹ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
	}

}
