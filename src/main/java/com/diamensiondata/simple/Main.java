package com.diamensiondata.simple;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diamensiondata.simple.model.Server;
import com.diamensiondata.simple.model.ServerList;
import com.diamensiondata.simple.util.DataAccessManager;
import com.diamensiondata.simple.util.XMLContentManager;
/**
 *  Main Application
 * @author I057588
 *
 */
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		showMainMenu();
	}	
	/**
	 *  Main Menu
	 */
	public static void showMainMenu() {	
		System.out.println("----------------------------------------------");
		System.out.println("              Main Menu                       ");
		System.out.println("----------------------------------------------\n");		
		System.out.println("1. Load Server Specification XML");
		System.out.println("2. Count No of Servers");
		System.out.println("3. List All Servers");
		System.out.println("4. Delete Server");
		System.out.println("5. Modify Server Name");
		System.out.println("6. Exit");
		System.out.print("Select the option :");
		Scanner scanner = new Scanner(System.in);
		int mainOption = scanner.nextInt();
		if(mainOption == 6) {
			System.out.println("Good Bye...");
			DataAccessManager.close();
			System.exit(1);
		} else {
			handleOptions(mainOption);
		}
		
	}
	/**
	 *  Handles the options selected in the menu
	 * @param i
	 */
	public static void handleOptions(int i) {	
		Scanner scanner = new Scanner(System.in);
		int id;
		String name;
		switch(i) {
		 	case 1:
		 		System.out.print("\nEnter the FileName (eg: c:\\temp\\server_defination.xml ) :");
		 		String filename = scanner.nextLine();
				loadServerSpecification(filename);
		 		break;
		 	case 2:
		 		countServer();
		 		break;
		 	case 3:
		 		listServers();
		 		break;
		 	case 4:
		 		System.out.print("\nEnter Server Id :");		 		
		 		id = scanner.nextInt();
		 		deleteServer(id);
		 		break;
		 	case 5:
		 		System.out.print("\nEnter Server Id :");		 		
		 		id = scanner.nextInt();
		 		System.out.print("\nEnter new Server Name (to Modify) :");
		 		Scanner scan = new Scanner(System.in);
		 		name = scan.nextLine();
		 		modifyServer(id,name);
		 		break;
		 	default :
		 		break;
		 }
		 showMainMenu();
	}
	/**
	 *  Modifies the Server Name
	 * @param id
	 * @param name
	 */
	public static void modifyServer(int id, String name) {
		DataAccessManager dataAccessManager = DataAccessManager.getInstance();
		dataAccessManager.modifyServer(id, name);
	}
    /**
     *  Deletes the Server
     * @param id
     */
	public static void deleteServer(int id) {
		DataAccessManager dataAccessManager = DataAccessManager.getInstance();
		dataAccessManager.deleteServer(id);
	}
    /**
     *  Lists all the servers in the database
     */
	public static void listServers() {
		DataAccessManager dataAccessManager = DataAccessManager.getInstance();
		List<Server> servers = dataAccessManager.getServerList();
		Iterator<Server> iterator = servers.iterator();
		while (iterator.hasNext()) {
			Server server = iterator.next();
			System.out.println(server.toString());
		}
	}
    /**
     * Counting the total no of servers in Database
     */
	public static void countServer() {
		DataAccessManager dataAccessManager = DataAccessManager.getInstance();
		System.out.println("Total No of Servers  : " + dataAccessManager.getServerCount());
	}
    /**
     *  Loads the server details to database using xml
     * @param filename
     */
	public static void loadServerSpecification(String filename) {
		ServerList serverList = null;
		File file = new File(filename);
		boolean empty = !file.exists() || file.length() == 0;
		if (empty) {
			log.error("File does not exits or empty");
		} else {
			XMLContentManager xmlContentManger = XMLContentManager.getInstance();
			try {
				serverList = xmlContentManger.getServerList(file);
			} catch (JAXBException e) {
				log.error(e.getMessage());
			}
			DataAccessManager dataAccessManager = DataAccessManager.getInstance();
			dataAccessManager.saveServers(serverList);
		}
	}
}