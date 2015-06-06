/*
   測試:   http://localhost:8081/IBM_ErrorPage/ViewFile/images/tomcat.gif
   應注意  (※1)注意當有用到【額外路徑資訊】時必須使用【前置路徑對應】的設定
   同時注意(※2)web.xml內的<url-pattern>是<url-pattern>/ViewFile/*</url-pattern>                        
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


    //原始程式
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
    // 404找不到檔案
    try {
      ServletUtils.returnFile(file, out);
    }
    catch (FileNotFoundException e) {
      log("404找不到檔案:" + e.getMessage());
      res.sendError(res.SC_NOT_FOUND);   //Status code (404)
    }
    catch (IOException e) {
      log("500傳送檔案失敗" , e);
      res.sendError(res.SC_INTERNAL_SERVER_ERROR);  //Status code (500)
    }
*/


/*
    // 404找不到檔案
    try {
      ServletUtils.returnFile(file, out);
   }
    catch (FileNotFoundException e) {
      log("404找不到檔案:" + e.getMessage());
      res.sendError(res.SC_NOT_FOUND, "系統找不到指定的檔案");   //Status code (404)
    }
    catch (IOException e) {
      log("500傳送檔案失敗" , e);
      res.sendError(res.SC_INTERNAL_SERVER_ERROR , "500傳送檔案失敗");  //Status code (500)
    }
*/
    

  }
}
