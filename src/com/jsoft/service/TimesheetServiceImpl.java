/**
 * 
 */
package com.jsoft.service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.TimesheetDAO;
import com.jsoft.model.Timesheet;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Service("timesheetService")
@Transactional
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	private TimesheetDAO timesheetDAO;
	
	@Override
	public Timesheet find(Integer id) {
		// TODO Auto-generated method stub
		return timesheetDAO.find(id);
	}

	@Override
	public void save(Timesheet clazz) {
		// TODO Auto-generated method stub
		timesheetDAO.save(clazz);
	}

	@Override
	public void update(Timesheet clazz) {
		Date remindDate = clazz.getEffectiveRemindDate();
		if(remindDate != null) {
//			System.out.println(DateTime.formatDate(remindDate, "yyyy-MM-dd", Locale.US) + " 00:00:00");
//			System.out.println(DateTime.stringtoDate(DateTime.formatDate(remindDate, "yyyy-MM-dd", Locale.US) + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
			clazz.setEffectiveRemindDate(DateTime.stringtoDate(DateTime.formatDate(remindDate, "yyyy-MM-dd", Locale.US) + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));	
		}
		timesheetDAO.update(clazz);
	}

	@Override
	public void saveOrUpdate(Timesheet clazz) {
		// TODO Auto-generated method stub
		timesheetDAO.saveOrUpdate(clazz);
	}

	@Override
	public List<Timesheet> findAll() {
		// TODO Auto-generated method stub
		return timesheetDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return timesheetDAO.countAll();
	}

	@Override
	public void delete(Timesheet clazz) {
		// TODO Auto-generated method stub
		timesheetDAO.delete(clazz);
	}

	@Override
	public List<Timesheet> getTimesheetByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return timesheetDAO.getTimesheetByOrgId(orgId);
	}

	@Override
	public void delete(int id) {
		timesheetDAO.delete(id);
		
	}

	@Override
	public List<Timesheet> getReminds(Date date) {
		// TODO Auto-generated method stub
		return timesheetDAO.getReminds(date);
	}

	@Override
	public List<Timesheet> getTimesheetByDealerId(String dealerId) {
		// TODO Auto-generated method stub
		return timesheetDAO.getTimesheetByDealerId(dealerId);
	}

	@Override
	public List<Timesheet> getLastUpdate(Date sinceDate) {
		// TODO Auto-generated method stub
		return timesheetDAO.getLastUpdate(sinceDate);
	}



}
