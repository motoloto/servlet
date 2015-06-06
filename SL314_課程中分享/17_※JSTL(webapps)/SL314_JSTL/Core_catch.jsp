<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_catch.jsp</title>
</head>
<body>

<h2><c:out value="<c:catch> ªº¥Îªk" /></h2>

<c:catch var="error_Message">
<%
	String eFormat = "not number";	
	int i = Integer.parseInt(eFormat);
%>
</c:catch>

${error_Message}
<br>
<c:out value="¿ù»~-${error_Message}"/>

</body>
</html>