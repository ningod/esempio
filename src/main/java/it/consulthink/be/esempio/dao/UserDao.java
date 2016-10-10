/**
 * 
 */
package it.consulthink.be.esempio.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import it.consulthink.be.esempio.model.User;

/**
 * @author svetrini
 *
 */
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "singleton")
public class UserDao implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Autowired
	SessionFactory sessionFactory;

	
	


	public Session getSession() {
		Session result = null;
		result =  sessionFactory.getCurrentSession();
		if (result == null)
			throw new RuntimeException("Hibernate Session NULL");
		return result;
	}


	public void setSession(SessionFactory session) {
		this.sessionFactory = session;
	}


	@SuppressWarnings("unchecked")
	public List<User> listAll() throws DaoException {
		List<User> result = null;
		try {
			Query query = getSession().createQuery("from User ");
			result = (List<User>) query.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
		//log.trace("{} listAll :: {} ", User.class, result);
		return result;
	}
	

	public SessionFactory getSessionFactory() {
		SessionFactory result = null;
		result = sessionFactory;
		if (result == null)
			throw new RuntimeException("Hibernate SessionFactory NULL");
		return result;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	



	@Override
	public String toString() {
		String result = "[DAO for " + User.class + "]";
		try {
			result =  "[DAO for " + User.class + ", getIdProperty()=" + "id" + "]";
		} catch (Exception e) {
			//NOP
		}
		return result;
	}
	
	


}
