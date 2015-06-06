
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProtectedResource extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    // 【取得 session】
    HttpSession session = req.getSession();

    // 【從 session 判斷此user是否登入過】
    Object account = session.getAttribute("account");          // 從 session內取出(key) account的值
    if (account == null) {                                     // 如為 null, 代表此user未登入過 , 才做以下工作
      session.setAttribute("location", req.getRequestURI());   //*工作1 : 順便記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁(須配合LoginHandler.java)
      res.sendRedirect(req.getContextPath()+"/login.html");    //*工作2 : 請該user去登入網頁(login.html) , 進行登入
      return;
    }

    // 登入過 , 才能執行到此處!
    out.println("<font color=blue><b>登入過 , 才能執行到此處!<b></font>");
  }
}
