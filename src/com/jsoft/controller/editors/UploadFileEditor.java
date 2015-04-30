/**
 * 
 */
package com.jsoft.controller.editors;

import java.beans.PropertyEditorSupport;

import com.jsoft.service.UploadFileService;

/**
 * @author Sirimongkol
 *
 */
public class UploadFileEditor extends PropertyEditorSupport {
	
	private UploadFileService uploadFileService;

	public UploadFileEditor(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(uploadFileService.find(Integer.parseInt(text)));
	}
	
	
}
