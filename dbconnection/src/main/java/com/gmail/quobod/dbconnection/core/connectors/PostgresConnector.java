package com.gmail.quobod.dbconnection.core.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class PostgresConnector {
	private String host;
	private String databaseName;
	private String password;
	private String user;
	public static Connection connection;
	
	public PostgresConnector(String hst, String db, String usr, String pwd) {
		if (null == hst || null == db || null == usr || null == pwd) {
			throw new NullPointerException("Expected non-null host url, database name, user and password\nCheck parameters");
		}
		
		if (hst.isEmpty() || db.isEmpty() || usr.isEmpty() || pwd.isEmpty()) {
			throw new NullPointerException("Expected non-empty host url, database name, user and password\nCheck parameters");
		}
		
		this.host = hst;
		this.databaseName = db;
		this.user = usr;
		this.password = pwd;
	}

	public boolean connected() {
		try {
			// the postgresql driver string
			Class.forName("org.postgresql.Driver");

			// the postgresql url
			String url = "jdbc:postgresql://" + host + "/" + databaseName;

			// get the postgresql database connection
			connection = DriverManager.getConnection(url, user, password);

			// now do whatever you want to do with the connection
			// ...
			return (!connection.isClosed() && null != connection);
		} catch (PSQLException psql) {
			psql.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException sql) {
			sql.printStackTrace();
			return false;
		}
	}
	
	public boolean closeConnection() {
		try {
			if (null != connection)
				connection.close();
			return connection.isClosed();
		} catch (SQLException sql) {
			sql.printStackTrace();
		} finally {
			connection = null;
			host = null;
			user = null;
			password = null;
			databaseName = null;
		}
		return false;
	}

}
