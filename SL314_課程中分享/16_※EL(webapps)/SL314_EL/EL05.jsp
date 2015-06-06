<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<% 
pageContext.setAttribute("customer","peter1");
request.setAttribute("customer","peter2");
session.setAttribute("customer","peter3");
application.setAttribute("customer","peter4");
%>
<html>
<head><title>EL05</title></head>
<body>
customer=${customer}
</body>
</html>
