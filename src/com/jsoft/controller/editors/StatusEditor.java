/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.StatusService;

/**
 * @author Sirimongkol
 *
 */
public class StatusEditor extends PropertyEditorSupport {
	
	private StatusService statusService;

	public StatusEditor(StatusService statusService) {
		this.statusService = statusService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(statusService.find(Integer.parseInt(text)));
	}
	
	
}
