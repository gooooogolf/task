/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import com.jsoft.model.Organization;

/**
 * @author Sirimongkol
 *
 */
public interface OrganizationDAO extends GenericDAO<Organization> {
	public List<Organization> getOrganizationsLimitSort(int page, int rows, String idx, String sort);
	public List<Organization> getOrganizationsLimitSortSearch(int page, int rows, String idx, String sort, String searchField, String searchString, String searchOper);
	public List<Organization> getOrganizationByTerm(String orgName);
	public Organization getOrganizationByOrgId(String orgId);
	public Integer countBy(String searchField, String searchString, String searchOper);
}
