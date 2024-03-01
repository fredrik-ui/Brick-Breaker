import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBallPosition();
                repaint();
            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPress(e);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void updateBallPosition(){
        int posY;
        int posX;
        // Check if ball collides with the walls
        int List[] = Collision.check_ball_list(
            getWidth(),
            getHeight(),
            myBall.getRadius(),
            myBall.getX(), 
            myBall.getY(), 
            myBall.getVelocityY(),
            myBall.getVelocityX()
        );
        posY=List[1];
        posX=List[0];

        // Check if ball collides with paddle
        if(
            Collision.paddle_ball_colide(
                rectX,
                rectY,
                rectWidth,
                rectHeight,
                myBall.getRadius(),
                myBall.getX(), 
                myBall.getY(), 
                myBall.getVelocityY(),
                myBall.getVelocityX()
            ) == (myBall.veleocityY*-1)
        ){
            posY = (myBall.veleocityY*-1);
        }

        myBall.veleocityX = posX;
        myBall.veleocityY = posY;
        myBall.updatePosition(myBall.getX() - posX, myBall.getY() + posY);

    }

    public void KeyPress(KeyEvent e){
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



    public void paint(Graphics g) {
        // Create an off-screen buffer
        // Based on this link: https://www.ecst.csuchico.edu/~akeuneke/classes/csciOOP/double-buffering.html
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics offscreenGraphics = offscreen.getGraphics();
    
        // Draw on the off-screen buffer
        myBall.paint(offscreenGraphics);
        offscreenGraphics.setColor(Color.BLUE);
        int x = 0;
        while (x < windowWidth) {
            offscreenGraphics.fillRect(10 + x, 300, 100, 50);
            x += 110;
        }
        offscreenGraphics.fillRect(rectX, rectY, rectWidth, rectHeight);
    
        // Draw the off-screen buffer onto the screen
        g.drawImage(offscreen, 0, 0, this);
    }
}
