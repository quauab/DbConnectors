package com.gmail.quobod.dbconnection.core.dbconnection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gmail.quobod.dbconnection.core.connectors.MongoConnector;

public class MongoConnectorTest {
	MongoConnector mc;
//	mongodb://<dbuser>:<dbpassword>@ds049466.mlab.com:49466/mytasks
//	tester:tester@ds049466.mlab.com:"
	String host = "ds049466.mlab.com";
	String port = "49466";
	String user = "tester";
	String password = "tester";
	String db = "mytasks";
	
	@Test
	public void testSuccessfulOpenAndCloseConnection() {
		mc = new MongoConnector(host, port, db, user, password);
		String connection = null;
		connection = mc.connected();
		println(connection);
		
		assertTrue("Not connected", null != connection);
	}

	void print(Object obj) {
		System.out.print(String.valueOf(obj));
	}
	
	void println(Object obj) {
		System.out.println(String.valueOf(obj));
	}
}
