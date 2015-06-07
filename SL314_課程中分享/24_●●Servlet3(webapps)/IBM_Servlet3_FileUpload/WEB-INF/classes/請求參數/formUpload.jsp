<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<HTML>
<HEAD><TITLE>上 傳 圖 檔</TITLE></head>
<BODY>

  <FORM action="uploadServlet3.do" method=post enctype="multipart/form-data">
        <INPUT TYPE="TEXT" NAME="name" VALUE="peter1吳永志">
        <br>
        <INPUT TYPE="TEXT" NAME="name" VALUE="peter2吳永志">
        <br>
        <input type="file" name="upfile1">
        <br>
        <input type="file" name="upfile2">
        <INPUT type="submit" value="上傳">
  </FORM>

</BODY>
</HTML>
