<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_import.jsp</title>
</head>
<body>

<h2><c:out value="<c:import> ªº¥Îªk" /></h2>

<a href=" 
          <c:url value="http://tw.yahoo.com" >
              <c:param name="name1" value="peter1"/>
           </c:url>
        "> Java </a>
        
<br>        

<a href="http://tw.yahoo.com?name1=peter1" > Java </a>        

</body>
</html>