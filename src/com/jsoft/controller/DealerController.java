/**
 * 
 */
package com.jsoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.model.Dealer;
import com.jsoft.model.Timesheet;
import com.jsoft.service.DealerService;
import com.jsoft.service.TimesheetService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/dealers")
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
	@Autowired
	private TimesheetService timesheetService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String getDealersPage(@RequestParam(required = false) String id, Model model) {
		List<Dealer> dealers = null;
		if(id != null) {	
			dealers = new ArrayList<Dealer>();
			dealers.add(dealerService.find(Integer.parseInt(id)));
		}
		else {	
			dealers = dealerService.getDealerByTermLimit("", 5);
		}
		model.addAttribute("dealers", dealers);
        return "dealers/list";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String showDealers(@RequestParam("term") String term, Model model) {
		List<Dealer> dealers = dealerService.getDealerByTerm(term);
		model.addAttribute("dealers", dealers);
        return "dealers/list";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {	
		model.addAttribute("dealer", new Dealer());
        return "dealers/new";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Dealer dealer) {	
//		System.out.println("controller is " + dealer);
		dealerService.saveOrUpdate(dealer);		
		return "redirect:/dealers";	
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("dealer") Dealer dealer) {	
		dealerService.update(dealer);			
		return "redirect:/dealers?id=" + dealer.getId();	
    }
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {	
		Dealer dealer = dealerService.find(id);
		model.addAttribute("dealer", dealer);
        return "dealers/edit";
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("id") int id, Model model) {	
		Dealer dealer = dealerService.find(id);
		List<Timesheet> timesheets = timesheetService.getTimesheetByDealerId(String.valueOf(dealer.getId()));
		model.addAttribute("dealer", dealer);
		model.addAttribute("timesheets", timesheets);
        return "dealers/view";
    }
	
}
