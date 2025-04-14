package com.jdbc_DAO.Demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");  // Loading Driver
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
		//JDBC URL format: jdbc:mysql://[host]:[port]/[database]
	}
}

