package com.gmail.quobod.dbconnection.core.connectors;

import java.sql.Connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

public class MongoConnector {
	public static MongoClient mongoClient = null;
	private String host;
	private String port;
	private String user;
	private String password;
	private String databaseName;
	
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

	public String connected() {
//		mongodb://<dbuser>:<dbpassword>@ds049466.mlab.com:49466/mytasks
//		tester:tester@ds049466.mlab.com:"
		
		String url = "mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + databaseName;
		
		MongoClientURI uri = new MongoClientURI(url, MongoClientOptions.builder().cursorFinalizerEnabled(false));
		
		MongoClient client = new MongoClient(uri);
		return client.getConnectPoint() + ":" + client.getAddress();
	}
	
	boolean closeConnection() {
		mongoClient.close();
		mongoClient = null;
		return true;
	}
}
