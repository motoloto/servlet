<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>日期輸入輔助示範</title>
    <script src="src/js/jscal2.js"></script>
    <script src="src/js/lang/cn.js"></script>
    <link rel="stylesheet" type="text/css" href="src/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="src/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="src/css/gold/gold.css" />
  </head>
  <body onload="initFields()">
    <form name="calform1" method="get" action="A04_simpleCalendar_wTime_receipt.jsp">
    <table>
    <tr>
       <td><b>輸入日期:</b>
           <input type="text" name="datebox1" size="18" id="f_date1" readonly="readonly"/>
           <img align="middle" src="images/btn_date_up.gif" id="f_btn1" width="25" height="20"/></td>
       <td align=center>
            <input name="hour" id="f_hour" size="2" readonly="readonly"/></td>
        <td align=center>:</td>
        <td align=center>
            <input name="minute" id="f_minute" size="2" readonly="readonly"/></td>
    </tr>
    <tr>
        <td colspan="3" align=center>
           <input type="hidden" name="datebox2" />
           <input type="button" value="開始查詢" onclick="fun1()" />
           <input type="reset" value="重新輸入"/></td>
    </tr>
    </table></form>

    <script type="text/javascript">
      function initFields() {
        var date = new Date();
        date = Calendar.intToDate(date);
        document.getElementById("f_date1").value = Calendar.printDate(date, "%Y-%m-%d");
       // document.getElementById("f_date1").value = Calendar.printDate(date, "%Y-%m-%d %H:%M:%S"); //含時間戳記
        var h = date.getHours(), m = date.getMinutes();
        if (h < 10) h = "0" + h;
        if (m < 10) m = "0" + m;
        document.getElementById("f_hour").value = h;
        document.getElementById("f_minute").value = m;
      };
      
      function updateFields(cal) {
          var date = cal.selection.get();
          if (date) {
                  date = Calendar.intToDate(date);
                  document.getElementById("f_date1").value = Calendar.printDate(date, "%Y-%m-%d");
          } 
          var h = cal.getHours(), m = cal.getMinutes();
          if (h < 10) h = "0" + h;
          if (m < 10) m = "0" + m;
          document.getElementById("f_hour").value = h;
          document.getElementById("f_minute").value = m;
  };
      
      
      Calendar.setup({
        inputField : "f_date1",
        inputField : "f_hour",
        inputField : "f_minute",
        trigger    : "f_btn1",
        onSelect   : function() { this.hide() },
        selection    : Calendar.dateToInt(new Date()),
        
        //取消以下註解,則無法選擇今天之前的日期
        /*
        disabled      : function(date) {
          var today = new Date();
          return ( date.getYear() < today.getYear() || 
          		 (date.getYear() == today.getYear() && date.getMonth() < today.getMonth()) || 
          		 (date.getYear() == today.getYear() && date.getMonth() == today.getMonth() && date.getDate() < today.getDate()));               
        },
        */
        
        //取消以下註解,則示範無法選擇每個月的5至15日
        /*
         disabled      : function(date) {
            return (date.getDate() >= 5 &&
            date.getDate() <= 15);
         }, 
        */
        
        showTime   : 24,
        //dateFormat : "%Y-%m-%d",
        // dateFormat : "%Y-%m-%d %H:%M:%S" //含時間戳記
        // dateFormat : "%Y-%m-%d %I:%M %p"
        onSelect     : updateFields,
        onTimeChange : updateFields      
      });
      
      function fun1(){
   	     with(document.calform1){
   	       datebox2.value = datebox1.value+" "+hour.value+":"+minute.value+":00";
   	       if ((datebox1.value)=="") 
   	         alert("請輸入日期!");
   	       else submit();
   	     }
      }
    </script>
  </body>
</html>
