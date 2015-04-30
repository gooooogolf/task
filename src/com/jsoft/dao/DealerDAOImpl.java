/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.Dealer;

/**
 * @author Sirimongkol
 *
 */
@Repository("dealerDAO")
public class DealerDAOImpl extends GenericDAOImpl<Dealer> implements DealerDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> getDealerByTerm(String dealerName) {
		String hql = "from Dealer o where o.name like '%" + dealerName + "%'";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> getDealerByTermLimit(String dealerName, int limit) {
		String hql = "from Dealer o where o.name like '%" + dealerName + "%' order by o.id desc";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((1 - 1) * limit);
	    query.setMaxResults(limit);
		return query.list();
	}

}
