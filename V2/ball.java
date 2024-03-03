import java.awt.*;

public class ball{
    
    public int veleocityY = 4;
    public int veleocityX = 2;
    private int x = 50;
    private int y = 600;
    private int radius = 20;

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

    public int getRadius() {
        return radius;
    }
    public int getVelocityY() {
        return veleocityY;
    }
    public int getVelocityX() {
        return veleocityX;
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x,y,radius,radius);
    }

}