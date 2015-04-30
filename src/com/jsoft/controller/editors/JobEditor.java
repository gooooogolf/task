/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.JobService;

/**
 * @author Sirimongkol
 *
 */
public class JobEditor extends PropertyEditorSupport {
	
	private JobService jobService;

	public JobEditor(JobService jobService) {
		this.jobService = jobService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(jobService.find(Integer.parseInt(text)));
	}
	
	
}
