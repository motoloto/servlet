<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>


<html>
<head>
  <title>Redirected.jsp</title>
</head>
<body bgcolor="orange">

§Ú¬O Redirected.jsp
<br>
Hello!
<br>
       <% out.println("name0= "+request.getParameter("name0"));%>
<br>
       <% out.println("name1= "+session.getAttribute("name1"));%>
<br>
       <% out.println("name2= "+session.getAttribute("name2"));%>
</body>
</html>