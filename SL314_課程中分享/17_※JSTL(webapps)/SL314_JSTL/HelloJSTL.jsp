<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  <title>JSTL��������</title>
  </head>
  
  <body>
    <c:out value="JSTL��������"/><br><br>
  
    �A�ϥΪ��s����:<br>
    <c:out value="${header['User-Agent']}"/><br><br>
    
    �S��r��:<br>
    <c:out value="Hello World ! </�ڬO Tomcat>" escapeXml="true"/>
  </body>
</html>
