import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


@WebServlet("/uploadServlet3.do")
@MultipartConfig(location="c:/tmp2", fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
//�p�G�ϥ�web.xml�]�w�A�h�i�H��<multipart-config>�ӫ��w�x�s��m�A��web.xml

public class UploadTest_Servlet3 extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
                                	
    req.setCharacterEncoding("UTF-8"); // �B�z�����ɦW
    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    Collection<Part> parts = req.getParts(); // Servlet3.0�s�W�FPart�����A���ڭ̤�K���i���ɮפW�ǳB�z
		out.write("<h2> Total parts : "+parts.size()+"</h2>");
    
    int count =0;
		for(Part part : parts) {
			printPart(part, out);
			part.write("Testfile"+(++count)+".gif");
		}
  }
  
  //�qPart������o�W���ɮת��������
  private void printPart(Part part, PrintWriter out) {
		StringBuffer sb = new StringBuffer();
		sb.append("<p>");
		sb.append("Name : "+part.getName());
		sb.append("<br>");
		sb.append("Content Type : "+part.getContentType());
		sb.append("<br>");
		sb.append("Size : "+part.getSize());
		sb.append("<br>");
		for(String header : part.getHeaderNames()) {
			sb.append("�ihead���աj"+header + " : "+part.getHeader(header));
			sb.append("<br>");
		}
		sb.append("</p>");
		out.println(sb.toString()); 
	}

}
