package servlet_examples;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DBGifReader extends HttpServlet {

  Connection con;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    
    res.setContentType("image/gif");
    ServletOutputStream out = res.getOutputStream();
    
    try {

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
    		  "select picture from EMP_PHOTO where empno = 'º}«G¶Ü'");

      if (rs.next()) {
        BufferedInputStream in =
          new BufferedInputStream(rs.getBinaryStream("picture"));
        byte[] buf = new byte[4 * 1024];  // 4K buffer
        int len;
        while ((len = in.read(buf)) != -1) {
          out.write(buf, 0, len);
        }
        in.close();
      } else {
          res.sendError(HttpServletResponse.SC_NOT_FOUND);
      }
      rs.close();
      stmt.close(); 
    } catch(Exception e) {
        System.out.println(e);
    }
  }
  
  public void init() throws ServletException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "scott", "tiger");
    }
    catch (ClassNotFoundException e) {
      throw new UnavailableException("Couldn't load JdbcOdbcDriver");
    }
    catch (SQLException e) {
      throw new UnavailableException("Couldn't get db connection");
    }
  }
  
  public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			  System.out.println(e);
		}
	}

}
