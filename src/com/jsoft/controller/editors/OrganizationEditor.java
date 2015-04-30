/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.OrganizationService;

/**
 * @author Sirimongkol
 *
 */
public class OrganizationEditor extends PropertyEditorSupport {
	
	private OrganizationService organizationService;

	public OrganizationEditor(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(organizationService.getOrganizationByOrgId(text));
	}
	
	
}
