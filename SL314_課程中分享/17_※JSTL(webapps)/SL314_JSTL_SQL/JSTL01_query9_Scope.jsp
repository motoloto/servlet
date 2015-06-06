<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>JSTL01_query</title></head>
<body>
 

<table border="1">
  <tr><th>${sessionScope.rs.columnNames[0]}</th><th>${sessionScope.rs.columnNames[1]}</th><th>${sessionScope.rs.columnNames[2]}</th><th>${sessionScope.rs.columnNames[3]}</th></tr>
 <c:forEach var="row" items="${sessionScope.rs.rowsByIndex}" varStatus="status">
	<tr>
	  <td><c:out value="${row[0]}" /></td>
	  <td><c:out value="${row[1]}" /></td>
	  <td><c:out value="${row[2]}" /></td>
	  <td><c:out value="${row[3]}" /></td>
	<tr>
</c:forEach>
</table>

●共有員工${rs.rowCount}人
</body>
</html>