
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet( name="Hello",
             urlPatterns= {"/hello.do"}
           )
public class Hello extends HttpServlet {

  int count;
  
  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
   	req.setCharacterEncoding("UTF-8");
    res.setContentType("text/html; charset=UTF-8");
    PrintWriter out = res.getWriter();

    String name = req.getParameter("name");
    String name2=new String(name.getBytes("ISO-8859-1"), "UTF-8");  
    out.println("<HTML>");
    out.println("<HEAD><TITLE>Hello, " + name2 + "</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("Hello, §A¦n: " + name2);
    
    out.println("<br><img src=\""+req.getContextPath()+"/images/tomcat.gif\">");
    
    count++;
    out.println("<font color=red><b>");
		out.println(count + " times.");
		out.println("</font></b>");
    out.println("</BODY></HTML>");
  }

  public void init() throws ServletException {
    String initial = getInitParameter("initial");
    try {
      count = Integer.parseInt(initial);
    }
    catch (NumberFormatException e) {
      count = 0;
    }
  }
}
