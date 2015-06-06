<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>JSTL01_query</title></head>
<body>
  <sql:setDataSource dataSource="jdbc/TestDB" var="xxx" scope="application"/>
  
  <sql:query var="rs" dataSource="${xxx}">
     select count(*) as count from EMP2
  </sql:query>
  <%@ include file="page1.file" %> 
  <sql:query var="rs" dataSource="${xxx}" maxRows="<%=rowsPerPage%>" startRow="<%=pageIndex%>">
     SELECT EMPNO 員工編號, ENAME 員工姓名, JOB 職位, DEPTNO 部門 from emp2 order by EMPNO
  </sql:query>

<table border="1">
 <tr>
 	  <th>此頁中的計數</th>
  	<c:forEach var="columnName" items="${rs.columnNames}">
  	  <th>${columnName}</th>
  	</c:forEach>
 </tr>

 <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="status">
	<tr>
	  <td align="center">此頁中的第${status.count}筆</td>
	  <c:forEach var="columnValue" items="${row}">
	    <td align="center"><c:out value="${columnValue}"/></td>
	  </c:forEach>
	<tr>
 </c:forEach>
</table>
<%@ include file="page2.file" %>
</body>
</html>

<!-- 
SELECT emp2.EMPNO 員工編號, emp2.ENAME 員工姓名, emp2.JOB 職位, emp2.SAL 薪水, dept2.DEPTNO 部門編號, dept2.DNAME 部門名稱, dept2.LOC 部門位置 from emp2, dept2 where emp2.DEPTNO=dept2.DEPTNO order by emp2.EMPNO
-->