package epaper;

import java.util.*;
import java.lang.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {
	String mailserver = "140.115.236.9";
	String From = "Test1@msa.hinet.net";
	String to = "aaa@gmail.com , bbb@gmail.com , ccc@gmail.com";
	String Subject = "XXX �|���q�l��";
	
	InternetAddress[] address = null;
	
	public void Send() {
		boolean sessionDebug = false;
		
		try {
			java.util.Properties props = System.getProperties();
			props.put("mail.host",mailserver);
			props.put("mail.transport.protocol","smtp");
			javax.mail.Session mailSession = javax.mail.Session.getDefaultInstance(props,null);
			mailSession.setDebug(sessionDebug);
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(From));
			address = InternetAddress.parse(to,false);
			msg.setRecipients(Message.RecipientType.TO, address);
			
			msg.setSubject(Subject,"Big5");
			msg.setSentDate(new java.util.Date());
			msg.setContent(getMessageText(),"text/html;charset=Big5");
			Transport.send(msg);
			
			System.out.println("�q�l�� �w���Q�e�X!");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public String getMessageText() {
		StringBuffer msgtxt = new StringBuffer();
		
		try {
			String str;
			FileReader fr = new FileReader("C:\\epaper.html");
			BufferedReader br = new BufferedReader(fr);
			while ((str = br.readLine()) != null)
				msgtxt.append(str);
			br.close();
			fr.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return msgtxt.toString();
	}
}
