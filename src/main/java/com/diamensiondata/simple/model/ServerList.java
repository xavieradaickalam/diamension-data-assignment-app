package com.diamensiondata.simple.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "serverlist")
public class ServerList {
	private Server [] servers  = new Server[100];

	public Server[] getServers() {
		return servers;
	}
	@XmlElement (name = "server")
	public void setServers(Server[] servers) {
		this.servers = servers;
	}	
}
