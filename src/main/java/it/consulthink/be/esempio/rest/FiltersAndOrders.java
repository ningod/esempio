/**
 * 
 */
package it.consulthink.be.esempio.rest;

import java.util.HashMap;

/**
 * @author svetrini
 *
 */
public class FiltersAndOrders {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> filters;
	private HashMap<String, String> orders;

	public FiltersAndOrders() {
		super();
	}

	public HashMap<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(HashMap<String, Object> filters) {
		this.filters = filters;
	}

	public HashMap<String, String> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<String, String> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((filters == null) ? 0 : filters.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiltersAndOrders other = (FiltersAndOrders) obj;
		return this.hashCode() == other.hashCode();
	}

	@Override
	public String toString() {
		return "FiltersAndOrders [filters=" + filters + ", orders=" + orders + "]";
	}

}
