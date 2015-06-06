<%@ page contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<B>
日期: <%=request.getParameter("datebox1")%>
<BR>
幾時: <%=request.getParameter("hour")%>時
<BR>
幾分: <%=request.getParameter("minute")%>分
<BR>
<font color=red>datebox2: </font>
<font color=blue><%=request.getParameter("datebox2")%></font>
</B>