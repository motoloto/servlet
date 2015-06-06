<%@ page import="java.util.*" contentType="text/html; charset=Big5"%>


<html>
<head>
  <title>forwarded.jsp</title>
</head>
<body bgcolor="orange">
<hr color=red>
§Ú¬O included.jsp
<br>
Hello!
<br>
       <% out.println("name0= "+request.getParameter("name0"));%>
<br>
       <% out.println("name1= "+request.getAttribute("name1"));%>
<br>
       <% out.println("name2= "+request.getAttribute("name2"));%>
       
       <jsp:include page="/included2.jsp" flush="true" />
    
       
<hr color=red>
</body>
</html>