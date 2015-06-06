<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%request.setCharacterEncoding("Big5");%>


<jsp:useBean id="hello" scope="session" class="hello.HelloBean">
  <jsp:setProperty name="hello" property="*" />
  <%out.println("IBM");%>
</jsp:useBean>


<HTML>
<HEAD><TITLE>Hello</TITLE></HEAD>
<BODY>
<H1>
Hello, <jsp:getProperty name="hello" property="name" />
</H1>
</BODY>
</HTML>
