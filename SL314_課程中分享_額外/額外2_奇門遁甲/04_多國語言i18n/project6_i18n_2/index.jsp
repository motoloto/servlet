<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5" %>
<%@ page import = "java.util.* , java.text.*" %>

<jsp:useBean id="i18n" scope="page" class="international.I18N" /> 
<% Locale locale = request.getLocale(); %>
<%= locale%>
<% String str[] = i18n.getMessage(locale); %>


<HTML>
<HEAD>
<TITLE> <%= str[0] %> </TITLE>
</HEAD>

<BODY>
<H1 ALIGN=CENTER><%= str[0] %></H1>
<HR>
<b><font color=blue><%= str[1] %></font>

<%
      //�P�a�ϵL��
    //DateFormat df = DateFormat.getInstance();
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
    
      //�H�a�Ϧ���
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG , locale);
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG , DateFormat.LONG , locale);
    
    //�ɰ�
       //TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
	     //df.setTimeZone(tz); 
    
    String df1 = df.format(new java.util.Date());
%>

<br>
<font color=red><%=df1%></font>
</b>

<%
   //�����Ǯɰ�
   //String[] xx = TimeZone.getAvailableIDs();
   //for (int i=0 ; i<xx.length ; i++)
   //out.println(xx[i]);

%>

</BODY>
</HTML>