/**
 * 
 */
package com.jsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsoft.model.PettyCash;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/petty-cash")
public class PettyCashController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String getPettyCashPage(Model model) {	
        return "cash/main";
    }
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
    public String createPettyCash(Model model) {
		model.addAttribute("pettyCash", new PettyCash());
        return "cash/new";
    }
	
}
