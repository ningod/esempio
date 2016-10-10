/**
 * 
 */
package it.consulthink.be.esempio.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.consulthink.be.esempio.model.User;

/**
 * @author svetrini
 *
 */
@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "singleton")
public class UserRestController {

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> list(HttpServletRequest request) {
		ResponseEntity<List<User>> response = null;
		List<User> result = null;
		try {
			// TODO codice da ridefinire
			result = new ArrayList<User>();
			User tmp = new User();
			tmp.setName("Stefano");
			// TODO popolare utente
			result.add(tmp);

			if (result == null) {
				response = new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
			} else {

				response = new ResponseEntity<List<User>>(result, HttpStatus.OK);
			}

		} catch (Throwable e) {
			response = new ResponseEntity<List<User>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
