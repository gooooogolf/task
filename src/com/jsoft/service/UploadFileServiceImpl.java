/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.UploadFileDAO;
import com.jsoft.model.UploadFile;

/**
 * @author Sirimongkol
 *
 */
@Service("uploadFileService")
@Transactional
public class UploadFileServiceImpl implements UploadFileService {
	
	@Autowired
	private UploadFileDAO uploadFileDAO;
	
	@Override
	public UploadFile find(Integer id) {
		// TODO Auto-generated method stub
		return uploadFileDAO.find(id);
	}

	@Override
	public void save(UploadFile clazz) {
		// TODO Auto-generated method stub
		uploadFileDAO.save(clazz);
	}

	@Override
	public void update(UploadFile clazz) {
		// TODO Auto-generated method stub
		uploadFileDAO.update(clazz);
	}

	@Override
	public List<UploadFile> findAll() {
		// TODO Auto-generated method stub
		return uploadFileDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return uploadFileDAO.countAll();
	}

	@Override
	public void delete(UploadFile clazz) {
		uploadFileDAO.delete(clazz);
		
	}

	@Override
	public int add(UploadFile fileUpload) {
		// TODO Auto-generated method stub
		return uploadFileDAO.add(fileUpload);
	}

	@Override
	public List<UploadFile> getByTimesheet(int timesheetId) {
		// TODO Auto-generated method stub
		return uploadFileDAO.getByTimesheet(timesheetId);
	}

	@Override
	public void saveOrUpdate(UploadFile clazz) {
		uploadFileDAO.saveOrUpdate(clazz);
		
	}

}
