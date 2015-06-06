<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_forEach</title>
</head>
<body>

<h2><c:out value="<c:forEach> varStatus ���|���ݩ�" /></h2>

<%	
	String str[] = new String [5];	
	str[0]="0";	
	str[1]="1";	
	str[2]="2";	
	str[3]="3";	
	str[4]="4";
	request.setAttribute("str", str);
%>

<br>
<c:forEach var="data" items="${str}" varStatus="status">
  <h3> ( <c:out value="${data}"/> ���|���ݩʦp�U ): </h3>
  index�G${status.index}</br>
  count�G${status.count}</br>
  first�G${status.first}</br>
  last �G${status.last} </br>
</c:forEach>

</body>
</html>
