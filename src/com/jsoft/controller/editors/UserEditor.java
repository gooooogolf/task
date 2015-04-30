/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.UserService;

/**
 * @author Sirimongkol
 *
 */
public class UserEditor extends PropertyEditorSupport {
	
	private UserService userService;

	public UserEditor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(userService.get(text));
	}
	
	
}
