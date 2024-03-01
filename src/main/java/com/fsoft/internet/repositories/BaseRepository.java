package com.fsoft.internet.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
	
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection == null);
	}

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	
	private static String jdbcURL =
			"jdbc:sqlserver://localhost:1433;"
            + "databaseName=internet_jsp_sevlet;Encrypt=True;TrustServerCertificate=True;sendTimeAsDateTime=false";
	private static String username = "sa";
	private static String password = "12345";
	private static Connection connection;

	public BaseRepository() {
	}

	public static Connection getConnection(){
	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        connection = DriverManager.getConnection(jdbcURL, username, password);
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
}
