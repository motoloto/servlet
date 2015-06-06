<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_import.jsp</title>
</head>
<body>

<h2><c:out value="<c:import> ªº¥Îªk" /></h2>



<c:import url="http://localhost:8081/SL314_EL/Hello" >
  <c:param name="name" value="peter1" />
</c:import><br>

<c:import url="/Core_forEach01.jsp" >
  <c:param name="name" value="peter1" />
</c:import><br>

 <!-- 
    µù: server.xml
   <Context path="/SL314_JSTL" docBase="SL314_JSTL"
        debug="5" reloadable="true" crossContext="true"/>
 -->
<c:import url="/Hello" context="/SL314_EL">
  <c:param name="name" value="peter1" />
</c:import><br>











</body>
</html>