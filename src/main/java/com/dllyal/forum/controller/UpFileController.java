package com.dllyal.forum.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "up/")
public class UpFileController {
	
	@RequestMapping("up.do")
	public void up(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("****************************");
		String dayname = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String savePath = request.getSession().getServletContext().getRealPath("/upload/"+dayname+"/");
		// 上传时生成的文件保存目录
		if(!new File(savePath).exists()){
		    new File(savePath).mkdirs();
		}
		String xiangdui = "";
		ArrayList<String> datas = new ArrayList<String>();
		//String tempPath = request.getSession().getServletContext().getRealPath("/temp/");
		System.out.println(savePath);
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setProgressListener(new ProgressListener(){
            public void update(long pBytesRead, long pContentLength, int arg2) {
            	String msg="文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead;
                System.out.println(msg);
            }
        });
        try {  
            @SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request); 
            System.out.println(list.size());
            for(FileItem item : list){  
                if(item.isFormField()){             
                }else{  
                	String fileName = item.getName();       	
                	// 文件名使用当前时间  
                    String timename = new SimpleDateFormat("HHmmssSSS").format(new Date());            
                    // 获取上传图片的扩展名(jpg/png/...)  
                    String extension = FilenameUtils.getExtension(fileName).toLowerCase();          
                    String finlfilename = timename + "." + extension;           
                	InputStream in = item.getInputStream();  
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
                    xiangdui = "upload/"+dayname+"/"+finlfilename;//服務器相對位置
                    datas.add(xiangdui);
                    System.out.println(xiangdui);
                    String outfileName = savePath + finlfilename;//文件最终上传的位置  
                    System.out.println(outfileName);  
                    OutputStream out = new FileOutputStream(outfileName);  
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }  
                    out.close();  
                    in.close(); 
                }  
            }  
        	// 将相对路径写回（json格式）  
            JSONObject jsonObject = new JSONObject();
            ObjectMapper mapper = new ObjectMapper();

            // 将图片上传到本地  
            jsonObject.put("success", "true");  
            jsonObject.put("msg", "ok"); 
            jsonObject.put("file_path", datas); 
            // 设置响应数据的类型json  
            response.setContentType("application/json; charset=utf-8");  
            // 写回  
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {  
            //e.printStackTrace();  
        	// 将相对路径写回（json格式）  
            JSONObject jsonObject = new JSONObject();  
            // 将图片上传到本地  
            jsonObject.put("success", "false");  
            jsonObject.put("msg", "false"); 
            jsonObject.put("file_path", datas);
            // 设置响应数据的类型json  
            response.setContentType("application/json; charset=utf-8");  
            // 写回  
            try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
        }  
		
    }
	
	@RequestMapping("profile.do")
	public void Profile(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("****************************");
		String dayname = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String savePath = request.getSession().getServletContext().getRealPath("/uploadProfile/"+dayname+"/");
		// 上传时生成的文件保存目录
		if(!new File(savePath).exists()){
		    new File(savePath).mkdirs();
		}
		String xiangdui = "";
		ArrayList<String> datas = new ArrayList<String>();
		//String tempPath = request.getSession().getServletContext().getRealPath("/temp/");
		System.out.println(savePath);
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setProgressListener(new ProgressListener(){
            public void update(long pBytesRead, long pContentLength, int arg2) {
            	String msg="文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead;
                System.out.println(msg);
            }
        });
        try {  
            @SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request); 
            System.out.println(list.size());
            
            for(FileItem item : list){  
                if(item.isFormField()){  
                      
                }else{  
                	String fileName = item.getName();
                	
                	// 文件名使用当前时间  
                    String timename = new SimpleDateFormat("HHmmssSSS").format(new Date());  
                  
                    // 获取上传图片的扩展名(jpg/png/...)  
                    String extension = FilenameUtils.getExtension(fileName).toLowerCase();
                    
                    String finlfilename = timename + "." + extension;
                    
                	InputStream in = item.getInputStream();  
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
                    
                    xiangdui = "uploadProfile/"+dayname+"/"+finlfilename;//服務器相對位置
                    datas.add(xiangdui);
                    System.out.println(xiangdui);
                    
                    String outfileName = savePath + finlfilename;//文件最终上传的位置  
                    System.out.println(outfileName);  
                    OutputStream out = new FileOutputStream(outfileName);  
  
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }  

                    out.close();  
                    in.close(); 
                }  
            }  
        	// 将相对路径写回（json格式）  
            JSONObject jsonObject = new JSONObject();  
            // 将图片上传到本地  
            jsonObject.put("success", "true");  
            jsonObject.put("msg", "ok"); 
            jsonObject.put("file_path", datas); 
            // 设置响应数据的类型json  
            response.setContentType("application/json; charset=utf-8");  
            // 写回  
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {  
            //e.printStackTrace();  
        	// 将相对路径写回（json格式）  
            JSONObject jsonObject = new JSONObject();  
            // 将图片上传到本地  
            jsonObject.put("success", "false");  
            jsonObject.put("msg", "false"); 
            jsonObject.put("file_path", datas);
            // 设置响应数据的类型json  
            response.setContentType("application/json; charset=utf-8");  
            // 写回  
            try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
        }  
		
    }

}
