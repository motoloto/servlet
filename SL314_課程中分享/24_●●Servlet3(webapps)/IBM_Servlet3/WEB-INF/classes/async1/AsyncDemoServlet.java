package async1;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(value="/demo1", asyncSupported=true) //�� @WebServlet(urlPatterns="/demo1", asyncSupported=true)
public class AsyncDemoServlet extends HttpServlet {
  
    public void doGet(HttpServletRequest req, HttpServletResponse res)
                                          throws IOException, ServletException {
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("�i �J Servlet �� �� ��:" + new Date() + ".");
        out.flush();

        //�b�l�����������~�ȽեΡA�åѨ�t�d�^���~�ȧ����᪺��X
        AsyncContext ctx = req.startAsync();
        new Thread(new Executor(ctx)).start();
        
        //�D������h�X
        out.println("<br>�� �� Servlet �� �� ��:" + new Date() + ".");
        out.flush();
    }
}