
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Goto extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res) 
          throws ServletException, IOException {
    
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();
    
    String option = (String) req.getAttribute("option");
    if (option != null) {
      if (option.equals("forward")) {
        out.println("你已被 forward 至此頁-我是Goto.java !");
      } else if (option.equals("include")) {
        out.println("--此行 (屬Goto.java) 被 included 在原網頁的輸出中 --");
      } 
    } 
  } 
}






