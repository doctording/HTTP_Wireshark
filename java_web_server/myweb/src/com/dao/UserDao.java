package com.dao;

import java.util.List;

import com.bean.*;

public interface UserDao {

	/**
	 * 得到所有的用户
	 * @return
	 * xxx
	 * 2015-6-26 上午11:50:11
	 */
	public List<User> user_getAll();

	/**
	 * 根据id 和 密码判断用户是否存在
	 * @param userID
	 * @param password
	 * @return
	 * xxx
	 * 2015-6-26 下午12:05:30
	 */
	public User user_getByUserIDAndPassword(String userID,String password);
	
}
