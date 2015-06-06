<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  <title>JSTL網頁測試</title>
  </head>
  
  <body>
    <c:out value="JSTL網頁測試"/><br><br>
  
    你使用的瀏覽器:<br>
    <c:out value="${header['User-Agent']}"/><br><br>
    
    特殊字元:<br>
    <c:out value="Hello World ! </我是 Tomcat>" escapeXml="true"/>
  </body>
</html>
