import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class FreeShape extends Shape{
    ArrayList<LineShape> freeshapes = new ArrayList<>();
      public FreeShape( Color c) {
        super(c);
    }
 public void addLine(int x1,int y1,int x2,int y2,int strokeSize)
         
 {
    
     LineShape ls = new LineShape(x1, y1, x2, y2, c,strokeSize);
     freeshapes.add(ls);
 }
      @Override
    void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        for(LineShape ls:freeshapes)
            ls.draw(g);
    }  
}
