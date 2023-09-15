/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.calendar;

/**
 *
 * @author xingl
 */
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockPanel extends JPanel {
  private final long serialVersionUID = -5798563675397576323L;
  private final int DEFAULT_WIDTH = 400;
  private final int DEFAULT_HEIGHT = 400;
  private final Color BG_COLOR = Color.WHITE;
  private final Color HOUR_COLOR = Color.BLACK;
  private final Color MINUTE_COLOR = Color.BLUE;
  private final int STROKE_WIDTH = 4;
  private final double MINUTE_HAND_LENGTH = 0.6;
  private final double HOUR_HAND_LENGTH = 0.6;

  private Calendar cal;
  private SimpleDateFormat sdf;
  private int width;
  private int height;

  public ClockPanel(int width, int height) {
    this.cal = Calendar.getInstance();
    this.sdf = new SimpleDateFormat("hh:mm:ss a");
    this.width = width;
    this.height = height;
    setPreferredSize(new Dimension(this.width, this.height));
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.clearRect(0, 0, width, height);
    g2d.setBackground(BG_COLOR);

    // draw clock border
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(STROKE_WIDTH));
    g2d.drawOval(STROKE_WIDTH / 2, STROKE_WIDTH / 2, width - STROKE_WIDTH, height - STROKE_WIDTH);

    // draw hour markings
    for (int i = 1; i <= 12; i++) {
      double angle = Math.PI / 6.0 * i;
      Point2D inner = MathUtils.calculatePointOnCircle(width * 0.45, angle + Math.PI, width / 2.0, height / 2.0);
      Point2D outer = MathUtils.calculatePointOnCircle(width * 0.4, angle + Math.PI, width / 2.0, height / 2.0);
      Line2D line = new Line2D.Double(inner, outer);
      g2d.draw(line);
    }

    // get current time
    cal.setTimeInMillis(System.currentTimeMillis());

    // draw minute hand
    g2d.setColor(MINUTE_COLOR);
    g2d.setStroke(new BasicStroke(STROKE_WIDTH));
    double minuteHandAngle = 2 * Math.PI * cal.get(Calendar.MINUTE) / 60.0 - Math.PI / 2.0;
    Point2D minuteHandEnd = MathUtils.calculatePointOnCircle(width * MINUTE_HAND_LENGTH, minuteHandAngle, width / 2.0, height / 2.0);
    Line2D minuteHand = new Line2D.Double(new Point2D.Double(width / 2.0, height / 2.0), minuteHandEnd);
    g2d.draw(minuteHand);

    // draw hour hand
    g2d.setColor(HOUR_COLOR);
    g2d.setStroke(new BasicStroke(STROKE_WIDTH));
    double hourHandAngle = 2 * Math.PI * (cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE) / 60.0) / 12.0 - Math.PI / 2.0;
    Point2D hourHandEnd = MathUtils.calculatePointOnCircle(width * HOUR_HAND_LENGTH, hourHandAngle, width / 2.0, height / 2.0);
    Line2D hourHand = new Line2D.Double(new Point2D.Double(width / 2.0, height / 2.0), hourHandEnd);
    g2d.draw(hourHand);

    // draw current time
    g2d.setColor(Color.BLACK);
    g2d.drawString(sdf.format(cal.getTime()), STROKE_WIDTH / 2, height - STROKE_WIDTH / 2);
  }

 
static class  MathUtils {
  public static Point2D calculatePointOnCircle(double radius, double angle, double originX, double originY) {
    double x = radius * Math.cos(angle) + originX;
    double y = radius * Math.sin(angle) + originY;
    return new Point2D.Double(x, y);
  }
}
}