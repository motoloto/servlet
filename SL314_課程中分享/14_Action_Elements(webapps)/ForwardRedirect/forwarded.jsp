<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>


<html>
<head>
  <title>forwarded.jsp</title>
</head>
<body bgcolor="orange">

§Ú¬O forwarded.jsp
<br>
Hello!
<br>
       <% out.println("name0= "+request.getParameter("name0"));%>
<br>
       <% out.println("name1= "+request.getAttribute("name1"));%>
<br>
       <% out.println("name2= "+request.getAttribute("name2"));%>
</body>
</html>