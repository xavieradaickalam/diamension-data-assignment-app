package com.diamensiondata.simple.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {
	
	private Server server;

	@Before
	public void setUp() throws Exception {
		server = new Server();
	}

	@After
	public void tearDown() throws Exception {
		server = null;
	}

	@Test
	public void testGetId() {
		server.setId(100);
		assertEquals(100, server.getId());
	}

	@Test
	public void testSetId() {
		server.setId(100);
		assertEquals(100, server.getId());
	}

	@Test
	public void testGetName() {
		server.setName("testServer");		
		assertEquals("testServer", server.getName());
	}

	@Test
	public void testSetName() {
		server.setName("testServer");		
		assertEquals("testServer", server.getName());
	}

}
