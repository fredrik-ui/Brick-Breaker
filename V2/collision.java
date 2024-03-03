public class collision {

    public collision() {
    }

    public int[] check_paddel(int rectX, int rectWidth, int windowWidth){

        int[] result = new int[2]; 

        // Check if moving right will cause collision with the right border
        if (rectX + rectWidth >= windowWidth) {
            result[0] = 2; // Right side collision
            result[1] = windowWidth - rectX - rectWidth; // Calculate remaining pixels
        } 
        // Check if moving left will cause collision with the left border
        else if (rectX <= 0) {
            result[0] = 1; // Left side collision
            result[1] = -rectX; // Calculate remaining pixels
        } 
        return result;
    }

    public int[] check_ball_list(int windowWidth, int windowHeight, int radius, int posX, int posY, int vy, int vx){

        if(posX<0){
            vx *= -1;
        }else if(posX+radius >= windowWidth){
            vx *=-1;
        }else if(posY-radius < 0){
            vy *= -1;
        }else if(posY >= windowHeight){
            vy *= -1;
        }
        int[] result = {vx, vy};
        return result;
    }

    public int paddle_ball_colide(int rectX, int rectY,int rectWidth, int rectHeight, int radius, int posX, int posY, int vy, int vx){
        if(posY >= rectY && (posX >= rectX && rectX+rectWidth >= posX)){
            vy *= -1;
        }

        return vy;
    }

}