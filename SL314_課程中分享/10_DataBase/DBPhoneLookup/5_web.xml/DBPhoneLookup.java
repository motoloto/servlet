package servlet_examples;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DBPhoneLookup extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {

	  ServletContext  context = getServletContext();
    String driver = context.getInitParameter("connection.driver");
    String url = context.getInitParameter("connection.url");
    String username = context.getInitParameter("user");
    String password = context.getInitParameter("password"); 
	                               
	  Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
/*
      stmt = con.createStatement();
      rs = stmt.executeQuery("select empno, ename from EMP2");
*/       
     
      // Display the result set as a list
      out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
      out.println("<BODY>");
      out.println("<UL>");
      
 out.println(new HtmlSQLResult("select empno, ename from EMP2" , con));
 
      out.println("</UL>");
      out.println("</BODY></HTML>");
    
    }
    catch(ClassNotFoundException e) {
      out.println("Couldn't load database driver: " + e.getMessage());
    }
    catch(SQLException e) {
      out.println("SQLException caught: " + e.getMessage());
    }
    finally {
      // Always close the database connection.
      try {
        if (con != null) con.close();
      }
      catch (SQLException ignored) { }
    }
  }
}
