<%@ page contentType="text/html; charset=Big5"%>
<%  request.setCharacterEncoding("Big5");%>

<html>
<head>
<title>�]�w</title>
</head>

<BODY aLink=#0033cc link=#0033cc text=#000000 vLink=#0033cc bgcolor="" >
<CENTER>

<form method="get" action="receive.jsp" name="form1" >


<!------------------------------------------------------------------------------------------------->
<br>
<table border="0" width="757" bordercolor="black" cellspacing=0 cellpadding=1 align=center>
        <TR bgcolor="">
         <TD width=135>&nbsp��<b><font face="�з���" color=black>�q<font color=red>��</font>��<font color=red>�k</font>����</font></b></TD>
         <TD align="center"><font face="�з���" color=black><b>��l���</b></font></TD>
         <TD align="center"><font face="�з���" color=black><b>�Q����</b></font></TD>
        </TR>
</table>        
<table border="1" width="757" bordercolor="black" cellspacing=0 cellpadding=1 align=center>        
        <TR>
            <TD width=135 rowspan="2" align="center" valign="bottom" bgcolor="#ffffff">
              <img src="images/tomcat.gif" align="texttop" border="0">
              <br><br><font size=-1>��:<font color=red>�k</font>������ƳQ�e�X</font>
            </TD>
            
            <TD rowspan="2" align="center" bgcolor="white">
              <SELECT size="10" MULTIPLE  name="select1" onDblClick="createOptions()" style="background-color:orange; margin-left:0px; margin-right:0px">
               <!--  
               <option >��ܤH�� <option>------------------------------------------------------------------
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
    <INPUT type="button" value="�e�X�s�W" onClick="checkup()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <INPUT type="RESET" value="����"  onClick="location.reload()">
   </form>


</CENTER>
</body>
</html>


   
<script language=javascript>
  <!-- ************************ �H������ ************************ --> 
   <!-- �H���G���������k����-->
   function createOptions(){
      
      sel1 = document.form1.select1;
      sel2 = document.form1.emp_no;
      
      <!--�H���G�N������ﶵ���total�}�C���A�ðO���Q�������m�øm��spaceindex�}�C�� -->
     
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
      <!--�H���G�A��total�}�C���"�w���"��������-->
      var item	= sel2.options.length;
      if( total.length != 0 ){               
         for( i = 0 ; i < total.length ; i ++ ){
            if( total[i] != '' ){                                           
               var option = new Option(total[i]);            
	            sel2.options[item+i] = option; 	         
	         }
	      }
	   }
	   <!--�H���G�̷�spaceindex�}�C�����������СA�ѫ᩹�e�ŧi������ option �� null-->
	   for( i = spaceindex.length -1 ; i >= 0   ; i -- ){
	      sel1.options[spaceindex[i]] = null ;
	   }
	   sel1.selectedIndex = 10000;
   }
   <!-- �H���G�k������������-->
   function delOptions() {
      sel1 = document.form1.select1;
      sel2 = document.form1.emp_no;
      
      <!--�H���G�N������ﶵ���total�}�C���A�ðO���Q�������m�øm��spaceindex�}�C�� -->
     
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
      <!--�H���G�A��total�}�C���"�w���"��������-->
      var item	= sel1.options.length;
      if( total.length != 0 ){               
         for( i = 0 ; i < total.length ; i ++ ){
            if( total[i] != '' ){                                           
               var option = new Option(total[i]);            
	            sel1.options[item+i] = option; 	         
	         }
	      }
	   }
	   <!--�H���G�̷�spaceindex�}�C�����������СA�ѫ᩹�e�ŧi������ option �� null-->
	   for( i = spaceindex.length -1 ; i >= 0   ; i -- ){
	      sel2.options[spaceindex[i]] = null ;
	   }
	   sel2.selectedIndex = 10000;
   }
 
 <!--�e�X�e���ˬd-->   
   function checkup(){      
      sel2 = document.form1.emp_no; 
      if( sel2.options.length > 2 ){
         for( i = 2 ; i < sel2.options.length ; i ++ ){
            sel2.options[i].selected = true ;
         }    
         //document.form1.submit() ;
      }else{
         window.alert("�п�ܸ��");         
         return ;
      }
   form1.submit(); //�e�X��椤�����
   }
 
 
 </script>
   
   
   
