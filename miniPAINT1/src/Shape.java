import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.*;
public abstract class Shape implements Serializable{
  
    int x1, y1, x2, y2,strokeSize;
    Color c;

    public Shape(int x1, int y1, int x2, int y2, Color c,int strokeSize) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
        this.strokeSize=strokeSize;
    }

    public Shape(Color c) {
        this.c = c;
    }
    
    
    
    void draw(Graphics g){
        
    }
    
}
