/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.UserDAO;
import com.jsoft.model.User;

/**
 * @author Sirimongkol
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User get(String userId) {
		// TODO Auto-generated method stub
		return userDAO.get(userId);
	}

	@Override
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.find(id);
	}

	@Override
	public void save(User clazz) {
		// TODO Auto-generated method stub
		userDAO.save(clazz);
		
	}

	@Override
	public void update(User clazz) {
		// TODO Auto-generated method stub
		userDAO.update(clazz);
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return userDAO.countAll();
	}

	@Override
	public void delete(User clazz) {
		// TODO Auto-generated method stub
		userDAO.delete(clazz);
		
	}

	@Override
	public void saveOrUpdate(User clazz) {
		userDAO.saveOrUpdate(clazz);
		
	}
	

}
