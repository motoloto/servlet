<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>

<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>form2.jsp</TITLE>
</HEAD>
<BODY>

 <FORM METHOD="POST" ACTION="Hello">
      
    請輸入您的名字!
    <INPUT TYPE="TEXT" NAME="name" VALUE="peter1吳永志"><P>
    <INPUT TYPE="SUBMIT">
 </FORM>

 <img src="images/tomcat.gif">

 <table border="1" bordercolor="blue">

   <% for (int i=1 ; i<10 ; i++) { %>
     <tr>
       <% for (int j=1 ; j<10 ; j++) { %> 
         <td><%=i%>*<%=j%>=<%=i*j%></td>
       <% } %>
     </tr>
   <% } %>

 </table>

<%! int count=0; %>
第 <%= ++count %> 次拜訪
<br>
</BODY>
</HTML>
