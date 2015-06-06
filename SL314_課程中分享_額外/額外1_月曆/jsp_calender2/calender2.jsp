<%@ page contentType="text/html; charset=Big5"%>

<HTML>
<HEAD>
<TITLE>日期輸入輔助示範</TITLE>

<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

</HEAD>

<BODY aLink=#cc9933 link=#333399 text=#000000 vLink=#336666 background="wall.gif">
<H1 ALIGN=CENTER> 日期輸入輔助示範 </H1>
<HR ALIGN=CENTER color=blue>
<% java.util.Date date_Util = new java.util.Date(); %>
<% java.sql.Date date_SQL = new java.sql.Date( date_Util.getTime());%> 
<center>
   <form NAME="calform1" action="receipt2.jsp" target=_blank>
       
        <TABLE border="1" bordercolor=black cellspacing=0 cellpadding=1 align=center>
          <tr> 
            <td bgcolor="#C78AE6">&nbsp;&nbsp;輸入日期範圍&nbsp;&nbsp;</td>
            
            <td>&nbsp;&nbsp;</td>
            
            <td bgcolor="#CCCCFF">
               <font size=-1>開始:</font>
               <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="datebox1" value="<%=date_SQL%>">
               <a class="so-BtnLink" href="javascript:calClick();return false;" onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('calform1','datebox1','BTN_date');return false;">
               <img align="absmiddle" border="0" name="BTN_date" src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a>
            </td>
            
            <td>~</td>
            
            <td bgcolor="#CCCCFF">
                <a class="so-BtnLink" href="javascript:calClick();return false;" onmouseover="calSwapImg('BTN_date2', 'img_Date_OVER',true);" onmouseout="calSwapImg('BTN_date2', 'img_Date_UP',true);" onclick="calSwapImg('BTN_date2', 'img_Date_DOWN');showCalendar('calform1','datebox2','BTN_date2');return false;">
                <img align="absmiddle" border="0" name="BTN_date2" src="images/btn_date_up.gif" width="22" height="17" alt="結束日期"></a>
                <font size=-1>結束:</font>
                <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="datebox2" value="<%=date_SQL%>">
            </td>
          </tr>  
          
          <tr>
          <td>
          <input type="text" name="datebox3" value="吳永志">
          </td>
          </tr> 
        </TABLE>
            <br>
            <input type="button" name="Submit" value="開始查詢" onclick="fun1()">
            <input type="reset" value="重新輸入">
           
   </form>
</center>


<SCRIPT language=JavaScript > 
  function fun1(){
     with(document.calform1){
       if ((datebox1.value)=="" || (datebox2.value)=="") 
         alert("請輸入日期!");
       else if((datebox1.value) > (datebox2.value))
         alert("開始日期不可晚於結束日期!");
       else submit();
     }
  }
</SCRIPT>


</BODY></HTML>