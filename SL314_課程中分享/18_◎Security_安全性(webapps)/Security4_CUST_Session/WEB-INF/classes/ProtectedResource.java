
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProtectedResource extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    // �i���o session�j
    HttpSession session = req.getSession();

    // �i�q session �P�_��user�O�_�n�J�L�j
    Object account = session.getAttribute("account");          // �q session�����X(key) account����
    if (account == null) {                                     // �p�� null, �N��user���n�J�L , �~���H�U�u�@
      session.setAttribute("location", req.getRequestURI());   //*�u�@1 : ���K�O�U�ثe��m , �H�K��login.html�n�J���\�� , ��������ɦܦ�����(���t�XLoginHandler.java)
      res.sendRedirect(req.getContextPath()+"/login.html");    //*�u�@2 : �и�user�h�n�J����(login.html) , �i��n�J
      return;
    }

    // �n�J�L , �~�����즹�B!
    out.println("<font color=blue><b>�n�J�L , �~�����즹�B!<b></font>");
  }
}
