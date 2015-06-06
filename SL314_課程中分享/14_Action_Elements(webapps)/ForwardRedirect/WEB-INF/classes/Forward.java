
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Forward extends HttpServlet {


  public void doGet(HttpServletRequest req, HttpServletResponse res) 
          throws ServletException, IOException {
    
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    out.println("有執行 , 但看不到 , 因buffer被清掉");    
    req.setAttribute("option", "forward");
    
    RequestDispatcher dispatcher = req.getRequestDispatcher("/Goto");
    dispatcher.forward(req, res);
    out.println("未執行");    
  
  } 
}





