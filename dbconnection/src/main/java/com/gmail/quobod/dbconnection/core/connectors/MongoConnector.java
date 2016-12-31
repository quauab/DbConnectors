package com.gmail.quobod.dbconnection.core.connectors;

import java.sql.Connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

public class MongoConnector {
	public MongoClient mongoClient = null;
	private String host;
	private String port;
	private String user;
	private String password;
	private String databaseName;

	/**
	 * Constructor
	 * 
	 * @param hst
	 *            String database's location
	 * @param prt
	 *            String the location's port
	 * @param db
	 *            String the database's name
	 * @param usr
	 *            String database user
	 * @param pwd
	 *            String the user's password
	 */
	public MongoConnector(String hst, String prt, String db, String usr, String pwd) {
		if (null == hst || null == prt || null == db || null == usr || null == pwd) {
			throw new NullPointerException(
					"Expected non-null host url, port database name, user and password\nCheck parameters");
		}

		if (hst.isEmpty() || prt.isEmpty() || db.isEmpty() || usr.isEmpty() || pwd.isEmpty()) {
			throw new NullPointerException(
					"Expected non-empty host url, port database name, user and password\nCheck parameters");
		}

		this.host = hst;
		this.port = prt;
		this.databaseName = db;
		this.user = usr;
		this.password = pwd;
	}

	/**
	 * Connects to the database
	 * 
	 * @return String the connection point if successful
	 */
	public String connected() {
		try {
			// mongodb://<dbuser>:<dbpassword>@ds049466.mlab.com:49466/mytasks
			// tester:tester@ds049466.mlab.com:"
//			MongoClientURI uri = new MongoClientURI("mongodb://user1:pwd1@host1/?authSource=db1");

//			String url = "mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + databaseName;
			
			String url = "mongodb://" + user + ":" + password + "@" + host + ":" + port + "/?authSource=" + databaseName;

			MongoClientURI uri = new MongoClientURI(url, MongoClientOptions.builder().cursorFinalizerEnabled(false));

			mongoClient = new MongoClient(uri);
			// System.out.println("Connection Point: " +
			// client.getConnectPoint());
			return mongoClient.getConnectPoint();
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		} 
	}

	/**
	 * Closes the connection
	 * 
	 * @return true after nulling all of the class' variables
	 */
	public boolean closeConnection() {
		mongoClient.close();
		mongoClient = null;
		host = null;
		port = null;
		user = null;
		password = null;
		databaseName = null;
		return true;
	}
}
