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
    
    out.println("<h4><font color=blue>Request Parameters �ШD�Ѽ�:</font></h4>");
		String values[] = req.getParameterValues("name");
			for (int i = 0; i < values.length; i++) {
					out.println("name" + " [" + i + "]: " + values[i]);
					out.println("<br>");
			}
    
    out.println("<br><br><br>");
    
    out.println("<h4><font color=red>Servlet3.0 Part���� �ɮפW��:</font></h4>");
    Part part1 = req.getPart("upfile1");
    printPart(part1, out);
    if(getFileNameFromPart(part1)!=null)	
	    part1.write(getFileNameFromPart(part1));
	  
	  Part part2 = req.getPart("upfile2");
    printPart(part2, out);
    if(getFileNameFromPart(part2)!=null)	
	    part2.write(getFileNameFromPart(part2));
    
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
	
	//���X�W�Ǫ��ɮצW�� (�]��API������method,�ҥH�����ۦ漶�g)
  public String getFileNameFromPart(Part part) { 
    String header = part.getHeader("content-disposition");
    String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
    int pos = header.indexOf("filename"); //�h���ШD�Ѽƪ�����
    if (filename.length() == 0 || pos == -1) { 
        return null; 
    } 
    return filename; 
  }
}
