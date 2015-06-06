/**
  1. compile:
     javac -d . I18N.java

  2. �����ǳƦn"����r��" , �A�� native2ascii.exe �N����X�� UNICODE�X�榡 ��ResourceBundle��
       �p�U:
       native2ascii Chinese.txt MessagesBundle_zh_TW.properties
       native2ascii Japan_uni.txt MessagesBundle_ja.properties


  3. ��: 
     �p(�u��)��"����r��"�O�ίu���θӻy���s�边�g�X , 
     ���h(�~)�ݥ� --> native2ascii -encoding encoding_name ���O
       �p�U:
       native2ascii -encoding shift_JIS Japan_jap.txt MessagesBundle_ja.properties
*/

/**
  4. �B�~�ϦV�m��:
     �NUNICODE�X �ϦV��^��Ӫ���r�� ,
     ���h�i�� --> native2ascii -reverse  ���O
       �p�U:
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
