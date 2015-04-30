/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.Organization;

/**
 * @author Sirimongkol
 *
 */
@Repository("organizationDAO")
public class OrganizationDAOImpl extends GenericDAOImpl<Organization>
		implements OrganizationDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getOrganizationByTerm(String orgName) {
		String hql = "from Organization o where o.orgName like '%" + orgName + "%'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public Organization getOrganizationByOrgId(String orgId) {	
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Organization o where o.orgId = :orgId");
		   query.setParameter("orgId", orgId);
		   return (Organization) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getOrganizationsLimitSort(int page, int rows, String idx, String sort) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Organization o Order By o." + idx + " " + sort + "");
		   query.setFirstResult((page - 1) * rows);
	       query.setMaxResults(rows);
	       return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getOrganizationsLimitSortSearch(int page, int rows, String idx, String sort, String searchField, String searchString, String searchOper) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Organization o where o." + searchField + ((searchOper.equals("eq"))?(" = '" + searchString+ "'"):(" like '%" + searchString+ "%'")) + " Order By o." + idx + " " + sort + "");
		   query.setFirstResult((page - 1) * rows);
	       query.setMaxResults(rows);
	       return query.list();
	}

	@Override
	public Integer countBy(String searchField, String searchString, String searchOper) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from Organization o where o." + searchField + ((searchOper.equals("eq"))?(" = '" + searchString+ "'"):(" like '%" + searchString+ "%'")));
		   return query.list().size();
	}

}
