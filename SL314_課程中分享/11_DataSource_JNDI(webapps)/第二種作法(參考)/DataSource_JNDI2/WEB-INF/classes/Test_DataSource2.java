/** 自行取得DataSource的 servlet
 
 1.需配合 web.xml 如下:
    <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>jdbc/TestDB2</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
    </resource-ref>
 
 2. 或加入 /META-INF/context.xml
    -參考: http://localhost:8080/index.jsp 首頁
             之 Tomcat Documentation 之 http://localhost:8081/docs/config/context.html 的說明
    -In an individual file at /META-INF/context.xml inside the application files
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class Test_DataSource2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/plain; charset=Big5");
		PrintWriter out = res.getWriter();

		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
			if (ds != null) {
				Connection conn = ds.getConnection();

				if (conn != null) {
					out.println("Got Connection: " + conn.toString());
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select * from emp2");
					while (rs.next()) {
						out.println("empNo = " + rs.getString(1));
					}
					conn.close();
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}