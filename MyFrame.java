import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame extends Frame {

    private int rectX = 10;
    private int rectY = 700;
    private int rectWidth = 100;
    private int rectHeight = 50;

    private int windowWidth = 1000;
    private int windowHeight = 800;

    private ball myBall = new ball();
    private collision Collision = new collision();

    public MyFrame() {
        setTitle("Draw Rectangle Example");
        setSize(windowWidth, windowHeight);
        setVisible(true);
        setBackground(Color.GRAY);

        Timer timer = new Timer();

        TimerTask ballMovementTask = new TimerTask() {
            @Override
            public void run() {
                // Update the ball's position based on its current position and any changes
                // You should adjust these parameters based on your requirements
                int List[] = Collision.check_ball_list(getWidth(),getHeight(),myBall.getWidth(),myBall.getHeight(),myBall.getX(), myBall.getY(), myBall.getVelocityY(),myBall.getVelocityX());
                int posY=List[1];
                int posX=List[0];
                System.out.println(myBall.getY() + posY);
                //System.out.println(posX);
                myBall.veleocityX = posX;
                myBall.veleocityY = posY;
                myBall.updatePosition(myBall.getX() - posX, myBall.getY() + posY);


                // int posY = Collision.check_ball(getWidth(),getHeight(),myBall.getWidth(),myBall.getHeight(),myBall.getX(), myBall.getY(), myBall.getVelocityY(),myBall.getVelocityX());
                // myBall.updatePosition(myBall.getX(), myBall.getY() + posY);


                repaint(); // Repaint the frame to reflect the changes
            }
        };

        // Schedule the TimerTask
        timer.scheduleAtFixedRate(ballMovementTask, 0, 10);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        rectY -= 5; // Move the rectangle up
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (Collision.check_paddel(rectX, rectWidth, windowWidth) == 2)
                            rectX += 0;
                        else {
                            rectX += 5; // Move the rectangle right
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (Collision.check_paddel(rectX, rectWidth, windowWidth) == 1)
                            rectX += 0;
                        else {
                            rectX -= 5; // Move the rectangle right
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        rectY += 5; // Move the rectangle down
                        break;
                }
                repaint(); // Repaint the frame to reflect the changes
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        // Set color to blue
        myBall.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(500, 300, 100, 50);
        // g.fillOval(50,50,20,20);

        // Draw rectangle with the specified parameters
        // (x, y, width, height)
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }
}
