package com.diamensiondata.simple.util;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.diamensiondata.simple.dao.ServerDAO;
import com.diamensiondata.simple.model.Server;
import com.diamensiondata.simple.model.ServerList;

/**
 * Data Access Manager
 * @author I057588
 *
 */
public class DataAccessManager {
	
	private static final Logger log = LoggerFactory.getLogger(DataAccessManager.class);
	
	private static DataAccessManager dataAccessManager = null;
	private ClassPathXmlApplicationContext context = null;
	private ServerDAO serverDAO = null;
	
	private DataAccessManager () {
		log.debug("Creating a DataAccessManager");
		context = new ClassPathXmlApplicationContext("spring.xml");
		serverDAO = context.getBean(ServerDAO.class);
	}
	
	public static DataAccessManager getInstance() {
		if (null == dataAccessManager) {
			dataAccessManager = new DataAccessManager();
		}
		return dataAccessManager;
	}
	
	public void saveServers(ServerList serverList) {		
		Server [] servers = serverList.getServers();
		for(int i = 0; i < servers.length; i++) {
			serverDAO.save(servers[i]);
		}
	}
	
	public int getServerCount() {
		return serverDAO.count();
	}
	
	public List<Server> getServerList() {
		return serverDAO.getAllServers();
	}
	
	public boolean deleteServer(int id) {
		return serverDAO.delete(id);
	}
	
	public boolean modifyServer(int id, String name) {
		return serverDAO.modify(id, name);
	}
	
	public static void close () {
		if ( dataAccessManager != null) {
			dataAccessManager.context.close();
		}
	}
}
