<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>JSTL01_query</title></head>
<body>
  <sql:setDataSource dataSource="jdbc/TestDB" var="xxx" scope="application"/>
  
  <sql:query var="rs" dataSource="${xxx}">
    SELECT EMPNO 員工編號, ENAME 員工姓名, JOB 職位, SAL 薪水, to_char(HIREDATE,'yyyy-mm-dd') 雇用日期, DEPTNO 部門 from emp2 where SAL>? and to_char(HIREDATE,'yyyy-mm-dd')>? order by EMPNO
    <sql:param value="${param.sal}" />
    <sql:param value="${param.hiredate}" />
  </sql:query>

<table border="1">
 <tr>
 	  <th>計數</th>
  	<c:forEach var="columnName" items="${rs.columnNames}">
  	  <th>${columnName}</th>
  	</c:forEach>
 </tr>
 
 <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="status">
	<tr>
	  <td align="center">第${status.count}筆</td>
	  <c:forEach var="columnValue" items="${row}">
	    <td align="center"><c:out value="${columnValue}"/></td>
	  </c:forEach>
	<tr>
 </c:forEach>
</table>
</body>
</html>

<!--
SELECT EMPNO 員工編號, ENAME 員工姓名, JOB 職位, SAL 薪水, to_char(HIREDATE,'yyyy-mm-dd') 雇用日期, DEPTNO 部門 from emp2 where SAL>2000 and to_char(HIREDATE,'yyyy-mm-dd')>'1980-01-01' order by EMPNO
-->

<!--
http://localhost:8081/SL314_JSTL_SQL/param/JSTL01_query4_Index_forEach_param.jsp?sal=2000&hiredate=1980-01-01
-->