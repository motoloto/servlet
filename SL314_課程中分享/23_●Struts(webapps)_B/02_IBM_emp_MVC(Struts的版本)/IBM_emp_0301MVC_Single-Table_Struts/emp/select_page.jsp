<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head><title>IBM Emp: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>IBM Emp: Home</h3><font color=red>( Struts MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>資料查詢:</h3>
<%-- 錯誤表列 --%>
<%-- 資料格式與完整性檢查的錯誤 --%>
<html:errors />

<%-- 其它錯誤(或者企業邏輯處理)的錯誤 --%>
<html:messages id="messages" message="true">
	<bean:write name="messages" />
</html:messages>

<ul>
  <li><a href='listAllEmp.jsp'>List</a> all Emps. </li> <br><br>
  
  <li>
    <html:form  method="post" action="/emp/getOne_For_Display.do" >
        <b>輸入員工編號 (如7001):</b>
        <html:text property="empno" />
        <input type="submit" value="送出">
    </html:form>
  </li>

  <jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />
   
  <li>
     <html:form  method="post" action="/emp/getOne_For_Display.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="empno">
         <c:forEach var="empVO" items="${empSvc.all}" > 
          <option value="${empVO.empno}">${empVO.empno}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
    </html:form>
  </li>
  
  <li>
     <html:form  method="post" action="/emp/getOne_For_Display.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="empno">
         <c:forEach var="empVO" items="${empSvc.all}" > 
          <option value="${empVO.empno}">${empVO.ename}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
     </html:form>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
</ul>

</body>

</html>
