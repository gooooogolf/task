/**
 * 
 */
package com.jsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsoft.model.Timesheet;
import com.jsoft.service.TimesheetService;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"remind", "reminds"})
public class RemindController {
	
	@Autowired
	private TimesheetService timesheetService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRemindPage(){	
		return "reminds";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public List<Timesheet> getReminds(){
		return timesheetService.getReminds(DateTime.stringtoDate(DateTime.dateNow(), "yyyy-MM-dd"));
	}
}
