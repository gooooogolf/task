/**
 * 
 */
package com.jsoft.dao;

import org.springframework.stereotype.Repository;

import com.jsoft.model.Company;

/**
 * @author Sirimongkol
 *
 */
@Repository("companyDAO")
public class CompanyDAOImpl extends GenericDAOImpl<Company> implements CompanyDAO{

	
}
