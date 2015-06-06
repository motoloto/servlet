import java.sql.*;
import java.io.*;
import javax.naming.Context;
import javax.sql.DataSource;

class PhotoWrite {


        public static void insertBLOB(File pic) {
              Connection con = null;
              PreparedStatement pstmt = null;
	        
              try {
               
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();
                
                long flen = pic.length();
                String fileName = pic.getName();
                int dotPos = fileName.indexOf('.');
                String fno = fileName.substring(0, dotPos);
                String format = fileName.substring(dotPos + 1);
                InputStream fin = new FileInputStream(pic);  

                System.out.println("\n\nUpdate the database... ");
                pstmt = con.prepareStatement(
                 "insert into EMP_PHOTO (empno, photo_format, picture)  values(?, ?, ?)");
                pstmt.setString(1, fno);
                pstmt.setString(2, format);
                pstmt.setBinaryStream(3, fin, (int)flen); //void pstmt.setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException
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