import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineShape extends Shape{
      public LineShape(int x1, int y1, int x2, int y2, Color c,int strokeSize) {
        super(x1, y1, x2, y2, c,strokeSize);
    }

      @Override
    void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
       g2d.setStroke(new BasicStroke(strokeSize));
        g2d.drawLine(x1, y1, x2, y2);
    }  
}
