/*
   ����:   http://localhost:8081/IBM_ErrorPage/ViewFile/images/tomcat.gif
   ���`�N  (��1)�`�N���Ψ�i�B�~���|��T�j�ɥ����ϥΡi�e�m���|�����j���]�w
   �P�ɪ`�N(��2)web.xml����<url-pattern>�O<url-pattern>/ViewFile/*</url-pattern>                        
*/

//package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.ServletUtils;

public class ViewFile extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    ServletOutputStream out = res.getOutputStream();

    String file = req.getPathTranslated();
    if (file == null) {
      out.println("No file to view");
      return;
    }
    String contentType = getServletContext().getMimeType(file);
    res.setContentType(contentType);


    //��l�{��
    try {
      ServletUtils.returnFile(file, out);
    }
    catch (FileNotFoundException e) {
      out.println("File not found");
    }
    catch (IOException e) {
      out.println("Problem sending file: " + e.getMessage());
    }
    

/*
    // 404�䤣���ɮ�
    try {
      ServletUtils.returnFile(file, out);
    }
    catch (FileNotFoundException e) {
      log("404�䤣���ɮ�:" + e.getMessage());
      res.sendError(res.SC_NOT_FOUND);   //Status code (404)
    }
    catch (IOException e) {
      log("500�ǰe�ɮץ���" , e);
      res.sendError(res.SC_INTERNAL_SERVER_ERROR);  //Status code (500)
    }
*/


/*
    // 404�䤣���ɮ�
    try {
      ServletUtils.returnFile(file, out);
   }
    catch (FileNotFoundException e) {
      log("404�䤣���ɮ�:" + e.getMessage());
      res.sendError(res.SC_NOT_FOUND, "�t�Χ䤣����w���ɮ�");   //Status code (404)
    }
    catch (IOException e) {
      log("500�ǰe�ɮץ���" , e);
      res.sendError(res.SC_INTERNAL_SERVER_ERROR , "500�ǰe�ɮץ���");  //Status code (500)
    }
*/
    

  }
}
