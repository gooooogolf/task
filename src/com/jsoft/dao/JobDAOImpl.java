/**
 * 
 */
package com.jsoft.dao;

import org.springframework.stereotype.Repository;

import com.jsoft.model.Job;

/**
 * @author Sirimongkol
 *
 */
@Repository("jobDAO")
public class JobDAOImpl extends GenericDAOImpl<Job> implements JobDAO {

}
