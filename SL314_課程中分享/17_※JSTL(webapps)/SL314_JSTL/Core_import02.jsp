<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_import.jsp</title>
</head>
<body>

<h2><c:out value="<c:import> ªº¥Îªk" /></h2>




<c:import url="http://tw.yahoo.com" charEncoding="utf-8"  var="file" scope="page" />
  <c:out value="${file}" />
</body>
</html>