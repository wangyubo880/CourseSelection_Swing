package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.DbUtil;

//创建对数据库连接对象
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
