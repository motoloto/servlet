<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>JSTL05_transaction</title></head>
<body>
  <sql:setDataSource dataSource="jdbc/TestDB" var="xxx" scope="application"/>

  <sql:transaction dataSource="${xxx}">  
     <sql:update var="count" >
       UPDATE emp2 SET ENAME='peter99' where EMPNO=9999
     </sql:update>
  </sql:transaction>
  
  <sql:query var="rs" dataSource="${xxx}">
     select * from emp2
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