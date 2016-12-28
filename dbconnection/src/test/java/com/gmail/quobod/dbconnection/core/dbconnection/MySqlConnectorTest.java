package com.gmail.quobod.dbconnection.core.dbconnection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gmail.quobod.dbconnection.core.connectors.MySqlConnector;

public class MySqlConnectorTest {
	MySqlConnector msc;
	String host = "localhost";
	String user = "userstester";
	String password = "tester";
	String db = "users_test";
	
	@Test
	public void testSuccessfulOpenAndCloseConnection() {
		msc = new MySqlConnector(db, user, password);
		assertTrue("Not connected", msc.connected());
		assertTrue("Connection still open", msc.closeConnection());
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorNullFirstArgument() {
		msc = new MySqlConnector(null, user, password);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorEmptyFirstArgument() {
		msc = new MySqlConnector("", user, password);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorNullSecondArgument() {
		msc = new MySqlConnector(db, null, password);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorEmptySecondArgument() {
		msc = new MySqlConnector(db, "", password);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorNullThirdArgument() {
		msc = new MySqlConnector(db, user, null);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorEmptyThirdArgument() {
		msc = new MySqlConnector(db, user, "");
	}

	@Test (expected=NullPointerException.class)	
	public void testConstructorNullArguments() {
		msc = new MySqlConnector(null, null, null);
	}
	
	@Test (expected=NullPointerException.class)	
	public void testConstructorEmptyArguments() {
		msc = new MySqlConnector("", "", "");
	}
}
