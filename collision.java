import java.awt.*;
import java.awt.event.*; 

public class collision {

    // Constructor to initialize collision properties
    public collision() {
    }

    public int check_paddel(int rectX, int rectWidth, int windowWidth){

        if(rectX < 0){
            System.out.println("HEJ");
            // Padel should stop
            return 1;
        }else if(rectX+rectWidth >= windowWidth){
            //Paddel should stop
            return 2;
        }

        return 0;

    }

    public int check_ball(int windowWidth, int windowHeight, int ballWidth, int ballHeight, int posX, int posY, int vy, int vx){

        System.out.println(posY);
        if(posX<0){
            
        }else if(posX+ballWidth >= windowWidth){
        
        }else if(posY < 0){
            return vy;
        }else if(posY+ballHeight >= windowHeight){
            return -vy;
        }

        return vy;
    }
    public int[] check_ball_list(int windowWidth, int windowHeight, int ballWidth, int ballHeight, int posX, int posY, int vy, int vx){

        if(posX<0){
            System.out.println("lllllll");
            vx *= -1;
        }else if(posX+ballWidth >= windowWidth){
            System.out.println("fghfg");
            vx *=-1;
        }else if(posY <= 0){
            System.out.println("ASHD");
            vy *= -1;
        }else if(posY+ballHeight >= windowHeight){
            System.out.println("nnnnnnnnn");
            vy *= -1;
        }
        int[] result = {vx, vy};
        return result;
    }
}