<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>

<jsp:useBean id="customer" class="my.com.Customer" scope="session"/>
<jsp:setProperty name="customer" property="username" value="peter1"/>
<jsp:setProperty name="customer" property="addr" value="�O�_�����s"/>
<html>
<head><title>EL08</title></head>
<body>

<h3>Tomcat4 (Servlet 2.3/JSP 1.2)�ɪ��g�k</h3>
�m�W�G<jsp:getProperty name="customer" property="username"/><br>
�a�}�G<jsp:getProperty name="customer" property="addr"/>

<h3>Tomcat5 (Servlet 2.4 /JSP 2.0)�}�l�s�W���g�k-1</h3>
�m�W�G${customer.username}<br>
�a�}�G${customer.addr}

<h3>Tomcat5 (Servlet 2.4 /JSP 2.0)�}�l�s�W���g�k-2</h3>
�m�W�G${customer["username"]}<br>
�a�}�G${customer["addr"]}
</body>
</html>
