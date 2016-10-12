/**
 * 
 */
package it.consulthink.be.esempio.rest;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import it.consulthink.be.esempio.service.ServiceException;

/**
 * @author svetrini
 *
 */
public interface RestController<T> extends Serializable{

//	@RequestMapping(value = "/model/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> find(HttpServletRequest request,/* @PathVariable  */ Long id) throws ServiceException;
//	@RequestMapping(value = "/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> list(HttpServletRequest request) throws ServiceException;
//	@RequestMapping(value = "/model/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> search(HttpServletRequest request,/* @RequestBody(required = false) */ FiltersAndOrders search) throws ServiceException;

	//TODO insert e update su POST e PUT

	
}