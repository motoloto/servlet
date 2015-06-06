<%@ page import="java.util.*" contentType="text/html; charset=Big5"%>


<html>
<head>
  <title>including.jsp</title>
</head>
<body bgcolor="lightblue">

     <% out.println("有執行, 有看到");%>
     <% request.setAttribute("name1" , "peter1") ; %>    <%--有執行--%>
     <% out.println("有執行, 有看到");%>
     <% request.setAttribute("name2" , "peter2") ; %>    <%--有執行--%>

<jsp:include page="/included.jsp" flush="true">
 <jsp:param name="name0" value="peter0" />
</jsp:include>

     <% out.println("有執行, 有看到");%>

     <% out.println("有執行, 有看到");%>
</body>
</html>