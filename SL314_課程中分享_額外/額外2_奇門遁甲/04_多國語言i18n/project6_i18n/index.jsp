<%@ page import = "java.util.* , java.text.*" %>

<jsp:useBean id="i18n" scope="page" class="international.I18N" /> 

<% Locale locale = request.getLocale(); %>

<% String str[] = i18n.getMessage(locale); %>

<% i18n.setContentType(locale.toString()); %>

<% response.setContentType(i18n.getContentType()); %>

<HTML>
<HEAD>
<TITLE> <%= str[0] %> </TITLE>
</HEAD>

<BODY>
<H1 ALIGN=CENTER><%= str[0] %></H1>
<HR>
<b><font color=blue><%= str[1] %></font>

<%
      //與地區無關
    //DateFormat df = DateFormat.getInstance();
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
    
      //隨地區而變
    //DateFormat df = DateFormat.getDateInstance(DateFormat.LONG , locale);
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG , DateFormat.LONG , locale);
    
    //時區
       //TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
	     //df.setTimeZone(tz); 
    
    String df1 = df.format(new java.util.Date());
%>

<br>
<font color=red><%=df1%></font>
</b>

<%
   //有那些時區
   //String[] xx = TimeZone.getAvailableIDs();
   //for (int i=0 ; i<xx.length ; i++)
   //out.println(xx[i]);

%>

</BODY>
</HTML>