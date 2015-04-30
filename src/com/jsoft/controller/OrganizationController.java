/**
 * 
 */
package com.jsoft.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.model.Organization;
import com.jsoft.model.Timesheet;
import com.jsoft.service.OrganizationService;
import com.jsoft.service.TimesheetService;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/organizations")
public class OrganizationController {

	private OrganizationService organizationService;
	private TimesheetService timesheetService;
	
    public OrganizationService getOrganizationService() {
		return organizationService;
	}

    @Autowired
	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
    
	public TimesheetService getTimesheetService() {
		return timesheetService;
	}
	
	@Autowired
	public void setTimesheetService(TimesheetService timesheetService) {
		this.timesheetService = timesheetService;
	}

	@RequestMapping(method = RequestMethod.POST)
    public String showOrganizations(@RequestParam("term") String term, Model model) {
        List<Organization> organizations = organizationService.getOrganizationsLimitSortSearch(1, 20, "orgName", "asc", "orgName", term, "like");
        model.addAttribute("organizations", organizations);

        return "organizations/list";
    }
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String findOrganizations(@RequestParam(required = false, value = "orgId") String orgId, Model model) {
		
		List<Organization> organizations = new ArrayList<Organization>();
		if(orgId != null) {
			organizations.add(organizationService.getOrganizationByOrgId(orgId));
		}
		else {
						
			Date today = new Date();  

	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(today);  

	        calendar.add(Calendar.MONTH, -1);  

	        Date pastMonth = calendar.getTime();  
	        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
	        sdf.format(pastMonth);
	        	
			List<Timesheet> timesheets = timesheetService.getLastUpdate(DateTime.stringtoDate(sdf.format(pastMonth) + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
			if (timesheets != null) {
				Map <String, Organization> mapOrganization = new HashMap <String, Organization>();
				for (Timesheet timesheet : timesheets) {
					if (timesheet.getOrganization() != null)
					mapOrganization.put(timesheet.getOrganization().getOrgId(), timesheet.getOrganization());
//					System.out.println(timesheet.getOrganization().getOrgId());
//					System.out.println(mapOrganization);
				}

				for (Organization value : mapOrganization.values()) {
//					System.out.println(value);
					organizations.add(value);
				}
			}
		}
	    model.addAttribute("organizations", organizations);
	    return "organizations/list";
    }

    
}
