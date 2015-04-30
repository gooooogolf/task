/**
 * 
 */
package com.jsoft.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.controller.editors.DealerEditor;
import com.jsoft.controller.editors.JobEditor;
import com.jsoft.controller.editors.OrganizationEditor;
import com.jsoft.controller.editors.StatusEditor;
import com.jsoft.controller.editors.UploadFileEditor;
import com.jsoft.controller.editors.UserEditor;
import com.jsoft.model.Dealer;
import com.jsoft.model.Job;
import com.jsoft.model.Organization;
import com.jsoft.model.Status;
import com.jsoft.model.Timesheet;
import com.jsoft.model.UploadFile;
import com.jsoft.model.User;
import com.jsoft.service.DealerService;
import com.jsoft.service.JobService;
import com.jsoft.service.OrganizationService;
import com.jsoft.service.StatusService;
import com.jsoft.service.TimesheetService;
import com.jsoft.service.UploadFileService;
import com.jsoft.service.UserService;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/timesheet", "/timesheets"})
public class TimesheetController {
	
	private OrganizationService organizationService;
	private TimesheetService timesheetService;
	private JobService jobService;
	private StatusService statusService;
	private UploadFileService uploadFileService;
	private UserService userService;
	private DealerService dealerService;
	
	public DealerService getDealerService() {
		return dealerService;
	}
	@Autowired
	public void setDealerService(DealerService dealerService) {
		this.dealerService = dealerService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UploadFileService getUploadFileService() {
		return uploadFileService;
	}
	@Autowired
	public void setUploadFileService(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}
	public JobService getJobService() {
		return jobService;
	}
	@Autowired
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	public StatusService getStatusService() {
		return statusService;
	}
	@Autowired
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}
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
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    	binder.registerCustomEditor(Organization.class, new OrganizationEditor(organizationService));
    	binder.registerCustomEditor(UploadFile.class, new UploadFileEditor(uploadFileService));
    	binder.registerCustomEditor(Job.class, new JobEditor(jobService));
        binder.registerCustomEditor(Status.class, new StatusEditor(statusService));
        binder.registerCustomEditor(User.class, new UserEditor(userService));
        binder.registerCustomEditor(Dealer.class, new DealerEditor(dealerService));
    }
    
	@RequestMapping(method = RequestMethod.GET)
    public String getTimesheetsByOrgId(@RequestParam("orgId") String orgId, Model model) {
		
		Organization organization = organizationService.getOrganizationByOrgId(orgId);
		model.addAttribute("organization", organization);
		
		List<Timesheet> timesheets = timesheetService.getTimesheetByOrgId(orgId);
		model.addAttribute("timesheets", timesheets);
        
		return "timesheets/list";
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getTimesheetById(@RequestParam("id") int id, Model model, HttpServletRequest request) {	
		Timesheet timesheet = timesheetService.find(id); 
		model.addAttribute("status", statusService.findAll());
		model.addAttribute("jobs", jobService.findAll()); 
		model.addAttribute("timesheet", timesheet);
        
		return "timesheets/view";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTimesheet(@ModelAttribute("timesheet") Timesheet timesheet) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); 
		try {
			timesheet.setEffectiveDate(new Date());
			if (timesheet.getUserModify().getUsername().equals(username)) {
				timesheetService.update(timesheet);
			}
			else {
				timesheet.setId(0);
				timesheet.setUserModify(userService.get(username));
				timesheetService.save(timesheet);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/timesheets?orgId=" + timesheet.getOrganization().getOrgId();	
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createTimesheetForm(@RequestParam("orgId") String orgId, Model model) {
		
		model.addAttribute("organization", organizationService.getOrganizationByOrgId(orgId));       
		model.addAttribute("status", statusService.findAll());
		model.addAttribute("jobs", jobService.findAll()); 
		model.addAttribute("timesheet", new Timesheet());
		return "timesheets/new";
		
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTimesheet(Timesheet timesheet) {	
//		System.out.println(timesheet);
		timesheet.setEffectiveDate(new Date());
		timesheetService.saveOrUpdate(timesheet);        
		return "redirect:/timesheets?orgId=" + timesheet.getOrganization().getOrgId();
		
    }
	
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTimesheet(@RequestParam("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
    	Timesheet toDelete = timesheetService.find(id);
    	if (toDelete.getUserModify().getUsername().equals(username)) {
    		timesheetService.delete(toDelete);
    	}
        return "redirect:/timesheets?orgId=" + toDelete.getOrganization().getOrgId();
    }
    
	@RequestMapping(value = "/dealer/new", method = RequestMethod.GET)
    public String createDealerTimesheetForm(@RequestParam("dealerId") int dealerId, Model model) {
		
		model.addAttribute("dealer", dealerService.find(dealerId));       
		model.addAttribute("status", statusService.findAll());
		model.addAttribute("jobs", jobService.findAll()); 
		model.addAttribute("timesheet", new Timesheet());
		return "timesheets/new-dealer";
		
    }
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
    public String addDealerTimesheet(Timesheet timesheet) {	
		timesheet.setEffectiveDate(new Date());
		timesheetService.saveOrUpdate(timesheet);        
		return "redirect:/dealers/view?id=" + timesheet.getDealer().getId();
		
    }
	
    @RequestMapping(value = "/dealer/delete", method = RequestMethod.DELETE)
    public String deleteDealerTimesheet(@RequestParam("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
    	Timesheet toDelete = timesheetService.find(id);
    	if (toDelete.getUserModify().getUsername().equals(username)) {
    		timesheetService.delete(toDelete);
    	}
        return "redirect:/dealers/view?id=" + toDelete.getDealer().getId();
    }
    
	@RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
    public String getDealerTimesheetById(@RequestParam("id") int id, Model model, HttpServletRequest request) {	
		Timesheet timesheet = timesheetService.find(id); 
		model.addAttribute("status", statusService.findAll());
		model.addAttribute("jobs", jobService.findAll()); 
		model.addAttribute("timesheet", timesheet);
        
		return "timesheets/view-dealer";
    }
	
	@RequestMapping(value = "/dealer/update", method = RequestMethod.POST)
    public String updateDealerTimesheet(@ModelAttribute("timesheet") Timesheet timesheet) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		try {			
			timesheet.setEffectiveDate(new Date());
			if (timesheet.getUserModify().getUsername().equals(username)) {
				timesheetService.update(timesheet);
			}
			else {
				timesheet.setId(0);
				timesheet.setUserModify(userService.get(username));
				timesheetService.save(timesheet);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/dealers/view?id=" + timesheet.getDealer().getId();
    }
	
	@RequestMapping(value = "/user/myjobs", method = {RequestMethod.GET, RequestMethod.POST})
    public String showMyJobs(Model model, HttpServletRequest request) {
		String timesheetYear = request.getParameter("timesheetYear");
    	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
  	
       
    	List<String> years = new ArrayList<String>();    	
    	if (timesheetYear == null) {
    		timesheetYear = String.valueOf(Integer.parseInt(DateTime.yyyy()) + 543);
    	}
    	years.add(String.valueOf(Integer.parseInt(timesheetYear) - 1));
    	 Date sinceDate = DateTime.stringtoDate("01/01/" + (String.valueOf(Integer.parseInt(timesheetYear) - 543)) + " 00:00:00", "dd/MM/yyyy HH:mm:ss");
    	List<Timesheet> timesheets = timesheetService.getLastUpdate(sinceDate);
    	if (timesheets != null) { 
        	Map <String, Organization> organizationMap = new HashMap<String, Organization>();
        	Map <String, Dealer> dealerMap = new HashMap<String, Dealer>();
        	Map <String, Integer> countMap = new HashMap<String, Integer>();
        	String __year = null;
			for (Timesheet timesheet: timesheets) {
				__year = String.valueOf(DateTime.formatDate(timesheet.getEffectiveDate(), "yyyy", new Locale("th", "TH")));
				
				if (!years.contains(__year)) {
					years.add(__year);
				}
				
				if (timesheet.getUserModify().getUsername().equals(username)) {
        			if (timesheet.getOrganization() != null) {
        				organizationMap.put(timesheet.getOrganization().getOrgId(), timesheet.getOrganization());
        				if (countMap.get(timesheet.getOrganization().getOrgId()) == null) {
        					countMap.put(timesheet.getOrganization().getOrgId(), 1);
        				}
        				else {
        					countMap.put(timesheet.getOrganization().getOrgId(), countMap.get(timesheet.getOrganization().getOrgId()) + 1);	
        				}
        			}  	
        			else {
        				dealerMap.put(timesheet.getDealer().getName(), timesheet.getDealer());
        				if (countMap.get(timesheet.getDealer().getName()) == null) {
        					countMap.put(timesheet.getDealer().getName(), 1);
        				}
        				else {
        					countMap.put(timesheet.getDealer().getName(), countMap.get(timesheet.getDealer().getName()) + 1);	
        				}
        			}	
				}
			}
			
			model.addAttribute("timesheetYear", timesheetYear);
			model.addAttribute("years", years);
        	model.addAttribute("organizations", organizationMap);
        	model.addAttribute("dealers", dealerMap);
        	model.addAttribute("countMap", countMap);
    	}
    	
        return "users/job";
        
    }
}
