<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<% 
pageContext.setAttribute("customer","peter1");
request.setAttribute("customer","peter2");
session.setAttribute("customer","peter3");
application.setAttribute("customer","peter4");
%>
<html>
<head><title>EL06</title></head>
<body>
session.customer=${pageScope.customer}<br>
request.customer=${requestScope.customer}<br>
session.customer=${sessionScope.customer}<br>
application.customer=${applicationScope.customer}<br>
</body>
</html>
