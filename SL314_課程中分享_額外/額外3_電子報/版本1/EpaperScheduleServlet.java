import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import epaper.*;
import java.util.*;

public class EpaperScheduleServlet extends HttpServlet {
	epaper.EpaperPostURL getMail = new epaper.EpaperPostURL();
	epaper.SendMail sendMail = new epaper.SendMail();
	Timer timer;
	
	public void init() throws ServletException {
		TimerTask task = new TimerTask(){
			public void run() {
				try {
					getMail.EpaperTemp();
					sendMail.Send();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};

		timer = new Timer();
    Calendar cal = new GregorianCalendar(2009, Calendar.AUGUST, 12, 0, 0, 0);
    timer.scheduleAtFixedRate(task, cal.getTime(), 24*60*60*1000);
    	
    System.out.println("電子報 已建立排程!");
  }
    
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  }
    
  public void destroy() {
    	timer.cancel();
    	System.out.println("電子報 已移除排程!");
  }
}