package com.arya;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploader
 */
public class FileUploader extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fileItems = sf.parseRequest(request);
			
			// location where files being uploaded (for windows os)
			String location = "C:/Users/Test/eclipse-workspaces/FileUploadDemo/";
			
			for(FileItem file: fileItems) {
				file.write(new File(location + file.getName()));
				System.out.println(file.getName() + " uploaded");
			}
			
			System.out.println("all files uploaded successfully");			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}














