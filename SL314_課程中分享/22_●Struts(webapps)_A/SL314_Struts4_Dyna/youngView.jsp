<%@page contentType="text/html; charset=big5" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<html:html><head><title>youngView</title></head>
<body>
<h1>�o�O�����~������</h1>
�P�Q�G<bean:write name="SampleForm" property="msg" /><br>
�m�W�G<bean:write name="SampleForm" property="username" /><br>
�~�֡G<bean:write name="SampleForm" property="age" /><br>
</body>
</html:html>