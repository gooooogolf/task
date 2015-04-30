/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.DealerService;

/**
 * @author Sirimongkol
 *
 */
public class DealerEditor extends PropertyEditorSupport {
	
	private DealerService dealerService;

	public DealerEditor(DealerService dealerService) {
		this.dealerService = dealerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(dealerService.find(Integer.parseInt(text)));
	}
	
	
}
