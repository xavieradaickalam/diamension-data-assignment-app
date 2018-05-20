package com.diamensiondata.simple.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerListTest {

	private ServerList serverList = null;
	
	@Before
	public void setUp() throws Exception {
		serverList = new ServerList();
	}

	@After
	public void tearDown() throws Exception {
		serverList = null;
	}

	@Test
	public void testGetServers() {
		Server [] servers = new Server[2];
		servers[0] = new Server();
		servers[0] = new Server();
		serverList.setServers(servers);
		Server [] serversTest = serverList.getServers();
		assertEquals(2,serversTest.length);
	}

	@Test
	public void testSetServers() {
		Server [] servers = new Server[2];
		servers[0] = new Server();
		servers[0] = new Server();
		serverList.setServers(servers);
		Server [] serversTest = serverList.getServers();
		assertEquals(2,serversTest.length);
	}

}
