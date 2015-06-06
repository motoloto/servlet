<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_import.jsp</title>
</head>
<body>

<h2><c:out value="<c:import> ªº¥Îªk" /></h2>



<c:import url="http://localhost:8081/SL314_EL/Hello" charEncoding="Big5">
  <c:param name="name" value="peter1" />
</c:import><br>

<c:import url="http://tw.yahoo.com" charEncoding="UTF-8" />
<br>

<c:import url="http://java.sun.com/" />
<br>

</body>
</html>