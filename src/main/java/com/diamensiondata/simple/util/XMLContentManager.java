package com.diamensiondata.simple.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diamensiondata.simple.model.Server;
import com.diamensiondata.simple.model.ServerList;

/**
 * XML Content Manager
 * @author I057588
 *
 */
public class XMLContentManager {

	private static final Logger log = LoggerFactory.getLogger(XMLContentManager.class);
	private static XMLContentManager xmlContentReader = null;

	public static XMLContentManager getInstance() {
		if (null == xmlContentReader) {
			xmlContentReader = new XMLContentManager();
		}
		return xmlContentReader;
	}
	
    /**
     *   Utils to create the server details xml
     */
	public void generateServerList() {
		Server[] servers = new Server[10];
		for (int i = 0; i < 10; i++) {
			Server server = new Server();
			server.setId(i);
			server.setName("ServerName-" + i);
			servers[i] = server;
		}
		ServerList serverList = new ServerList();
		serverList.setServers(servers);
		try {

			File file = new File("C:\\temp\\server_defination.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Server.class, ServerList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(serverList, file);
			jaxbMarshaller.marshal(serverList, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
    /**
     *  Reads the sever defination from the XML file.
     * @param file
     * @return
     * @throws JAXBException
     */
	public ServerList getServerList(File file) throws JAXBException {
		log.debug("processing a xml content");
		JAXBContext jaxbContext = JAXBContext.newInstance(Server.class, ServerList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ServerList serverList = (ServerList) jaxbUnmarshaller.unmarshal(file);
		log.debug("processed a xml content");
		return serverList;
	}
}
