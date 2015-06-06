import java.sql.*;

class SQLServer2008_Basic1 {

    public static void main(String argv[]) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //Microsoft SQL Server 2008 - JDBC驅動程式-第四類
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

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