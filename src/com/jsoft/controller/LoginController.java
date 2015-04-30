/**
 * 
 */
package com.jsoft.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jsoft.service.UserService;

/**
 * @author Sirimongkol
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		 return "login";
	}
	
	@RequestMapping(value="/login-error", method=RequestMethod.GET)
	public String invalidLogin(Model model) {
		model.addAttribute("error", true);
		return "login";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String accessdenied(Principal user, Model model) {
		
		if (user != null) {
			model.addAttribute("msg", "ขออภัย...คุณ" + userService.get(user.getName()).getDescription() 
			+ ", คุณไม่ได้รับสิทธิ์เข้าใช้งานหน้านี้!");
		} else {
			model.addAttribute("msg", "คุณไม่ได้รับสิทธิ์เข้าใช้งานหน้านี้!");
		}
		
		return "403";
	}
	
	@RequestMapping(value="/login-success", method=RequestMethod.GET)
	public String successLogin(HttpServletRequest request) {
//		 String username = request.getUserPrincipal().getName();
//		 User user = userService.get(username);
//		 request.getSession().setAttribute("username", user.getDescription());
		 return "redirect:/index";
	}
}
