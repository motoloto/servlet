<%@page contentType="text/html; charset=big5" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>

<%!
String bodypage="body.jsp";
String titleWidth="100%";
int titleHeight=10;
String menuWidth="20%";
String bodyWidth="80%";
String footerWidth="100%";
int footerHeight=10;
%>
<html:html>
<head><title><tiles:getAsString name="title"/></title></head>
<body>
<table borde="0" width="<%= titleWidth %>">

<!-- 頁首部分 -->
<tr><td colspan="2" width="<%= titleWidth %>" height="<%= titleHeight %>" bgcolor="cyan">
	<tiles:insert attribute="header"/>
</td></tr>

<!-- 選單、body部份 -->
<tr><td width="<%= menuWidth %>" bgcolor="orange">
	<tiles:insert attribute="menu"/>
</td>
<td width="<%= bodyWidth %>" bgcolor="#FFD9CC">
	<tiles:insert page="<%= bodypage %>"/>
</td></tr>

<!-- 頁尾部分 -->
<tr><td colspan="2" width="<%= footerWidth %>" height="<%= footerHeight %>" bgcolor="cyan">
	<tiles:insert attribute="footer"/>
</td></tr>
</table>
</body>
</html:html>