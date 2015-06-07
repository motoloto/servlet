import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


@WebServlet("/uploadServlet3.do")
@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)

public class UploadTest_Servlet3 extends HttpServlet {
  
  String saveDirectory = "images_uploaded"; // 上傳檔案的目地目錄
  
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
                                	
    req.setCharacterEncoding("UTF-8"); // 處理中文檔名
    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    File fsaveDirectory = new File(getServletContext().getRealPath(saveDirectory));
		if (!fsaveDirectory.exists()) fsaveDirectory.mkdirs(); // 於ContextPath之下,自動建立目地目錄
    
    Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		out.write("<h2> Total parts : "+parts.size()+"</h2>");
 
		for(Part part : parts) {
		   if(getFileNameFromPart(part)!=null){	
			    out.println("<PRE>");
			    String name = part.getName();
			    String filename = getFileNameFromPart(part);
			    String ContentType = part.getContentType();
			    long size = part.getSize();			    
			    File f = new File(fsaveDirectory,filename);
			
			    out.println("name: " + name);
			    out.println("filename: " + filename);
			    out.println("ContentType: " + ContentType);
			    out.println("size: " + size);            
          out.println("File: " + f);
      
          // 利用File物件,寫入目地目錄,上傳成功
          part.write(f.toString());
          
          // 額外測試 InputStream
			    InputStream fin = part.getInputStream();
          out.println("InputStream: " + fin);
          fin.close();
      
          out.println();
          out.println("</PRE>");
		   }
		}
  }
  
  //取出上傳的檔案名稱 (因為API未提供method,所以必須自行撰寫)
  public String getFileNameFromPart(Part part) { 
    String header = part.getHeader("content-disposition"); //從前面第一個範例(版本1-基本測試)可得知此head的值
    String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
    if (filename.length() == 0) { 
        return null; 
    } 
    return filename; 
  }
}
