/**
 * 
 */
package com.jsoft.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsoft.model.Dealer;
import com.jsoft.model.Organization;
import com.jsoft.model.Timesheet;
import com.jsoft.service.TimesheetService;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class WelcomeController {
	
	@Autowired
	private TimesheetService timesheetService;

    @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
    public String showRemind(Model model) {
    	Date dateNow = new Date();
        List<Timesheet> timesheets = timesheetService.getReminds(DateTime.stringtoDate(DateTime.dateNow() + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        if(timesheets != null) {
        	List<Timesheet> showTimesheets = new ArrayList<Timesheet>();
        	long diff;
        	Map <String, Organization> organizationMap = new HashMap<String, Organization>();
        	Map <Integer, Dealer> dealerMap = new HashMap<Integer, Dealer>();
        	for (Timesheet timesheet: timesheets) {
        		diff = timesheet.getEffectiveRemindDate().getTime() - dateNow.getTime();
        		if((diff / (1000 * 60 * 60 * 24)) <= 30) {
        			if (timesheet.getOrganization() != null) {
        				organizationMap.put(timesheet.getOrganization().getOrgId(), timesheet.getOrganization());
        			}  	
        			else {
        				dealerMap.put(timesheet.getDealer().getId(), timesheet.getDealer());
        			}
        			showTimesheets.add(timesheet);
        		}
        		
        	}
        	model.addAttribute("organizations", organizationMap);
        	model.addAttribute("dealers", dealerMap);
        	model.addAttribute("timesheets", showTimesheets);
        }      
        return "index";
    }    
}
