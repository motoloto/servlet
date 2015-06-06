package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleCounter extends HttpServlet {

  int count = 0;

 /*1 synchronized */ public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

        count++;
       /*0 try {Thread.sleep(3000);} catch (InterruptedException e) {} */
        out.println("Since loading, this servlet has been accessed " + count + " times."); 
    
 /*2
     synchronized(this){
        count++;
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        out.println("Since loading, this servlet has been accessed " + count + " times.");
     }
 */ 

 /*3   
    int  local_count;
    synchronized(this){
        local_count= ++count;
    }   
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        out.println("Since loading, this servlet has been accessed " +  local_count + " times.");
*/    
 
 }
}
