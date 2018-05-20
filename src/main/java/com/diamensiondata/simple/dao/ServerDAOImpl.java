package com.diamensiondata.simple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diamensiondata.simple.model.Server;
/**
 * DAO implementation using hibernate ORM
 * @author I057588
 *
 */
public class ServerDAOImpl implements ServerDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ServerDAO.class);
	
	private SessionFactory sessionFactory;
	
    /**
     *  setds Session factory
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     *  Saves the server object to database
     */
	public void save(Server server) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.persist(server);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
    /**
     *  Gets all the servers from database
     */
	@SuppressWarnings("unchecked")
	public List<Server> getAllServers() {
		Session session = this.sessionFactory.openSession();
		List<Server> serverList = session.createQuery("from com.diamensiondata.simple.model.Server").list();
		session.close();
		return serverList;
	}
    /**
     *   Counts the servers in database
     */
	public int count() {
		Session session = this.sessionFactory.openSession();		
		Number rowcount = (Number) session.createCriteria("com.diamensiondata.simple.model.Server")
							.setProjection(Projections.rowCount())
							.uniqueResult();
		session.flush();
		session.close();
		return rowcount.intValue();
		
	}
    /**
     *  Deletes the Server
     */
	public boolean delete(int id) {
		boolean result = false;
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Server server = (Server) session.get(Server.class, id);		
		if(server != null) {
			session.delete(server);
			result = true;
		} else {
			log.error("Server does not exits :" + id);
		}		
		session.getTransaction().commit();
		session.flush();
		session.close();
		return result;
	}
    /**
     *   Modifies the server name for the given id
     */
	public boolean modify(int id, String name) {
		boolean result = false;
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Server server = (Server) session.get(Server.class, id);		
		if(server != null) {
			server.setName(name);
			session.update(server);
			result = true;
		} else {
			log.error("Server does not exits :" + id);
		}		
		session.getTransaction().commit();
		session.flush();
		session.close();
		return result;
	}
}
