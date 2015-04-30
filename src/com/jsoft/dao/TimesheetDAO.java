/**
 * 
 */
package com.jsoft.dao;

import java.util.Date;
import java.util.List;

import com.jsoft.model.Timesheet;

/**
 * @author Sirimongkol
 *
 */
public interface TimesheetDAO extends GenericDAO<Timesheet> {
	public List<Timesheet> getTimesheetByOrgId(String orgId);
	public List<Timesheet> getTimesheetByDealerId(String dealerId);
	public List<Timesheet> getReminds(Date date);
	public List<Timesheet> getLastUpdate(Date sinceDate);
	public void delete(int id);
}
