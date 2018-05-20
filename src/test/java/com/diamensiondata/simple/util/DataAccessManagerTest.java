package com.diamensiondata.simple.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.diamensiondata.simple.model.Server;
import com.diamensiondata.simple.model.ServerList;

public class DataAccessManagerTest {

	private DataAccessManager dataAccessManager = null;

	@Before
	public void setUp() throws Exception {
		dataAccessManager = DataAccessManager.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		//DataAccessManager.close();
		dataAccessManager = null;
	}

	@Test
	public void testSaveServers() {
		ServerList serverList = new ServerList();
		Server[] servers = new Server[2];
		servers[0] = new Server();
		servers[0].setId(1000);
		servers[0].setName("Server-1000");		
		servers[1] = new Server();
		servers[1].setId(1001);
		servers[1].setName("Server-1001");	
		serverList.setServers(servers);
		dataAccessManager.saveServers(serverList);		
		assertTrue(true);
	}

	@Test
	public void testGetServerCount() {
		ServerList serverList = new ServerList();
		Server[] servers = new Server[2];
		servers[0] = new Server();
		servers[0].setId(1002);
		servers[0].setName("Server-1002");		
		servers[1] = new Server();
		servers[1].setId(1003);
		servers[1].setName("Server-1003");	
		serverList.setServers(servers);
		dataAccessManager.saveServers(serverList);
		assertEquals(2,dataAccessManager.getServerCount());		
	}

	@Test
	public void testGetServerList() {
		assertNotNull(dataAccessManager.getServerList());
	}

	@Test
	public void testDeleteServer() {
		ServerList serverList = new ServerList();
		Server[] servers = new Server[1];
		servers[0] = new Server();
		servers[0].setId(1004);
		servers[0].setName("Server-1004");
		serverList.setServers(servers);
		dataAccessManager.saveServers(serverList);
		assertTrue(dataAccessManager.deleteServer(1004));
	}

	@Test
	public void testModifyServer() {
		ServerList serverList = new ServerList();
		Server[] servers = new Server[1];
		servers[0] = new Server();
		servers[0].setId(1005);
		servers[0].setName("Server-1005");
		serverList.setServers(servers);
		dataAccessManager.saveServers(serverList);
		assertTrue(dataAccessManager.modifyServer(1005, "SeverName=modified"));
		dataAccessManager.deleteServer(1005);
	}
}
