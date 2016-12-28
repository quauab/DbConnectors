package com.gmail.quobod.dbconnection.core.dbconnection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gmail.quobod.dbconnection.core.connectors.PostgresConnector;

public class PostgresConnectorTest {
	PostgresConnector psc;
	String host = "localhost";
	String user = "rick";
	String password = "eatme";
	String db = "users";
	
	@Test
	public void testSuccessfulOpenAndCloseConnection() {
		psc = new PostgresConnector(host, db, user, password);
		assertTrue("Not connected",  psc.connected());
		assertTrue("Connection still open", psc.closeConnection());
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorNullFirstArgument() {
		psc = new PostgresConnector(null, db, user, password);
	}

	@Test(expected=NullPointerException.class)
	public void testConstructorEmptyFirstArgument() {
		psc = new PostgresConnector("", db, user, password);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorNullSecondArgument() {
		psc = new PostgresConnector(host, null, user, password);
	}

	@Test(expected=NullPointerException.class)
	public void testConstructorEmptySecondArgument() {
		psc = new PostgresConnector(host, "", user, password);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorNullThirdArgument() {
		psc = new PostgresConnector(host, db, null, password);
	}

	@Test(expected=NullPointerException.class)
	public void testConstructorEmptyThirdArgument() {
		psc = new PostgresConnector(host, db, "", password);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorNullFourthArgument() {
		psc = new PostgresConnector(host, db, user, null);
	}

	@Test(expected=NullPointerException.class)
	public void testConstructorEmptyFourthArgument() {
		psc = new PostgresConnector(host, db, user, "");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorNullArguments() {
		psc = new PostgresConnector(null, null, null, null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructorEmptyArguments() {
		psc = new PostgresConnector("", "", "", "");
	}
	
}
