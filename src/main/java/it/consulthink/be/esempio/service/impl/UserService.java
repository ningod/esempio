/**
 * 
 */
package it.consulthink.be.esempio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import it.consulthink.be.esempio.dao.DaoException;
import it.consulthink.be.esempio.dao.UserDao;
import it.consulthink.be.esempio.model.User;
import it.consulthink.be.esempio.service.ServiceException;

/**
 * @author svetrini
 *
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "singleton")
public class UserService implements it.consulthink.be.esempio.service.UserService {

	@Autowired
	UserDao dao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.consulthink.be.esempio.service.UserService#listUsers()
	 */
	@Override
	public List<User> listUsers() throws ServiceException{
		List<User> result = null;
		try {
			result = dao.listAll();
		} catch (DaoException e) {
			throw new ServiceException("errore recupero elenco utenti",e);
		}
		return result;
	}

}
