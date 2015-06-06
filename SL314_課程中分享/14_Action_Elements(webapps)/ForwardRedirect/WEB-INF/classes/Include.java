
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Include extends HttpServlet {

  String forwardingAddress = "Goto";

  public void doGet(HttpServletRequest req, HttpServletResponse res) 
          throws ServletException, IOException {
    
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();
    
    req.setAttribute("option", "include");
    
    RequestDispatcher dispatcher = req.getRequestDispatcher("/Goto");
    dispatcher.include(req, res);
    
    out.println("此行在原網頁, 我有被執行到");
  } 
}





