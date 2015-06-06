<%@ page contentType="text/html; charset=Big5"%>
<%  request.setCharacterEncoding("Big5");%>

<html>
<head>
<title>receive.jsp</title>
</head>
<body >
<center>
<% 
   String[] emp=request.getParameterValues("emp_no");
%>


<table width="82%" border="1"  bordercolor="black" cellspacing="0" cellpadding="1" align="center" vspace="20">
  
  <tr bgcolor="#C78AE6">
    <td width="50%" height="155">
     <%for( int i=0;i<emp.length;i++) {%>
       <li><%=emp[i]%>&nbsp&nbsp
     <%}%>
    </td>
  </tr>

</table>
  
</center>
</body>
</html>
