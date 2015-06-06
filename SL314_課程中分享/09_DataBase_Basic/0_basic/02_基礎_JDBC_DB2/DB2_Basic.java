import java.sql.*;

class DB2_Basic {

    public static void main(String argv[]) {
        try {
            Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");    //�X�ʵ{��-�ĤG��
            Class.forName("COM.ibm.db2.jdbc.net.DB2Driver");    //�X�ʵ{��-�ĤT�� -- ���Ʈw���q���W�ݰ��� [db2jstrt.exe portNumber] , �p db2jstrt.exe 8888
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //�� �]�w-����x-�t�κ޲z�u��-��ƨӷ�(ODBC)
            //-> ��ܨt�θ�ƨӷ��W��->�s�W->��IBM DB2 ODBC DRIVER->���� [��ƨӷ��W��\��J:SAMPLE ; ��ƧO�W\���:SAMPLE ; �T�w] -> �T�w
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