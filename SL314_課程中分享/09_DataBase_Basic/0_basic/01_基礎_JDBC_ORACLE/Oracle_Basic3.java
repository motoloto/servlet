/*
 java -Djdbc.drivers=oracle.jdbc.driver.OracleDriver Oracle_Basic3
*/

import java.sql.*;

class Oracle_Basic3 {

    public static void main(String argv[]) {
        
        //System.setProperty("jdbc.drivers", "oracle.jdbc.driver.OracleDriver");
        
        try {
            Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "scott", "tiger");
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