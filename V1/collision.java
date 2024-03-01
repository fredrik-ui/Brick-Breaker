public class collision {

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

    public int[] check_ball_list(int windowWidth, int windowHeight, int radius, int posX, int posY, int vy, int vx){

        if(posX<0){
            vx *= -1;
        }else if(posX+radius >= windowWidth){
            vx *=-1;
        }else if(posY < 0){
            vy *= -1;
        }else if(posY+radius >= windowHeight){
            vy *= -1;
        }
        int[] result = {vx, vy};
        return result;
    }

    public int paddle_ball_colide(int rectX, int rectY,int rectWidth, int rectHeight, int radius, int posX, int posY, int vy, int vx){

        if(posY == rectY && (posX >= rectX && rectX+rectWidth >= posX)){
            vy *= -1;
        }

        return vy;
    }

}