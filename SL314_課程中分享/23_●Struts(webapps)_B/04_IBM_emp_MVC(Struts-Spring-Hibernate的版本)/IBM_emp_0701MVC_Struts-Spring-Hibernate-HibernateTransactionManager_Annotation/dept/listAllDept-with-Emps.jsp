<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />

<html>
<head>
<title>�Ҧ����� - listAllDept-with-Emps.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='805'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ����� - listAllDept-with-Emps.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></td>
	</tr>
</table>

<table border='0' bordercolor='#CCCCFF'>
	<c:forEach var="deptVO" items="${deptSvc.all}">
		<tr bgcolor='orange'>
			<th>�����s��</th>
			<th>�����W��</th>
			<th>������a</th>
		</tr>

		<tr bgcolor='orange' align='center' valign='middle'>
			<td><font color=red><b>${deptVO.deptno}</b></font></td>
			<td>${deptVO.dname}</td>
			<td>${deptVO.loc}</td>
		</tr>

		<tr align='center' valign='middle'>
			<td colspan="3" bordercolor='#CCCCFF'>
			<table border='1' bordercolor='black' width='800'>
				<tr>
					<th>���u�s��</th>
					<th>���u�m�W</th>
					<th>¾��</th>
					<th>���Τ��</th>
					<th>�~��</th>
					<th>����</th>
				</tr>

				<c:forEach var="empVO" items="${deptVO.emps}">
					<tr align='center' valign='middle'>
						<td>${empVO.empno}</td>
						<td>${empVO.ename}</td>
						<td>${empVO.job}</td>
						<td>${empVO.hiredate}</td>
						<td>${empVO.sal}</td>
						<td>${empVO.comm}</td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
