package com.dao;

import java.util.List;

import com.bean.*;

public interface UserDao {

	/**
	 * �õ����е��û�
	 * @return
	 * xxx
	 * 2015-6-26 ����11:50:11
	 */
	public List<User> user_getAll();

	/**
	 * ����id �� �����ж��û��Ƿ����
	 * @param userID
	 * @param password
	 * @return
	 * xxx
	 * 2015-6-26 ����12:05:30
	 */
	public User user_getByUserIDAndPassword(String userID,String password);
	
}
