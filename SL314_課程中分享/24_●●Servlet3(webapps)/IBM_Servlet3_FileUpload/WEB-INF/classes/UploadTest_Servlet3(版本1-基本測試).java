import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


@WebServlet("/uploadServlet3.do")
@MultipartConfig(location="c:/tmp2", fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
//如果使用web.xml設定，則可以用<multipart-config>來指定儲存位置，見web.xml

public class UploadTest_Servlet3 extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
                                	
    req.setCharacterEncoding("UTF-8"); // 處理中文檔名
    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		out.write("<h2> Total parts : "+parts.size()+"</h2>");
    
    int count =0;
		for(Part part : parts) {
			printPart(part, out);
			part.write("Testfile"+(++count)+".gif");
		}
  }
  
  //從Part物件取得上傳檔案的相關資料
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
			sb.append("【head測試】"+header + " : "+part.getHeader(header));
			sb.append("<br>");
		}
		sb.append("</p>");
		out.println(sb.toString()); 
	}

}
