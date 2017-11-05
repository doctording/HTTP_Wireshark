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
		
		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			dbc.DataBase_Connection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// �������ݿ��ѯ����
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				// ��ȡ������е���Ϣ
				int id=rs.getInt("id");
				String userID = rs.getString("userID");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
			
				User user = new User(id, userID, name, password, phone, address);
				
				userlist.add(user); // �Ѷ�����ӵ�������
			}
		}
		catch (Exception e)
		{
			return null;
		}
		finally {
			// �ر����ݿ�����
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

		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			dbc.DataBase_Connection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			// �������ݿ��ѯ����
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��user����
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				user = new User(id, userID, name, password, phone, address);
			}
			
		} catch (Exception e) {
			return null;
		} finally {
			// �ر����ݿ�����
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
