package com.comcarst.HMS.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	public void getDbconnection() throws Exception {
		
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "Omsairam@123");
		} catch (Exception e) {
			
		}
	}
	
	public void closeDbconnection() throws SQLException {
		con.close();
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		
		ResultSet result = null;
		try {
		Statement statement = con.createStatement();
		 result= statement.executeQuery(query);
		
		}catch (Exception e) {
			
		}
		return result;
	}
	
	public int executeUpdateQuery(String query) {
		int result = 0;
		try {
			Statement state = con.createStatement();
			result  = state.executeUpdate(query);
		}catch (Exception e) {}
		return result;
			
		}
		
		
	}


