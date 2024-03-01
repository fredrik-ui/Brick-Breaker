import java.awt.*;
import java.awt.event.*; 

public class ball{
    
    public int veleocityY = 10;
    public int veleocityX = 2;
    private int x = 50;
    private int y = 600;
    private int width = 20;
    private int height = 20;

    public void updatePosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getVelocityY() {
        return veleocityY;
    }
    public int getVelocityX() {
        return veleocityX;
    }
    public void paint(Graphics g) {
        // Set color to blue
        g.setColor(Color.red);
        //g.fillRect(500,300,100,50);
        g.fillOval(x,y,width,height);


    }
}