<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>

<jsp:useBean id="customer" class="my.com.Customer" scope="session"/>
<jsp:setProperty name="customer" property="username" value="peter1"/>
<jsp:setProperty name="customer" property="addr" value="臺北陽明山"/>
<html>
<head><title>EL08</title></head>
<body>

<h3>Tomcat4 (Servlet 2.3/JSP 1.2)時的寫法</h3>
姓名：<jsp:getProperty name="customer" property="username"/><br>
地址：<jsp:getProperty name="customer" property="addr"/>

<h3>Tomcat5 (Servlet 2.4 /JSP 2.0)開始新增的寫法-1</h3>
姓名：${customer.username}<br>
地址：${customer.addr}

<h3>Tomcat5 (Servlet 2.4 /JSP 2.0)開始新增的寫法-2</h3>
姓名：${customer["username"]}<br>
地址：${customer["addr"]}
</body>
</html>
