package com.diamensiondata.simple.util;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.diamensiondata.simple.model.ServerList;

public class XMLContentManagerTest {

	private XMLContentManager xmlContentManager;

	@Before
	public void setUp() throws Exception {
		xmlContentManager = XMLContentManager.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		xmlContentManager = null;
	}

	@Test
	public void testGetServerList() {
		ServerList serverList = null;
		try {
			serverList = xmlContentManager.getServerList(new File("target\\test-classes\\test.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, serverList.getServers().length);
	}

}
