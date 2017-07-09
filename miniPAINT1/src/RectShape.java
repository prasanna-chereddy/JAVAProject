import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import static java.lang.Math.*;

public class RectShape extends Shape {
    
    int tX, tY, w, h,strokeSize;
    boolean isFill;

    public RectShape(int x1, int y1, int x2, int y2, Color c, boolean isFill,int strokeSize) {
        super(x1, y1, x2, y2, c,strokeSize);
        w = abs(x2 - x1);
        h = Math.abs(y2 - y1);
        tX = Math.min(x1, x2);
        tY = Math.min(y1, y2);
        this.isFill = isFill;
        this.strokeSize=strokeSize;
    }

    @Override
    void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        if (isFill) {
            g.fillRect(tX, tY, w, h);
        } else {
            g2d.setStroke(new BasicStroke(strokeSize));
            g.drawRect(tX, tY, w, h);
        }
    }
}
