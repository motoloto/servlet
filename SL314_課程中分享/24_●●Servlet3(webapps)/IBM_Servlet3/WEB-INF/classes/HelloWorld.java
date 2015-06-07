
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet( name="hi2",
             urlPatterns= {"/hello2.html" , "/hello2.html/*" , "*.mm2"},
             loadOnStartup = 1,
             initParams = {
                  @WebInitParam(name="initial1" , value="1000"),
                  @WebInitParam(name="initial2" , value="2000")
             }
           )
public class HelloWorld extends HttpServlet {

	int count1;
	int count2;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<BIG>Hello World , 世界你好 【我是在WEB-INF/classes內的HelloWorld】!</BIG>");
		
		count1++;
		count2++;
		out.println(count1 + " times.");
		out.println(count2 + " times.");
		out.println("</BODY></HTML>");
	}
	
	public void init() throws ServletException {
		System.out.println("loadOnStartup -啟動時載入- Servlet3");
    String initial1 = getInitParameter("initial1");
    String initial2 = getInitParameter("initial2");
    try {
      count1 = Integer.parseInt(initial1);
      count2 = Integer.parseInt(initial2);
    }
    catch (NumberFormatException e) {
      count1 = 0;
      count2 = 0;
    }
  }
	
}
