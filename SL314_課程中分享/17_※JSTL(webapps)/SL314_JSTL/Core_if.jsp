<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>Core_if.jsp</title>
</head>
<body>

<h2><c:out value="<c:if> ���Ϊk" /></h2>



<fmt:requestEncoding value="Big5" />  
<%//request.setCharacterEncoding("Big5");%>

<c:if test="${param.password == '123'}" var="condition" scope="page" > 
    ${param.user} �л���z��<b>�K�X§��</b>�I 
</c:if> 
  
���浲�G��:${condition}
</body>
</html>

<!--
http://localhost:8081/SL314_JSTL/Core_if.jsp?password=1234&user=peter1
-->