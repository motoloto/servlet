
import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.naming.*;

public class PhotoWrite {

	public static void insertBLOB(String fileName, InputStream fin) {
	  Connection con = null;
		PreparedStatement pstmt = null;
	        
	  try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();
			
			int dotPos = fileName.indexOf('.');
			String fno = fileName.substring(0, dotPos);
			String format = fileName.substring(dotPos + 1);

			pstmt =	con.prepareStatement(
			  "insert into EMP_PHOTO (empno, photo_format, picture)  values(?, ?, ?)");
			pstmt.setString(1, fno);
			pstmt.setString(2, format);
			pstmt.setBinaryStream(3, fin);       //JDK6
			int rowsUpdated = pstmt.executeUpdate();
			
			System.out.print("Changed " + rowsUpdated);

			if (1 == rowsUpdated)
				System.out.println(" row.");
			else
				System.out.println(" rows.");
      fin.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}