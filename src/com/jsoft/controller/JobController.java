/**
 * 
 */
package com.jsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.model.Job;
import com.jsoft.service.JobService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/job","/jobs"})
public class JobController {

	@Autowired
	private JobService jobService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {	
		List<Job> jobs = jobService.findAll();
		model.addAttribute("jobs", jobs);
        return "jobs/list";
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("id") int id, Model model) {	
		Job job = jobService.find(id);
		model.addAttribute("job", job);
        return "jobs/view";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {	
		model.addAttribute("job", new Job());
        return "jobs/new";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Job job) {	
		jobService.saveOrUpdate(job);			
		return "redirect:/jobs";	
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("job") Job job) {	
		jobService.update(job);			
		return "redirect:/jobs";	
    }
	
}
