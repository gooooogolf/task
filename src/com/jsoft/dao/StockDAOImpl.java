/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.Stock;

/**
 * @author Sirimongkol
 *
 */
@Repository("stockDAO")
public class StockDAOImpl extends GenericDAOImpl<Stock> implements StockDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> searchStockByOrganizeId(String orgId) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Stock s where s.organization.orgId = :orgId order by s.serialNumber");
		   query.setParameter("orgId", orgId);
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> searchStockByDealerId(String dealerId) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Stock s where s.dealer.id = :dealerId order by s.serialNumber");
		   query.setParameter("dealerId", Integer.parseInt(dealerId));
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> searchStockBySerialNumber(String serialNumber) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Stock s where s.serialNumber = :serialNumber order by s.serialNumber");
		   query.setParameter("serialNumber", serialNumber);
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> searchStockByStockYear(String stockYear) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Stock s where s.stockYear = :stockYear order by s.serialNumber");
		   query.setParameter("stockYear", stockYear);
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> searchStockFreeByStockYear(String stockYear) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Stock s where s.stockYear = :stockYear and s.organization = null and s.dealer = null order by s.serialNumber");
		   query.setParameter("stockYear", stockYear);
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStockYear() {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "select distinct stock.stockYear from Stock stock order by stock.stockYear");
		   List<String> list = (List<String>) query.list();
		   return list;
	}
	
}
