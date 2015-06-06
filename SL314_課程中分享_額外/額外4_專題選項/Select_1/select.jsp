<%@ page contentType="text/html; charset=Big5"%>
<%  request.setCharacterEncoding("Big5");%>

<html>
<head>
<title>設定</title>
</head>

<BODY aLink=#0033cc link=#0033cc text=#000000 vLink=#0033cc bgcolor="" >
<CENTER>

<form method="get" action="receive.jsp" name="form1" >


<!------------------------------------------------------------------------------------------------->
<br>
<table border="0" width="757" bordercolor="black" cellspacing=0 cellpadding=1 align=center>
        <TR bgcolor="">
         <TD width=135>&nbsp●<b><font face="標楷體" color=black>從<font color=red>左</font>至<font color=red>右</font>視窗</font></b></TD>
         <TD align="center"><font face="標楷體" color=black><b>原始資料</b></font></TD>
         <TD align="center"><font face="標楷體" color=black><b>被選資料</b></font></TD>
        </TR>
</table>        
<table border="1" width="757" bordercolor="black" cellspacing=0 cellpadding=1 align=center>        
        <TR>
            <TD width=135 rowspan="2" align="center" valign="bottom" bgcolor="#ffffff">
              <img src="images/tomcat.gif" align="texttop" border="0">
              <br><br><font size=-1>註:<font color=red>右</font>視窗資料被送出</font>
            </TD>
            
            <TD rowspan="2" align="center" bgcolor="white">
              <SELECT size="10" MULTIPLE  name="select1" onDblClick="createOptions()" style="background-color:orange; margin-left:0px; margin-right:0px">
               <!--  
               <option >選擇人員 <option>------------------------------------------------------------------
               -->
               <option >&nbsp <option>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <% for( int i=0; i<5; i++){ %>
               <option value="<%=i%>"><%=i%>
                <%}%> 
              </SELECT>
            </TD>
            
            <TD align="center" bgcolor="white" width=30px>
               <INPUT type="button" value="-->" name="button1" onClick="createOptions()" style="border-width:3px; border-style:ridge; background-color:#C78AE6; border-color:black; width:30px; height:80px">
            </TD>
            
            <TD rowspan="2" align="center" bgcolor="white">
              <SELECT size="10" MULTIPLE name="emp_no" onDblClick="delOptions()" style="background-color:#C78AE6; margin-left:0px; margin-right:0px"">
               <option >&nbsp <option>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  
              </SELECT>
            </TD>
              
        </TR>
        <TR>
            <TD align="center" bgcolor="white" width=30px>
             <INPUT type="button" value="<--" name="button2" onClick="delOptions()" style="border-width:3px; border-style:ridge; background-color:orange; border-color:black; width:30px; height:80px">
            </TD>
        </TR>
</TABLE>
<!------------------------------------------------------------------------------------------------->
   
   <hr>
    <INPUT type="button" value="送出新增" onClick="checkup()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <INPUT type="RESET" value="取消"  onClick="location.reload()">
   </form>


</CENTER>
</body>
</html>


   
<script language=javascript>
  <!-- ************************ 人員明細 ************************ --> 
   <!-- 人員：左視窗→右視窗-->
   function createOptions(){
      
      sel1 = document.form1.select1;
      sel2 = document.form1.emp_no;
      
      <!--人員：將選取的選項放到total陣列中，並記錄被選取的位置並置於spaceindex陣列中 -->
     
      var total = new Array() ; 
      var spaceindex = new Array() ;
      var j = 0 ;     
      for( i = 0 ; i < sel1.options.length-2 ; i ++){
         
         if( sel1.options[i+2].selected ){
            total[j] = sel1.options[i+2].text ; 
            sel1.options[i+2].text = '' ; 
            spaceindex[j] = i + 2 ;          
            j ++;                       
         }
      }                         
      <!--人員：再由total陣列放到"已選擇"的視窗中-->
      var item	= sel2.options.length;
      if( total.length != 0 ){               
         for( i = 0 ; i < total.length ; i ++ ){
            if( total[i] != '' ){                                           
               var option = new Option(total[i]);            
	            sel2.options[item+i] = option; 	         
	         }
	      }
	   }
	   <!--人員：依照spaceindex陣列中的對應指標，由後往前宣告對應的 option 為 null-->
	   for( i = spaceindex.length -1 ; i >= 0   ; i -- ){
	      sel1.options[spaceindex[i]] = null ;
	   }
	   sel1.selectedIndex = 10000;
   }
   <!-- 人員：右視窗→左視窗-->
   function delOptions() {
      sel1 = document.form1.select1;
      sel2 = document.form1.emp_no;
      
      <!--人員：將選取的選項放到total陣列中，並記錄被選取的位置並置於spaceindex陣列中 -->
     
      var total = new Array() ; 
      var spaceindex = new Array() ;
      var j = 0 ;     
      for( i = 0 ; i < sel2.options.length-2 ; i ++){         
         if( sel2.options[i+2].selected ){
            total[j] = sel2.options[i+2].text ; 
            sel2.options[i+2].text = '' ; 
            spaceindex[j] = i + 2 ;          
            j ++;                       
         }
      }                         
      <!--人員：再由total陣列放到"已選擇"的視窗中-->
      var item	= sel1.options.length;
      if( total.length != 0 ){               
         for( i = 0 ; i < total.length ; i ++ ){
            if( total[i] != '' ){                                           
               var option = new Option(total[i]);            
	            sel1.options[item+i] = option; 	         
	         }
	      }
	   }
	   <!--人員：依照spaceindex陣列中的對應指標，由後往前宣告對應的 option 為 null-->
	   for( i = spaceindex.length -1 ; i >= 0   ; i -- ){
	      sel2.options[spaceindex[i]] = null ;
	   }
	   sel2.selectedIndex = 10000;
   }
 
 <!--送出前的檢查-->   
   function checkup(){      
      sel2 = document.form1.emp_no; 
      if( sel2.options.length > 2 ){
         for( i = 2 ; i < sel2.options.length ; i ++ ){
            sel2.options[i].selected = true ;
         }    
         //document.form1.submit() ;
      }else{
         window.alert("請選擇資料");         
         return ;
      }
   form1.submit(); //送出表單中的資料
   }
 
 
 </script>
   
   
   
