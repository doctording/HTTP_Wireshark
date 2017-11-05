package com.daoImpl;

import java.sql.*;
import java.util.*;

import com.bean.*;
import com.dao.DataBaseConnection;
import com.dao.UserDao;


public class UserDaoImpl implements UserDao{

	@Override
	public List<User> user_getAll() {
		List<User> userlist = new ArrayList<User>();
		String sql = "SELECT * FROM tb_user;";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();;
		ResultSet rs=null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc.DataBase_Connection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 进行数据库查询操作
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				// 获取结果集中的信息
				int id=rs.getInt("id");
				String userID = rs.getString("userID");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
			
				User user = new User(id, userID, name, password, phone, address);
				
				userlist.add(user); // 把对象添加到集合中
			}
		}
		catch (Exception e)
		{
			return null;
		}
		finally {
			// 关闭数据库连接
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbc.close();
		}
		return userlist;
	}

	
	@Override
	public User user_getByUserIDAndPassword(String userID, String password) {
		String sql = "SELECT * FROM tb_user WHERE userID=? and password=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		ResultSet rs = null;
		User user = null ;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc.DataBase_Connection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			// 进行数据库查询操作
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				user = new User(id, userID, name, password, phone, address);
			}
			
		} catch (Exception e) {
			return null;
		} finally {
			// 关闭数据库连接
			try {
				rs.close();
			} catch (SQLException e) {
//				e.printStackTrace();
				return null;
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
//				e.printStackTrace();
				return null;
			}
			dbc.close();
		}
		return user;
	}

	
}
