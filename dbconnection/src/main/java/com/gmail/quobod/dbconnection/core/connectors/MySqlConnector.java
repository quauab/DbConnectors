package com.gmail.quobod.dbconnection.core.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
//	private final String driver = "com.mysql.jdbc.Driver";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private String dbName;
	private String user;
	private String password;
	public static Connection connection;
	
	/**Constructor
	 * @param db String database name
	 * @param usr String database user
	 * @param pwd String user's password*/
	public MySqlConnector(String db, String usr, String pwd) {
		if (null == db || null == usr || null == pwd) {
			throw new NullPointerException("Expected non-null database name, user and password\nCheck parameters");
		}
		
		if (db.isEmpty() || usr.isEmpty() || pwd.isEmpty()) {
			throw new NullPointerException("Expected non-empty database name, user and password\nCheck parameters");
		}
		
		this.dbName = db;
		this.user = usr;
		this.password = pwd;
	}

	/**Connects to the database
	 * @return true if connection is successful*/
	public boolean connected() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			return (!connection.isClosed() && null != connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException sql) {
			sql.printStackTrace();
			return false;
		}
	}
	
	/**Closes the connection
	 * @return true if disconnection is successful*/
	public boolean closeConnection() {		
		try {
			if (null != connection)
				connection.close();
			return connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			connection = null;
			dbName = null;
			user = null;
			password = null;
		}
	}
}
