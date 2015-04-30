/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.OrganizationDAO;
import com.jsoft.model.Organization;

/**
 * @author Sirimongkol
 *
 */
@Service("organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;
	
	@Override
	public List<Organization> getOrganizationByTerm(String orgName) {
		return organizationDAO.getOrganizationByTerm(orgName);
	}

	@Override
	public Organization getOrganizationByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return organizationDAO.getOrganizationByOrgId(orgId);
	}

	@Override
	public Organization find(Integer id) {
		// TODO Auto-generated method stub
		return organizationDAO.find(id);
	}

	@Override
	@Transactional
	public void save(Organization clazz) {
		// TODO Auto-generated method stub
		organizationDAO.save(clazz);
	}

	@Override
	@Transactional
	public void update(Organization clazz) {
		// TODO Auto-generated method stub
		organizationDAO.update(clazz);
	}

	@Override
	public List<Organization> findAll() {
		// TODO Auto-generated method stub
		return organizationDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return organizationDAO.countAll();
	}

	@Override
	public void delete(Organization clazz) {
		// TODO Auto-generated method stub
		organizationDAO.delete(clazz);
		
	}

	@Override
	public List<Organization> getOrganizationsLimitSort(int page, int rows, String idx, String sort) {
		// TODO Auto-generated method stub
		return organizationDAO.getOrganizationsLimitSort(page, rows, idx, sort);
	}

	@Override
	public List<Organization> getOrganizationsLimitSortSearch(int page, int rows, String idx, String sort, String searchField, String searchString, String searchOper) {
		return organizationDAO.getOrganizationsLimitSortSearch(page, rows, idx, sort, searchField, searchString, searchOper);
	}

	@Override
	public Integer countBy(String searchField, String searchString, String searchOper) {
		// TODO Auto-generated method stub
		return organizationDAO.countBy(searchField, searchString, searchOper);
	}

	@Override
	public void saveOrUpdate(Organization clazz) {
		organizationDAO.saveOrUpdate(clazz);
		
	}




}
