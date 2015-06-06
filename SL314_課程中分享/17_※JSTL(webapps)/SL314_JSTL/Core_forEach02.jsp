<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_forEach</title>
</head>
<body>

<h2><c:out value="<c:forEach> begin、end和step的用法 與 分頁練習" /></h2>

<%	
	String str[] = new String [10];
	str[0]="7001";
	str[1]="7002";
	str[2]="7003";
	str[3]="7004";
	str[4]="7005";
	str[5]="7006";
	str[6]="7007";
	str[7]="7008";
	str[8]="7009";
	str[9]="7010";
	request.setAttribute("str", str);
%>

<br>
<c:forEach var="data" items="${str}" begin="0" end="2" step="1" >
  ${data}<br>
</c:forEach>

</body>
</html>
