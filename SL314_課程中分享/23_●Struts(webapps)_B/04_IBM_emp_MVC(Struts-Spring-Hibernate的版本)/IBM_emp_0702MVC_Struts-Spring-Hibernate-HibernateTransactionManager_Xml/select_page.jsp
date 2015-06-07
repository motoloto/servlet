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
    <td><h3>IBM Emp: Home</h3><font color=red>( Struts-Spring-Hibernate MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>��Ƭd��:</h3>
<%-- ���~��C --%>
<%-- ��Ʈ榡�P������ˬd�����~ --%>
<html:errors />

<%-- �䥦���~(�Ϊ̥��~�޿�B�z)�����~ --%>
<html:messages id="messages" message="true">
	<bean:write name="messages" />
</html:messages>

<ul>
  <li><a href='<%=request.getContextPath()%>/emp/listAllEmp.jsp'>List</a> all Emps. </li> <br><br>
  
  <li>
    <html:form  method="post" action="/emp/getOne_For_Display.do" >
        <b>��J���u�s�� (�p7001):</b>
        <html:text property="empno" />
        <input type="submit" value="�e�X">
        <input type="hidden" name="action" value="getOne_For_Display">
    </html:form>
  </li>

  <jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />
   
  <li>
     <html:form  method="post" action="/emp/getOne_For_Display.do" >
       <b>��ܭ��u�s��:</b>
       <select size="1" name="empno">
         <c:forEach var="empVO" items="${empSvc.all}" > 
          <option value="${empVO.empno}">${empVO.empno}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getOne_For_Display">
    </html:form>
  </li>
  
  <li>
     <html:form  method="post" action="/emp/getOne_For_Display.do" >
       <b>��ܭ��u�m�W:</b>
       <select size="1" name="empno">
         <c:forEach var="empVO" items="${empSvc.all}" > 
          <option value="${empVO.empno}">${empVO.ename}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getOne_For_Display">
     </html:form>
  </li>
</ul>


   <jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
  
  <li>
     <html:form  method="post" action="/dept/listEmps_ByDeptno_A.do" >
       <b><font color=orange>��ܳ���:</font></b>
       <select size="1" name="deptno">
         <c:forEach var="deptVO" items="${deptSvc.all}" > 
          <option value="${deptVO.deptno}">${deptVO.dname}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="listEmps_ByDeptno_A">
     </html:form>
  </li>
</ul>


<h3>���u�޲z</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/emp/addEmp.jsp'>Add</a> a new Emp.</li>
</ul>

<h3><font color=orange>�����޲z</font></h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/dept/listAllDept.jsp'>List</a> all Depts. </li>
</ul>

</body>

</html>
