/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import com.jsoft.model.UploadFile;

/**
 * @author Sirimongkol
 *
 */
public interface UploadFileDAO extends GenericDAO<UploadFile> {
	public int add(UploadFile fileUpload);
	public List<UploadFile> getByTimesheet(int timesheetId);
}
