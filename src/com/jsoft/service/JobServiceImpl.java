/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.JobDAO;
import com.jsoft.model.Job;

/**
 * @author Sirimongkol
 *
 */
@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Override
	public Job find(Integer id) {
		// TODO Auto-generated method stub
		return jobDAO.find(id);
	}

	@Override
	public void save(Job clazz) {
		// TODO Auto-generated method stub
		jobDAO.save(clazz);
	}

	@Override
	public void update(Job clazz) {
		// TODO Auto-generated method stub
		jobDAO.update(clazz);
		
	}

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return jobDAO.countAll();
	}

	@Override
	public void delete(Job clazz) {
		// TODO Auto-generated method stub
		jobDAO.delete(clazz);
		
	}

	@Override
	public void saveOrUpdate(Job clazz) {
		// TODO Auto-generated method stub
		jobDAO.saveOrUpdate(clazz);
		
	}

}
