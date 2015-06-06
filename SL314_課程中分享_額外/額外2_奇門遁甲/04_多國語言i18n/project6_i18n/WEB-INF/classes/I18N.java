/**
  1. compile:
     javac -d . I18N.java

  2. ●先準備好"原文文字檔" , 再用 native2ascii.exe 將之轉碼為 UNICODE碼格式 的ResourceBundle檔
       如下:
       native2ascii Chinese.txt MessagesBundle_zh_TW.properties
       native2ascii Japan_uni.txt MessagesBundle_ja.properties


  3. 註: 
     如(只有)該"原文文字檔"是用真正用該語言編輯器寫出 , 
     ●則(才)需用 --> native2ascii -encoding encoding_name 指令
       如下:
       native2ascii -encoding shift_JIS Japan_jap.txt MessagesBundle_ja.properties
*/

/**
  4. 額外反向練習:
     將UNICODE碼 反向轉回原來的文字檔 ,
     ●則可用 --> native2ascii -reverse  指令
       如下:
       native2ascii -reverse MessagesBundle_zh_TW.properties Chinese2.txt
       native2ascii -reverse MessagesBundle_ja.properties Japan2.txt
*/

package international;

import java.util.*;

public class I18N implements java.io.Serializable {
	
  private String contentType;
  
  public String[] getMessage( Locale loc ){
  	ResourceBundle rsb = ResourceBundle.getBundle( "international.MessagesBundle",loc );
  	String str[] = { rsb.getString("title") , rsb.getString("str2")};
  	return str;
  }	
  
  public void setContentType( String locale ) {
  	if( locale.substring(0,2).equals("zh") )
    	    contentType = "text/html; charset=Big5";
	else if( locale.substring(0,2).equals("ja") )
     	    contentType = "text/html; charset=Shift_JIS";    
	else contentType = "text/html; charset=ISO-8859-1";       
  }
  
  public String getContentType() {
  	return contentType;
  }	
  
}
