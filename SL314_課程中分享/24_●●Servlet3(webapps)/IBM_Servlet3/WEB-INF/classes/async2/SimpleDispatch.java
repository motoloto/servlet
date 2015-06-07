package async2;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/demo2", asyncSupported = true)
public class SimpleDispatch extends HttpServlet {
	
	int count = 0;
	
	public void doGet(final HttpServletRequest req,final HttpServletResponse res) 
	                                                        throws ServletException,IOException {
		
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("請求Servlet第"+(++count)+"次("+ new Date()+")<br>");
		out.flush();
		final AsyncContext actx = req.startAsync();
		
		if (req.getAttribute("dispatch")==null) {
		  
			actx.setTimeout(Long.MAX_VALUE);
			
			Runnable run = new Runnable() {
				public void run() {
					try {
						req.setAttribute("dispatch", new Date());
						Thread.currentThread().setName("Simple-Thread");
						Thread.sleep(5*1000);
						actx.dispatch();
					} catch (Exception x) {
					  System.out.println("x="+x);
					}
				}
			};
			
			Thread t = new Thread(run);
			t.start();
		
	  } else {
			out.println(
					"<br>Servlet-剛被請求時-的時間:" + req.getAttribute("dispatch")
				   +"<br>Servlet-完成請求時-的時間:"	+ new Date());
			out.flush();
			actx.complete();
		}
		
	}
}