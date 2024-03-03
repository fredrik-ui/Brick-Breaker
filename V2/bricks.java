import java.util.ArrayList;
import java.awt.*;
public class bricks{

    private int rows = 3;
    //private int index = 0;
    //private int offsetY = 20;


    ArrayList<ArrayList<Integer>> arrayList2D = new ArrayList<>();

    public void create(int x, int y, int rectWidth, int height, int displayWidth) {
        arrayList2D.clear(); // Clear existing data
        //index = 0; // Reset index
        int offsetY = 40;
        for (int i = 0; i < rows; i++) {
            int offsetX = 0;
            while (offsetX < displayWidth) {
                ArrayList<Integer> brick = new ArrayList<>();
                brick.add(10 + offsetX);
                brick.add(offsetY);
                brick.add(rectWidth);
                brick.add(height);
                arrayList2D.add(brick);
                offsetX += 110;
            }
            // Increment offsetY for the next row
            offsetY += height + 20;
        }
        //System.out.println(arrayList2D);
    }

    public int collide(int ballX, int ballY, int radius, int vy){
        for (int i = 0; i < arrayList2D.size(); i++) {
            ArrayList<Integer> brick = arrayList2D.get(i);
            int BposY = brick.get(1);
            if (
                ballY + radius >= BposY && 
                ballY - radius <= BposY + brick.get(3) &&
                ballX >= brick.get(0) &&
                brick.get(0) + brick.get(2) >= ballX
            ) {
                vy *=-1;
                arrayList2D.remove(i);
                break;
            }
        }
        return vy;
    }

    
    public void paint(Graphics g) {
        for (int count = 0; count < arrayList2D.size(); count++) {
            int x = arrayList2D.get(count).get(0);
            int y = arrayList2D.get(count).get(1);
            int w = arrayList2D.get(count).get(2);
            int h = arrayList2D.get(count).get(3);
            g.setColor(Color.blue);
            g.fillRect(x, y, w, h);
        }
    }

}