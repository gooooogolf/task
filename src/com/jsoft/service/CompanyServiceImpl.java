/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.CompanyDAO;
import com.jsoft.model.Company;

/**
 * @author Sirimongkol
 *
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private	CompanyDAO companyDAO;
	
	@Override
	public Company find(Integer id) {
		// TODO Auto-generated method stub
		return companyDAO.find(id);
	}

	@Override
	public void save(Company clazz) {
		// TODO Auto-generated method stub
		companyDAO.save(clazz);
	}

	@Override
	public void update(Company clazz) {
		// TODO Auto-generated method stub
		companyDAO.update(clazz);
	}

	@Override
	public void saveOrUpdate(Company clazz) {
		// TODO Auto-generated method stub
		companyDAO.saveOrUpdate(clazz);
		
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return companyDAO.countAll();
	}

	@Override
	public void delete(Company clazz) {
		// TODO Auto-generated method stub
		companyDAO.delete(clazz);
	}

}
