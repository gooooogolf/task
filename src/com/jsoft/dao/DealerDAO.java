/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import com.jsoft.model.Dealer;

/**
 * @author Sirimongkol
 *
 */
public interface DealerDAO extends GenericDAO<Dealer> {
	public List<Dealer> getDealerByTerm(String dealerName);
	public List<Dealer> getDealerByTermLimit(String dealerName, int limit);
}
