<%@ page contentType="text/html; charset=Big5"%>
<%request.setCharacterEncoding("Big5");%>
<B>
 開始日期: <%=request.getParameter("datebox1")%>
<BR>
 年: <%=request.getParameter("year")%>
<BR> 
 月: <%=request.getParameter("month")%>
<BR>  
 日: <%=request.getParameter("day")%>
</B>