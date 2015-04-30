/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jsoft.model.UploadFile;

/**
 * @author Sirimongkol
 *
 */
@Repository("uploadFileDAO")
public class UploadFileDAOImpl extends GenericDAOImpl<UploadFile> implements
		UploadFileDAO {

	@Override
	public int add(UploadFile fileUpload) {
		sessionFactory.getCurrentSession().save(fileUpload);
		sessionFactory.getCurrentSession().flush();
		return fileUpload.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UploadFile> getByTimesheet(int timesheetId) {
		   Query query = sessionFactory.getCurrentSession().createQuery(
	                "from UploadFile u where u.timesheetId = :timesheetId");
		   query.setParameter("timesheetId", timesheetId);
		   return  query.list();
	}
	
}
