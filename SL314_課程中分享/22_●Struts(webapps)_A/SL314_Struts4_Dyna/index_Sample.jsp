<%@page contentType="text/html; charset=big5" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<html:html>
<head><title>Sample</title></head>
<body>
<html:form action="/SampleAction">
發表一句感想：<html:text property="msg" size="30"/><br>
姓名：<html:text property="username" size="30"/><br>
年齡：<html:text property="age" size="30"/><br>
<html:submit property="submit" value="OK"/>
<html:reset value="reset"/>
</html:form></body>
</html:html>