package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	private final String DBDRIVER = "com.mysql.jdbc.Driver" ;         
	private final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8" ;
	private final String DBUSER = "root" ;
	private final String DBPASSWORD = "123456" ;
	
	private Connection conn = null ;

	public  DataBaseConnection()
	{
		super();
	}
	public void DataBase_Connection()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;	
		}
		catch (Exception e)
		{
		}
	}

	// 取得数据库连接
	public Connection getConnection()
	{
//		try {
//			this.conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return this.conn;
	}

	// 关闭数据库连接
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
		}		
	}	
}
