/**
 * 
 */
package com.jsoft.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.User;

/**
 * @author Sirimongkol
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	@Override
	public User get(String userId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from User u where u.username = :username");
        query.setParameter("username", userId);
        if(query.list().isEmpty()) return null;
        return (User) query.list().get(0);
	}
	

}
