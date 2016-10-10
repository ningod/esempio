/**
 * 
 */
package it.consulthink.be.esempio.service;

import java.io.Serializable;
import java.util.List;

import it.consulthink.be.esempio.model.User;

/**
 * @author svetrini
 *
 */
public interface UserService extends Serializable{

	public List<User> listUsers() throws ServiceException;
}
