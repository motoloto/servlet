<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5" import="java.util.*"%>


<html>
<head>
  <title>date_protected.jsp</title>
</head>
<body bgcolor="#99FFFF">

<%
    Object account = session.getAttribute("account");                  // �q session�����X(key) account����
    if (account == null) {                                             // �p�� null, �N��user���n�J�L , �~���H�U�u�@
      session.setAttribute("location", request.getRequestURI());       //*�u�@1 : ���K�O�U�ثe��m , �H�K��login.html�n�J���\�� , ��������ɦܦ�����(���t�XLoginHandler.java)
      response.sendRedirect(request.getContextPath()+"/login.html");   //*�u�@2 : �и�user�h�n�J����(login.html) , �i��n�J
      return;
    }
%>



<b>
<font color=blue> �{�b�ɶ�: </font>
<%
  java.text.DateFormat df = java.text.DateFormat.getInstance();
  out.println(df.format(new java.util.Date()));
%>
</b>
<hr color=blue>

<br>
<%="�ϥ� java.util.Date"%>
<% java.util.Date date_Util = new java.util.Date(); %>
<br>
<%="�L�X date_Util ����: "%><%=date_Util%>
<br>
<%=date_Util.getYear()+1900%><%="�~"%>
<br>
<%=date_Util.getMonth()+1%><%="��"%>
<br>
<%=date_Util.getDate()%><%="��"%>  
<br>
<%="�P��"%><%=date_Util.getDay()%>        
<br>
<hr color=red>
<br>
<%="�ϥ� java.sql.Date"%>   
<% java.sql.Date date_SQL = new java.sql.Date( date_Util.getTime());%> 
<br>
<%="�L�X date_SQL ����: "%><%=date_SQL%>
<br>
<%=date_SQL.getYear()+1900%><%="�~"%>
<br>
<%=date_SQL.getMonth()+1%><%="��"%>
<br>
<%=date_SQL.getDate()%><%="��"%>  
<br> 
<%="�P��"%><%=date_SQL.getDay()%>                 
<br>
<hr color=red>
<br>
<%="�ϥ� java.util.GregorianCalendar"%>
<% GregorianCalendar gcalendar = new GregorianCalendar();%> <% // GregorianCalendar gcalendar = (GregorianCalendar)Calendar.getInstance();%>
<br>
<%="�L�X gcalendar ����: "%><%=gcalendar%>
<br>
<%=gcalendar.get(Calendar.YEAR)%><%="�~"%>
<br>
<%=gcalendar.get(Calendar.MONTH)+1%><%="��"%>
<br>
<%=gcalendar.get(Calendar.DATE)%><%="��"%>  
<br>
<%="���ѬO�o�P������ "%><%=gcalendar.get(Calendar.DAY_OF_WEEK)%><%=" ��"%>
<br>
<hr color=red>
<br>
<%="�ϥ� java.util.Calendar"%>
<% Calendar calendar = Calendar.getInstance();%> <% // Calendar calendar = new GregorianCalendar();%>
<br>
<%="�L�X calendar ����: "%><%=calendar%>
<br>
<%=calendar.get(Calendar.YEAR)%><%="�~"%>
<br>
<%=calendar.get(Calendar.MONTH)+1%><%="��"%>
<br>
<%=calendar.get(Calendar.DATE)%><%="��"%>  
<br>
<%="���ѬO�o�P������ "%><%=calendar.get(Calendar.DAY_OF_WEEK)%><%=" ��"%>
<br>
<hr color=red>



</body>
</html>