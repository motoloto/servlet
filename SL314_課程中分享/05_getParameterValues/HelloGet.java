
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloGet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
  	req.setCharacterEncoding("Big5");
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    String name = req.getParameter("name");
    String name2=new String(name.getBytes("ISO-8859-1"), "Big5");    
    out.println("<HTML>");
    out.println("<HEAD><TITLE>Hello, " + name2 + "</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("Hello,你好: " + name2);
    
    out.println("<br><img src=\""+req.getContextPath()+"/images/tomcat.gif\">");
    out.println("<br>");
    
   // 練習 checkbox
   String user_status[]=req.getParameterValues("user_status");
   String str="";
    if(user_status != null){
        for(int i=0 ; i<user_status.length ; i++)
         str += " " + user_status[i];
        
        out.println(new String(str.getBytes("ISO-8859-1"), "Big5"));
    } else
        out.println("未勾選"); 
    
    out.println("</BODY></HTML>");
  }
  public String getServletInfo() {
    return "A servlet that knows the name of the person to whom it's" + 
           "saying hello";
  }
}
