package servlet_examples;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.Context;
import javax.sql.DataSource;

public class DBGifReader3 extends HttpServlet {

	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			                         throws ServletException, IOException {
		
		req.setCharacterEncoding("Big5");
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		try {

			Statement stmt = con.createStatement();
			String empno  = req.getParameter("empno");
			String empno2 = new String(empno.getBytes("ISO-8859-1"), "Big5");
			ResultSet rs = stmt.executeQuery(
			    "select picture from EMP_PHOTO where empno = '"+empno2+"'");

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
		} catch (Exception e) {
			  System.out.println(e);
		}
	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();
		} catch (Exception e) {
			  System.out.println(e.getMessage());
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
