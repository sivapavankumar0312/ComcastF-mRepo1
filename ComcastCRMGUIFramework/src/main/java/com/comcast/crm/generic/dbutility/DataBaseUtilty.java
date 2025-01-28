package com.comcast.crm.generic.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtilty {
	Connection conn;
public void getDbconnection(String url,String username,String password) throws SQLException {
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "root");
	}catch (Exception e) {
	
	}
	
}
public void closeDbconnection() throws SQLException {
	conn.close();
	
}
public ResultSet executeConSelectQuery(String query) throws SQLException {
	ResultSet res=null;
	try {
	Statement stat=conn.createStatement();
	 res=stat.executeQuery(query);
	}
	catch (Exception e) {
	}
	return res;
}
public int executeNonselectQuery(String query) {
	int res=0;
	try {
		Statement stat=conn.createStatement();
		res=stat.executeUpdate(query);
	}catch (Exception e) {
		
	}
	return res;
	}
}
