
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class IPForbiddenServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{
		res.setContentType("text/html;charset=big5");
		PrintWriter out=res.getWriter();
		out.println("<html><head><title>Forbidden</title></head><body>");
		out.println("您的連線位置被拒。");
		out.println("</body></html>");
		out.close();
    }
}

