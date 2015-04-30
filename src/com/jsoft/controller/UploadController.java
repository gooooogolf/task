package com.jsoft.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jsoft.model.UploadFile;
import com.jsoft.service.UploadFileService;
import com.jsoft.util.DateTime;

@Controller
@RequestMapping("/upload")
public class UploadController {

	private static Logger logger = Logger.getLogger(UploadController.class);
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@RequestMapping(value="/file", method=RequestMethod.POST)
	public @ResponseBody List<UploadFile> upload(
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//		ServletContext servletContext = request.getSession().getServletContext();
//		String uploadTempFolder = servletContext.getRealPath("/resources/temp"); 
		String uploadFolder = "D://DATA/UPLOADFILE";
		String filename = null;
		try{
			if (file.getSize() > 0) { 
				filename = DateTime.dateNow().replaceAll("-", "")
						+ DateTime.timeNow().replaceAll(":", "")
						+ (FilenameUtils.getExtension(file.getOriginalFilename()) == "" ? "" : ("." + FilenameUtils.getExtension(file.getOriginalFilename())));
				File upLoadedfile = new File(uploadFolder + "/" + DateTime.yyyy() + "/" + DateTime.mm() + "/" + DateTime.dd());
				if(!upLoadedfile.exists()) {
					upLoadedfile.mkdirs();
				}
				upLoadedfile = new File(upLoadedfile + "/" + filename);
				upLoadedfile.createNewFile(); 
				FileOutputStream fos = new FileOutputStream(upLoadedfile); 
				fos.write(file.getBytes());
				fos.close(); //setting the value of fileUploaded variable
				logger.debug("Writing file to disk...done on " + upLoadedfile);	
				
				List<UploadFile> uploadedFiles = new ArrayList<UploadFile>();
				UploadFile u = new UploadFile(0, 
						file.getOriginalFilename(),
						Long.valueOf(file.getSize()).intValue(),
						DateTime.yyyy() + "/" + DateTime.mm() + "/" + DateTime.dd() + "/" + filename);
				int id = uploadFileService.add(u);
				u.setId(id);
				uploadedFiles.add(u);
				return uploadedFiles;
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		return null;

	}
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUploadFile(@PathVariable("id") int id) { 
    	uploadFileService.delete(uploadFileService.find(id));
        return "ok";
    }
	
}
