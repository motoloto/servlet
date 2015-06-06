package epaper;

import java.io.*;
import java.net.*;

public class EpaperPostURL {
	public void EpaperTemp() throws IOException {
		Reader in = null;
		Writer out = null;
		try {
			String str = "PRO_ITEM=" + URLEncoder.encode("", "Big5");
			URL url = new URL("http://localhost:8081/IBM/form2.jsp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setDoOutput(true);
			con.setDoInput(true);
			out = new OutputStreamWriter(con.getOutputStream());
			out.write(str);
			out.flush();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				in = new InputStreamReader(con.getInputStream());
				out = new OutputStreamWriter(new FileOutputStream("C:\\epaper.html"));
				char[] buf = new char[1024];
				int len = 0;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
			} else {
				System.out.println("Status Code: " + con.getResponseCode());
				System.out.println("Status Message: " + con.getResponseMessage());
			}
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}
}