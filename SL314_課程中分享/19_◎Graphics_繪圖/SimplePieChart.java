package servlet_examples;

import java.awt.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Acme.JPM.Encoders.GifEncoder;

import javachart.chart.*;  // from Visual Engineering

public class SimplePieChart extends HttpServlet {

  static final int WIDTH = 760;
  static final int HEIGHT = 360;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException ,IOException {
    ServletOutputStream out = res.getOutputStream();

    Frame frame = null;
    Graphics g = null;

    try {
      // Create a simple chart
      PieChart chart = new PieChart("Apples and Oranges");

      // Give it a title
      chart.getBackground().setTitleFont(new Font("Serif", Font.PLAIN, 24));
      chart.getBackground().setTitleString("Comparing Apples and Oranges");

      // Show, place, and customize its legend
      chart.setLegendVisible(true);
      chart.getLegend().setLlX(0.5);  // normalized from lower left
      chart.getLegend().setLlY(0.8); // normalized from lower left
      chart.getLegend().setIconHeight(0.04);
      chart.getLegend().setIconWidth(0.02);
      chart.getLegend().setIconGap(0.01);
      chart.getLegend().setVerticalLayout(false);

      // Give it its data and labels
      double[] appleData = {500, 1005, 1210, 1165, 1255};
      String[] labels = {"1993", "1994", "1995", "1996", "1997"};
      chart.addDataSet("Apples", appleData, labels);

      // Size it appropriately
      chart.resize(WIDTH, HEIGHT);

      // Create an unshown frame
      frame = new Frame();
      frame.addNotify();

      // Get a graphics region of appropriate size, using the Frame
      Image image = frame.createImage(WIDTH, HEIGHT);
      g = image.getGraphics();
      chart.setThreeD(true);
      // Ask the chart to draw itself to the off screen graphics context
      chart.drawGraph(g);

      // Encode and return what it painted
      res.setContentType("image/gif");
      GifEncoder encoder = new GifEncoder(image, out);
      encoder.encode();
    }
    finally {
      // Clean up resources
      if (g != null) g.dispose();
      if (frame != null) frame.removeNotify();
    }
  }
}
