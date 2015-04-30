/**
 * 
 */
package com.jsoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.model.User;
import com.jsoft.service.UserService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/user","/users"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getUsers(Model model) {	
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
        return "users/list";
    }
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getUser(@RequestParam("name") String username, Model model) {	
		User user = userService.get(username);
		model.addAttribute("user", user);
        return "users/view";
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getUserByAdmin(@RequestParam("name") String username, Model model) {	
		User user = userService.get(username);
		model.addAttribute("user", user);
        return "users/view-admin";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createUserForm(Model model) {	
		model.addAttribute("user", new User());
        return "users/new";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user) {	
		user.setUsername(user.getUsername().toUpperCase());
		userService.saveOrUpdate(user);			
		return "redirect:/users";	
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {	
		userService.update(user);			
		return "redirect:/";	
    }
	
	@RequestMapping(value = "/update-admin", method = RequestMethod.POST)
    public String updateUserByAdmin(@ModelAttribute("user") User user) {
		userService.update(user);			
		return "redirect:/";	
    }
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.POST)
    public void setUserSession(@PathVariable("name") String username, HttpServletRequest request) {	
		User user = userService.get(username);
		request.getSession().setAttribute("username", user.getDescription());
    }
}
