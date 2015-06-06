<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%
  response.setHeader("Cache-Control","no-store"); //HTTP 1.1
  response.setHeader("Pragma","no-cache");        //HTTP 1.0
  response.setDateHeader ("Expires", 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=BIG5">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>form1.jsp</TITLE>
</HEAD>
<BODY>

 <FORM METHOD="POST" ACTION="Hello">
      
    請輸入您的名字!
    <INPUT TYPE="TEXT" NAME="name" VALUE="peter1吳永志"><P>
    <INPUT TYPE="SUBMIT">
 </FORM>

 <img src="images/tomcat.gif">

 <table border="1" bordercolor="blue">
   <tr><th>數字</th><th>平方</th></tr> 

   <% for (int i=0 ; i<10 ; i++) { %>
     <tr><td><%= i %></td><td><%= i*i %></td></tr>
   <% } %>

 </table>

<%! int count=0; %>

(本網頁)第 <%= ++count %> 次拜訪
<br>
</BODY>
</HTML>
