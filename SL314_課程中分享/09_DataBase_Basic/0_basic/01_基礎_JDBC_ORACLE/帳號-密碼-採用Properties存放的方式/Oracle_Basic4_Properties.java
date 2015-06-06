import java.sql.*;
import java.util.*;
import java.io.*;

class Oracle_Basic4_Properties {

    public static void main(String argv[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //驅動程式-第四類
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("JDBC.properties"));
            Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2" , prop);
            

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from EMP2");

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

        } catch (Exception ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}