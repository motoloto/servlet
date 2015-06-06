<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>


<html>
<head>
  <title>sendRedirect.jsp</title>
</head>
<body bgcolor="lightblue">
     
     <% out.println("有執行 , 看不到");%>
     <% session.setAttribute("name1" , "peter1") ; %>    <%--有執行--%>
     <% out.println("有執行 , 看不到");%>


<%
       //相對路徑
       response.sendRedirect("Redirected.jsp?name0=peter0");
       
       //完整絕對路徑
       //response.sendRedirect("http://localhost:8081/ForwardRedirect/Redirected.jsp?name0=peter0");
       
%>

     <% out.println("有執行 , 看不到");%>
     <% session.setAttribute("name2" , "peter2") ; %>    <%--有執行--%>
     <% out.println("有執行 , 看不到");%>
</body>
</html>