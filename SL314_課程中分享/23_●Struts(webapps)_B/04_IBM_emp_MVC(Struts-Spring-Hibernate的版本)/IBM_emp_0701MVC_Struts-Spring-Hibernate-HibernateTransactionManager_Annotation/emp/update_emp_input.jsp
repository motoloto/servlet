<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="com.emp.model.*"%>

<html>
<head>
<title>���u��ƭק� - update_emp_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���u��ƭק� - update_emp_input.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></td>
	</tr>
</table>

<%-- ���~��C --%>
<%-- ��Ʈ榡�P������ˬd�����~ --%>
<html:errors />

<%-- �䥦���~(�Ϊ̥��~�޿�B�z)�����~ --%>
<html:messages id="messages" message="true">
	<bean:write name="messages" />
</html:messages>

<html:form action="/emp/update.do" method="post">
	<table border="0">
		<tr>
			<td><bean:message key="emp.empno" /><font color=red><b>*</b></font></td>
			<td>${empForm.empno}</td>
		</tr>
		<tr>
			<td><bean:message key="emp.ename" /></td>
			<td><input type="TEXT" name="ename" size="45"
				value='${empForm.ename}'></td>
		</tr>
		<tr>
			<td><bean:message key="emp.job" /></td>
			<td><input type="TEXT" name="job" size="45"
				value='${empForm.job}' />
		</tr>
		<tr>
			<td><bean:message key="emp.hiredate" /></td>
			<td bgcolor="#CCCCFF">
		        <input class="cal-TextBox"
			    onFocus="this.blur()" size="9" readonly type="text" name="hiredate" 
			    value='${empForm.hiredate}'>
			    <a class="so-BtnLink"
			    href="javascript:calClick();return false;"
			    onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			    onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			    onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('empForm','hiredate','BTN_date');return false;">
		        <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a>
		    </td>
		</tr>
		<tr>
			<td><bean:message key="emp.sal" /></td>
			<td><input type="TEXT" name="sal" size="45"
				value='${empForm.sal}' />
		</tr>
		<tr>
			<td><bean:message key="emp.comm" /></td>
			<td><input type="TEXT" name="comm" size="45"
				value='${empForm.comm}' />
		</tr>

		<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
		<tr>
			<td><bean:message key="emp.deptno" /><font color=red><b>*</b></font></td>
			<td><html:select property="deptno">
					<c:forEach var="deptVO" items="${deptSvc.all}">
					   <html:option value="${deptVO.deptno}">${deptVO.dname}</html:option>
				    </c:forEach>
				</html:select></td>
		</tr>

	</table>
	<br>
	<input type="hidden" name="empno" value='<bean:write name="empForm" property="empno"/>' >
	<input type="submit" value="<bean:message key="empUpdate.submit"/>">
	<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--�u�Ω�:istAllEmp.jsp-->
	<input type="hidden"  name="action" value="update">
</html:form>

<br>�e�X�ק諸�ӷ��������|:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (���d�ҥثe�u�Ω�:istAllEmp.jsp))</b>
</body>
</html>