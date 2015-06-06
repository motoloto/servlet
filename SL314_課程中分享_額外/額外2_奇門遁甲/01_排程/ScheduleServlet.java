import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

import java.util.*;

public class ScheduleServlet extends HttpServlet {
   
    
    Timer timer;
    int i=0;      
   
    public void init() throws ServletException {
      TimerTask task = new TimerTask(){ 
	        public void run() {
            System.out.println("i="+i);
            i++;	      
	        } 
      };
      timer = new Timer(); 
      Calendar cal = new GregorianCalendar(2011, Calendar.MARCH, 5, 0, 0, 0);
      timer.scheduleAtFixedRate(task, cal.getTime(), 1*60*60*1000);
      System.out.println("�w�إ߱Ƶ{!");       
    }
    

    public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    }                           	

    public void destroy() {
        timer.cancel();
        System.out.println("�w�����Ƶ{!");
    }
    
}