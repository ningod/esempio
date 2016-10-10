/**
 * 
 */
package it.consulthink.be.esempio.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.consulthink.be.esempio.model.User;
import it.consulthink.be.esempio.service.UserService;

/**
 * @author svetrini
 *
 */
@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "singleton")
public class UserRestController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> list(HttpServletRequest request) {
		ResponseEntity<List<User>> response = null;
		List<User> result = null;
		try {
			result = service.listUsers();

			if (result == null) {
				response = new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
			} else {
				response = new ResponseEntity<List<User>>(result, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<List<User>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
