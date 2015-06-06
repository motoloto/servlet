<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Core_if.jsp</title>
</head>
<body>

<h2><c:out value="<c:if> 的用法" /></h2>



<fmt:requestEncoding value="Big5" />  
<%//request.setCharacterEncoding("Big5");%>

<c:if test="${param.password == '123'}" var="condition" scope="page" > 
    ${param.user} 請領取您的<b>密碼禮物</b>！ 
</c:if> 
  
執行結果為:${condition}
</body>
</html>

<!--
http://localhost:8081/SL314_JSTL/Core_if.jsp?password=1234&user=peter1
-->