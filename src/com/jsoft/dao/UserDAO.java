/**
 * 
 */
package com.jsoft.dao;

import com.jsoft.model.User;

/**
 * @author Sirimongkol
 *
 */
public interface UserDAO extends GenericDAO<User>{
	public User get(String userId);
}
