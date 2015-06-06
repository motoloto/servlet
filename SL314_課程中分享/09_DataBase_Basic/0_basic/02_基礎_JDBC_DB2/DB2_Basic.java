import java.sql.*;

class DB2_Basic {

    public static void main(String argv[]) {
        try {
            Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");    //驅動程式-第二類
            Class.forName("COM.ibm.db2.jdbc.net.DB2Driver");    //驅動程式-第三類 -- 放資料庫的電腦上需執行 [db2jstrt.exe portNumber] , 如 db2jstrt.exe 8888
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //至 設定-控制台-系統管理工具-資料來源(ODBC)
            //-> 選擇系統資料來源名稱->新增->選IBM DB2 ODBC DRIVER->完成 [資料來源名稱\輸入:SAMPLE ; 資料別名\選擇:SAMPLE ; 確定] -> 確定
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            Connection con =  DriverManager.getConnection("jdbc:db2:sample", "administrator", "678");
            //Connection con =  DriverManager.getConnection("jdbc:db2://kd108kd:8888/sample", "administrator", "678");  	  	
            //Connection con =  DriverManager.getConnection("jdbc:odbc:sample", "administrator", "678");  	  	   	

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from employee");

            while (rs.next()) {
                String str1 = rs.getString(1);
                String str2 = rs.getString(2);

                System.out.print(" empno= " + str1);
                System.out.print(" firstname= " + str2);
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