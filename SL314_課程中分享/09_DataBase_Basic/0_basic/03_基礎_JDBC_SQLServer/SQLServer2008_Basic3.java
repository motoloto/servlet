/*
 java -Djdbc.drivers=com.microsoft.sqlserver.jdbc.SQLServerDriver SQLServer2008_Basic3
*/


import java.sql.*;

class SQLServer2008_Basic3 {

    public static void main(String argv[]) {
        
        //System.setProperty("jdbc.drivers", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        try {
            Connection con =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=DB01", "sa", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from emp2");

            while (rs.next()) {
                String str1 = rs.getString(1);
                String str2 = rs.getString(2);

                System.out.print(" EMPNO= " + str1);
                System.out.print(" ENAME= " + str2);
                System.out.print("\n");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}