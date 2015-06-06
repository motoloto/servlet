<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ page import="java.util.*" %>
<% 
HashMap hm=new HashMap();
hm.put("peter1","peter1@foo.com");
hm.put("peter2","peter2@qoo.com");

pageContext.setAttribute("mail",hm);
%>
<html>
<head><title>EL07</title></head>
<body>
The mail address of peter1=${mail.peter1}
<br>
The mail address of peter2=${mail['peter2']}
<br>
The mail address of peter2=${mail["peter2"]}
</body>
</html>
