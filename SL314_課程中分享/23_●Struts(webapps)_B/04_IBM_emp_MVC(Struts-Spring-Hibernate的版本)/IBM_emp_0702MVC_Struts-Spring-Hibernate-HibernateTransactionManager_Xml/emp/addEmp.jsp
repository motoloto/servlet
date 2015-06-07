<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="com.emp.model.*"%>

<html>
<head>
<title>addEmp.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>員工資料新增 - addEmp.jsp</h3>
		</td>
		<td>
		  <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<%-- 資料格式與完整性檢查的錯誤 --%>
<html:errors />

<%-- 其它錯誤(或者企業邏輯處理)的錯誤 --%>
<html:messages id="messages" message="true">
	<bean:write name="messages" />
</html:messages>

<html:form action="/emp/insert.do" method="post">
	<table border="0">

		<tr>
			<td><bean:message key="emp.ename" /></td>
			<td><html:text property="ename" size="45"/></td>
		</tr>
		<tr>
			<td><bean:message key="emp.job" /></td>
			<td><html:text property="job" size="45"/></td>
		</tr>
		<tr>
			<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis()); pageContext.setAttribute("date_SQL",date_SQL);%>
			<td><bean:message key="emp.hiredate" /></td>
			<td bgcolor="#CCCCFF">
		        <input class="cal-TextBox"
			    onFocus="this.blur()" size="9" readonly type="text" name="hiredate" 
			    value="<c:out value="${empForm.hiredate}" default="${date_SQL}" />">
			    <a class="so-BtnLink"
			    href="javascript:calClick();return false;"
			    onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			    onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			    onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('empForm','hiredate','BTN_date');return false;">
		        <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a>
		    </td>
		</tr>
		<tr>
			<td><bean:message key="emp.sal" /></td>
			<td><html:text property="sal" size="45"/></td>
		</tr>
		<tr>
			<td><bean:message key="emp.comm" /></td>
			<td><html:text property="comm" size="45"/></td>
		</tr>

		<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
		<tr>
			<td><bean:message key="emp.deptno" /><font color=red><b>*</b></font></td>
			<td><html:select property="deptno">
				    <c:forEach var="deptVO" items="${deptSvc.all}">
					   <html:option value="${deptVO.deptno}">${deptVO.dname}</html:option>
				    </c:forEach>
			    </html:select>
			</td>
		</tr>

	</table>
	<br>
	<input type="submit" value="<bean:message key="empAdd.submit"/>">
	<input type="hidden" name="action" value="insert">
</html:form>
</body>

</html>