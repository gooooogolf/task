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

import com.jsoft.model.Status;
import com.jsoft.service.StatusService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {	
		List<Status> status = statusService.findAll();
		model.addAttribute("status", status);
        return "status/list";
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("id") int id, Model model) {	
		Status status = statusService.find(id);
		model.addAttribute("status", status);
        return "status/view";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {	
		model.addAttribute("status", new Status());
        return "status/new";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Status status) {	
		statusService.saveOrUpdate(status);			
		return "redirect:/status";	
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("status") Status status) {	
		statusService.update(status);			
		return "redirect:/status";	
    }
	
}
