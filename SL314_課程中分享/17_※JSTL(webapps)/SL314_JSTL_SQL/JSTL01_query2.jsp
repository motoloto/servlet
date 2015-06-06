<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>JSTL01_query</title></head>
<body>
  
  
  <sql:query var="rs" dataSource="${xxx}">
     SELECT * from emp2 order by EMPNO
  </sql:query>

<table border="1">
  <tr><th>員工編號</th><th>員工姓名</th><th>職位</th><th>部門</th></tr>
 <c:forEach var="row" items="${rs.rows}" varStatus="status">
	<tr>
	  <td><c:out value="${row.EMPNO}" /></td>
	  <td><c:out value="${row.ENAME}" /></td>
	  <td><c:out value="${row.JOB}" /></td>
	  <td><c:out value="${row.DEPTNO}" /></td>
	<tr>
</c:forEach>
</table>
</body>
</html>