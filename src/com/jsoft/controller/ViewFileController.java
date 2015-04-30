/**
 * 
 */
package com.jsoft.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsoft.model.UploadFile;
import com.jsoft.service.UploadFileService;
import com.jsoft.util.FileUtils;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping("/view")
public class ViewFileController {
	
	private static Logger logger = Logger.getLogger(ViewFileController.class);
	
	@Autowired
	private UploadFileService uploadFileService;
	
    @RequestMapping(value = "/upload/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void view(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException { 
    	UploadFile uploadFile = uploadFileService.find(id);
    	if(uploadFile != null) {
			ServletContext servletContext = request.getSession().getServletContext();
			String srcFolder = "D://DATA/UPLOADFILE";
			String desFolder = servletContext.getRealPath("/resources/temp"); 
			File desFile = null , srcFile = null;
			String fileName = uploadFile.getUrl().split("/")[uploadFile.getUrl().split("/").length-1];
			desFile = new File(desFolder + "/" + fileName);
			if(!desFile.isFile()) {
				srcFile = new File(srcFolder + "/" + uploadFile.getUrl());
				try{
					FileUtils.copyFile(srcFile, desFile);
				}catch(Exception e){
					logger.warn(e);
				}
			}	
			response.sendRedirect(request.getContextPath() + "/resources/temp/" + fileName);
    	}
    }
    
}
