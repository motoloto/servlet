package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SalaryServer extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/plain; charset=Big5");
    PrintWriter out = res.getWriter();

    out.println("�̰����K:");
    out.println("�A���~���O�����q�̰���!");
  }
}
