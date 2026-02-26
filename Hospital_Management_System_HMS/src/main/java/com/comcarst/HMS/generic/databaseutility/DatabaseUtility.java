package com.comcarst.HMS.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * DatabaseUtility class is used to handle all database related operations. This
 * class provides methods to:
 * 
 * 1. Establish database connection 2. Close database connection 3. Execute
 * SELECT queries 4. Execute INSERT, UPDATE, DELETE queries
 * 
 * This utility helps in database validation and data fetching for automation
 * testing.
 * 
 * @author Mahan
 */
public class DatabaseUtility {

	// Connection reference variable used to establish connection with database
	Connection con;

	/**
	 * This method is used to establish connection with MySQL database. It registers
	 * the MySQL driver and creates connection using URL, username, and password.
	 * 
	 * @throws Exception
	 */
	public void getDbconnection() throws Exception {

		try {
			// Create MySQL driver object
			Driver driver = new Driver();

			// Register driver with DriverManager
			DriverManager.registerDriver(driver);

			// Establish connection with database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "Omsairam@123");

			System.out.println("Database connection established successfully");

		} catch (Exception e) {

			// Print exception details if connection fails
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the database connection.
	 * 
	 * @throws SQLException
	 */
	public void closeDbconnection() throws SQLException {

		// Close database connection
		con.close();

		System.out.println("Database connection closed successfully");
	}

	/**
	 * This method is used to execute SELECT query. It returns ResultSet which
	 * contains data retrieved from database.
	 * 
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeSelectQuery(String query) throws SQLException {

		ResultSet result = null;

		try {

			// Create statement object
			Statement statement = con.createStatement();

			// Execute SELECT query
			result = statement.executeQuery(query);

		} catch (Exception e) {

			// Print exception details
			e.printStackTrace();
		}

		// Return ResultSet
		return result;
	}

	/**
	 * This method is used to execute INSERT, UPDATE, DELETE queries. It returns
	 * number of rows affected.
	 * 
	 * @param query
	 * @return int (number of rows affected)
	 */
	public int executeUpdateQuery(String query) {

		int result = 0;

		try {

			// Create statement object
			Statement state = con.createStatement();

			// Execute update query
			result = state.executeUpdate(query);

		} catch (Exception e) {

			// Print exception details
			e.printStackTrace();
		}

		// Return result count
		return result;
	}

}