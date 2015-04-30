/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.StatusDAO;
import com.jsoft.model.Status;

/**
 * @author Sirimongkol
 *
 */
@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusDAO statusDAO;
	
	@Override
	public Status find(Integer id) {
		// TODO Auto-generated method stub
		return statusDAO.find(id);
	}

	@Override
	public void save(Status clazz) {
		// TODO Auto-generated method stub
		statusDAO.save(clazz);
	}

	@Override
	public void update(Status clazz) {
		// TODO Auto-generated method stub
		statusDAO.update(clazz);
		
	}

	@Override
	public void saveOrUpdate(Status clazz) {
		// TODO Auto-generated method stub
		statusDAO.saveOrUpdate(clazz);
		
	}

	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return statusDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return statusDAO.countAll();
	}

	@Override
	public void delete(Status clazz) {
		// TODO Auto-generated method stub
		statusDAO.delete(clazz);
	}

}
