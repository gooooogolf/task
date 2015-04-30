/**
 * 
 */
package com.jsoft.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.Timesheet;

/**
 * @author Sirimongkol
 *
 */
@Repository("timesheetDAO")
public class TimesheetDAOImpl extends GenericDAOImpl<Timesheet> implements TimesheetDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> getTimesheetByOrgId(String orgId) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Timesheet t where t.organization.orgId = :orgId");
		   query.setParameter("orgId", orgId);
		   return query.list();
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(find(id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> getReminds(Date date) {
		
//		   Map<String, Object> parameterNameAndValues = new HashMap<String, Object>();
//
//			String strDate = DateTime.formatDate(date, "yyyy-MM-dd", Locale.US);
//			Date startDate = DateTime.stringtoDate(strDate + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
//			Date endDate = DateTime.stringtoDate(strDate + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
//
//		   // Assign values to startDate and endDate
//
//		   parameterNameAndValues.put("startDate", startDate);
//		   parameterNameAndValues.put("endDate", endDate);
//
//		   String hqlQuery = "FROM Timesheet WHERE effectiveRemindDate BETWEEN :startDate AND :endDate";
//
//		   Query query = this.sessionFactory.getCurrentSession().createQuery(hqlQuery);
//
//		   for (Entry<String, Object> e : parameterNameAndValues.entrySet()) {
//		       query.setParameter(e.getKey(), e.getValue());
//		   }
//
//		   return query.list();
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Timesheet t where t.effectiveRemindDate >= :effectiveRemindDate");
		   query.setParameter("effectiveRemindDate", date);
		   return  query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> getTimesheetByDealerId(String dealerId) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Timesheet t where t.dealer.id = :dealerId");
		   query.setParameter("dealerId", Integer.parseInt(dealerId));
		   return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> getLastUpdate(Date sinceDate) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Timesheet t where t.effectiveDate >= :sinceDate");
		   query.setParameter("sinceDate", sinceDate);
//		   query.setFirstResult((1 - 1) * 10);
//	       query.setMaxResults(10);
		   return  query.list();
	}

	
}
