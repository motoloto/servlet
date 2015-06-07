package async1;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(value="/demo1", asyncSupported=true) //或 @WebServlet(urlPatterns="/demo1", asyncSupported=true)
public class AsyncDemoServlet extends HttpServlet {
  
    public void doGet(HttpServletRequest req, HttpServletResponse res)
                                          throws IOException, ServletException {
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("進 入 Servlet 的 時 間:" + new Date() + ".");
        out.flush();

        //在子執行緒中執行業務調用，並由其負責回應業務完成後的輸出
        AsyncContext ctx = req.startAsync();
        new Thread(new Executor(ctx)).start();
        
        //主執行緒退出
        out.println("<br>結 束 Servlet 的 時 間:" + new Date() + ".");
        out.flush();
    }
}