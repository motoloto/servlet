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
  
  String saveDirectory = "images_uploaded"; // �W���ɮת��ئa�ؿ�
  
  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
                                	
    req.setCharacterEncoding("UTF-8"); // �B�z�����ɦW
    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    File fsaveDirectory = new File(getServletContext().getRealPath(saveDirectory));
		if (!fsaveDirectory.exists()) fsaveDirectory.mkdirs(); // ��ContextPath���U,�۰ʫإߥئa�ؿ�
    
    Collection<Part> parts = req.getParts(); // Servlet3.0�s�W�FPart�����A���ڭ̤�K���i���ɮפW�ǳB�z
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
      
          // �Q��File����,�g�J�ئa�ؿ�,�W�Ǧ��\
          part.write(f.toString());
          
          // �B�~���� InputStream
			    InputStream fin = part.getInputStream();
          out.println("InputStream: " + fin);
          fin.close();
      
          out.println();
          out.println("</PRE>");
		   }
		}
  }
  
  //���X�W�Ǫ��ɮצW�� (�]��API������method,�ҥH�����ۦ漶�g)
  public String getFileNameFromPart(Part part) { 
    String header = part.getHeader("content-disposition"); //�q�e���Ĥ@�ӽd��(����1-�򥻴���)�i�o����head����
    String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
    if (filename.length() == 0) { 
        return null; 
    } 
    return filename; 
  }
}
