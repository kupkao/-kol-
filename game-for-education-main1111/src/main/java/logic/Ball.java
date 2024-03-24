package logic;

import java.awt.*;

public class Ball {
    private Coordinates position;
    private int width;
    private int height;
    private Color color;
    private boolean rendered;

    public Ball(int x, int y, int width, int height, Color color) {
        this.position = new Coordinates(x,y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.rendered = true;
    }

    public int getX() {
        return position.x;
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public int getY() {
        return position.y;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCollided (Rectangle otherObject) {
        Rectangle ballRectangle = getBallRectangle();
        return ballRectangle.intersects(otherObject);
    }


    public Rectangle getBallRectangle () {
        return new Rectangle(this.position.x,this.position.y,width, height);
    }

    public void move(int steps, Direction direction) {
        switch (direction) {
            case LEFT -> {
                this.position.x -= steps;
            }
            case RIGHT -> {
                this.position.x += steps;
            }
            case UP -> {
                this.position.y -= steps;
            }
            case DOWN -> {
                this.position.y += steps;
            }
        }
    }

    public void active() {
        this.rendered = true;
    }

    public void inactive() {
        this.rendered = false;
    }

    public boolean isRendered() {
        return rendered;
    }
}
