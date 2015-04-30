package com.jsoft.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author 006223
 *
 */
public class FileUtils {
	public static boolean copyFileUsingFileStreams(URL url, File dest) throws IOException{
		InputStream input = null;
		OutputStream output = null;
		try{
			input = new BufferedInputStream(url.openStream());
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if(input!=null){
				input.close();
				output.close();
			}
		}
	}
	
	public static boolean copyFile(File src, File dest) throws IOException{
		InputStream input = null;
		OutputStream output = null;
		try{
			input = new FileInputStream(src);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if(input!=null){
				input.close();
				output.close();
			}
		}
	}
}


