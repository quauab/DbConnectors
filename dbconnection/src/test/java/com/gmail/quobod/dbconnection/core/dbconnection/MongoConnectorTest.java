package com.gmail.quobod.dbconnection.core.dbconnection;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gmail.quobod.dbconnection.core.connectors.MongoConnector;

public class MongoConnectorTest {
	MongoConnector mc;
	// mongodb://<dbuser>:<dbpassword>@ds049466.mlab.com:49466/mytasks
	// tester:tester@ds049466.mlab.com:"
	String host = "ds049466.mlab.com";
	String port = "49466";
	String user = "tester";
	String password = "tester";
	String db = "mytasks";

	@Test
	public void testSuccessfulOpenAndCloseConnection() {
		mc = new MongoConnector(host, port, db, user, password);
		String connection = null;
		String connectionPoint = host + ":" + port;
		connection = mc.connected();
		// boolean closed = mc.closeConnection();

		// println(connection);

		assertTrue("Not connected", null != connection);
		assertTrue("Not connected", connectionPoint.equals(connection));
		boolean closed = mc.closeConnection();
		assertTrue("Connection still open", closed);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullFirstArgument() {
		mc = new MongoConnector(null, port, db, user, password);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorEmptyFirstArgument() {
		mc = new MongoConnector("", port, db, user, password);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullSecondArgument() {
		mc = new MongoConnector(host, null, db, user, password);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorEmptySecondArgument() {
		mc = new MongoConnector(host, "", db, user, password);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorNullThirdArgument() {
		mc = new MongoConnector(host, port, null, user, password);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorEmptyThirdArgument() {
		mc = new MongoConnector(host, port, "", user, password);
	}

	@Test(expected = NullPointerException.class)

	public void testConstructorNullFourthArgument() {
		mc = new MongoConnector(host, port, db, user, null);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructorEmptyFourthArgument() {
		mc = new MongoConnector(host, port, db, user, "");
	}

	void print(Object obj) {
		System.out.print(String.valueOf(obj));
	}

	void println(Object obj) {
		System.out.println(String.valueOf(obj));
	}
}
