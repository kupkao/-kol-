package logic;

import javax.sound.sampled.Line;
import java.awt.*;

public class Wall {
    Coordinates start;
    Coordinates stop;
    Color color;

    public Wall(int x1, int y1, int x2, int y2, Color color) {
        this.start = new Coordinates(x1, y1);
        this.stop = new Coordinates(x2,y2);
        this.color = color;
    }
    public static boolean nevim(Rectangle cg){
        Rectangle lineWall = getLineRectangle();
        return lineWall.intersects(cg);
    }
    public static Rectangle getLineRectangle(){
        return new Rectangle(400,20,1,80);
    }

    public Coordinates getStart() {
        return start;
    }

    public Coordinates getStop() {
        return stop;
    }

    public Color getColor() {
        return color;
    }

}
