<%@page contentType="text/html; charset=big5" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<html:html><head><title>adultView</title></head>
<body>
<h1>這是成年者的頁面</h1>
感想：<bean:write name="SampleForm" property="msg" /><br>
姓名：<bean:write name="SampleForm" property="username" /><br>
年齡：<bean:write name="SampleForm" property="age" /><br>
</body>
</html:html>