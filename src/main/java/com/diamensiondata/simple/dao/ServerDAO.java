package com.diamensiondata.simple.dao;

import java.util.List;

import com.diamensiondata.simple.model.Server;

public interface ServerDAO {
	
	public void save(Server server);
	
	public List<Server> getAllServers();
	
	public int count() ;
	
	public boolean delete(int id);
	
	public boolean modify(int id, String name);
	
}
