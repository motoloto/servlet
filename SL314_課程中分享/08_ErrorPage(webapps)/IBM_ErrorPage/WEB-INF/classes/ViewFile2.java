
/*
 http://localhost:8081/IBM_ErrorPage/ViewFile2
*/

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.ServletUtils;

public class ViewFile2 extends HttpServlet {

public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();

    try {
        int i = 0;
        int j = 5 / i;
    } catch (ArithmeticException e) {
        log("算數錯誤", e);
        throw new ServletException("喂! 除到0 ! 算數錯誤", e);
    }

}
}
