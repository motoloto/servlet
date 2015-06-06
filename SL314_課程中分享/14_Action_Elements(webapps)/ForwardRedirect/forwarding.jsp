<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>


<html>
<head>
  <title>forwarding.jsp</title>
</head>
<body bgcolor="lightblue">

     <% out.println("有執行 , 但看不到 , 因buffer被清掉");%>
     <% request.setAttribute("name1" , "peter1") ; %>    <%--有執行--%>
     <% out.println("有執行 , 但看不到 , 因buffer被清掉");%>

<jsp:forward page="/forwarded.jsp">
 <jsp:param name="name0" value="peter0" />
</jsp:forward>

     <% out.println("未執行");%>
     <% request.setAttribute("name2" , "peter2") ; %>    <%--未執行--%>
     <% out.println("未執行");%>
</body>
</html>