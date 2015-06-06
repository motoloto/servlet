import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;
public class WebCounter extends HttpServlet {
    protected int count = 0;
    protected final static int WIDTH = 50, HEIGHT = 18, FONTSIZE = 15;
    protected final static String FONTNAME = "Arial", FILENAME = "webcounter.data";
    public void destroy() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(FILENAME));
            out.writeInt(count);
        } catch (IOException x) {
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("image/jpeg");
        BufferedImage img = draw(Integer.toString(++count));
        OutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(img);
        param.setQuality(1.0f, true);
        encoder.encode(img, param);
        out.close();
    }
    protected BufferedImage draw(String st) {
        BufferedImage img =
            new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        g2.setBackground(Color.green);
        g2.clearRect(0, 0, WIDTH, HEIGHT);
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.black);
        Font font = new Font(FONTNAME, Font.BOLD, FONTSIZE);
        g2.setFont(font);
        TextLayout tl = new TextLayout(st, font, g2.getFontRenderContext());
        Rectangle2D r = tl.getBounds();
        // center the text
        tl.draw(
            g2,
            (float) ((WIDTH - r.getWidth()) / 2),
            (float) (((HEIGHT - r.getHeight()) / 2) + r.getHeight()));
        g2.dispose();
        return img;
    }
public void init() throws ServletException {

    try {
        DataInputStream in = new DataInputStream(new FileInputStream(FILENAME));
        count = in.readInt();
    } catch (IOException x) {
    }
}
}
