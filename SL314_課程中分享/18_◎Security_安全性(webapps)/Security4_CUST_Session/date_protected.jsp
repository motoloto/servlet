<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5" import="java.util.*"%>


<html>
<head>
  <title>date_protected.jsp</title>
</head>
<body bgcolor="#99FFFF">

<%
    Object account = session.getAttribute("account");                  // 從 session內取出(key) account的值
    if (account == null) {                                             // 如為 null, 代表此user未登入過 , 才做以下工作
      session.setAttribute("location", request.getRequestURI());       //*工作1 : 順便記下目前位置 , 以便於login.html登入成功後 , 能夠直接導至此網頁(須配合LoginHandler.java)
      response.sendRedirect(request.getContextPath()+"/login.html");   //*工作2 : 請該user去登入網頁(login.html) , 進行登入
      return;
    }
%>



<b>
<font color=blue> 現在時間: </font>
<%
  java.text.DateFormat df = java.text.DateFormat.getInstance();
  out.println(df.format(new java.util.Date()));
%>
</b>
<hr color=blue>

<br>
<%="使用 java.util.Date"%>
<% java.util.Date date_Util = new java.util.Date(); %>
<br>
<%="印出 date_Util 物件: "%><%=date_Util%>
<br>
<%=date_Util.getYear()+1900%><%="年"%>
<br>
<%=date_Util.getMonth()+1%><%="月"%>
<br>
<%=date_Util.getDate()%><%="日"%>  
<br>
<%="星期"%><%=date_Util.getDay()%>        
<br>
<hr color=red>
<br>
<%="使用 java.sql.Date"%>   
<% java.sql.Date date_SQL = new java.sql.Date( date_Util.getTime());%> 
<br>
<%="印出 date_SQL 物件: "%><%=date_SQL%>
<br>
<%=date_SQL.getYear()+1900%><%="年"%>
<br>
<%=date_SQL.getMonth()+1%><%="月"%>
<br>
<%=date_SQL.getDate()%><%="日"%>  
<br> 
<%="星期"%><%=date_SQL.getDay()%>                 
<br>
<hr color=red>
<br>
<%="使用 java.util.GregorianCalendar"%>
<% GregorianCalendar gcalendar = new GregorianCalendar();%> <% // GregorianCalendar gcalendar = (GregorianCalendar)Calendar.getInstance();%>
<br>
<%="印出 gcalendar 物件: "%><%=gcalendar%>
<br>
<%=gcalendar.get(Calendar.YEAR)%><%="年"%>
<br>
<%=gcalendar.get(Calendar.MONTH)+1%><%="月"%>
<br>
<%=gcalendar.get(Calendar.DATE)%><%="日"%>  
<br>
<%="今天是這星期的第 "%><%=gcalendar.get(Calendar.DAY_OF_WEEK)%><%=" 天"%>
<br>
<hr color=red>
<br>
<%="使用 java.util.Calendar"%>
<% Calendar calendar = Calendar.getInstance();%> <% // Calendar calendar = new GregorianCalendar();%>
<br>
<%="印出 calendar 物件: "%><%=calendar%>
<br>
<%=calendar.get(Calendar.YEAR)%><%="年"%>
<br>
<%=calendar.get(Calendar.MONTH)+1%><%="月"%>
<br>
<%=calendar.get(Calendar.DATE)%><%="日"%>  
<br>
<%="今天是這星期的第 "%><%=calendar.get(Calendar.DAY_OF_WEEK)%><%=" 天"%>
<br>
<hr color=red>



</body>
</html>