/** Alex Cohen
 *4/5/18
 *Project 2
 *This class defines ghost objects for a game of Pac-Man
 */

import java.awt.*;
import javax.swing.*;

public class Ghost{

    private int centerX_;        //ghost's center x coordinate
    private int centerY_;        //ghost's center y coordinate
    private int width_;          //ghost's width
    private int height_;         //ghost's height
    private int direction_;      //ghost's direction 1 up 2 right 3 left 4 down
    private boolean alive_;      //True if ghost is alive

     /**
     *Makes a new ghost
     * @param centerX the ghost's ceenter X coordinate
     * @param centerY the ghost's ceenter Y coordinate
     * @param width ghost's width
     * @param height ghost's height
     * @param alive is the ghost alive?
     */
    public Ghost(int centerX, int centerY, int width, int height,
    boolean alive){
 centerX_=centerX;
 centerY_=centerY;
 width_=width;
 height_=height;
 alive_=alive;
    }

    /**
     *Make ghost move back a space
     */
    public void backup(int moveBy){
 if(direction_==1){
     centerY_=centerY_+moveBy;
 }
 else if(direction_==2){
     centerX_=centerX_-moveBy;
 }
 else if(direction_==3){
     centerY_=centerY_-moveBy;
 }
 else if(direction_==4){
     centerX_=centerX_+moveBy;
 }
    }
     /**
     *Set whether or not the ghost is alive 
     *@param alive whether or not the ghost is alive
     */
    public void setAlive(boolean alive){
 alive_=alive;
    }
     /**
     *get whether or not the ghost is alive 
     *@return alive_ whether or not the ghost is alive
     */
    public boolean getAlive(){
 return alive_;
    }
    /**
     *Set ghost's direction
     *@param direction ghost's direction 1 up 2 right 3 left 4 down
     */
    public void setDirection(int direction){
 direction_=direction;
    }
     /**
     *Get ghost's direction
     *@return direction_ ghost's direction 1 up 2 right 3 left 4 down
     */
    public int getDirection(){
      return direction_;
    }
    /**
     *Make ghost move forward
     *@param moveBy the number of pixels that the ghost moves forward by
     */
    public void move(int moveBy){
 if(alive_==true){
 if(direction_==1){
     centerY_=centerY_-moveBy;
 }
 else if(direction_==2){
     centerX_=centerX_+moveBy;
 }
 else if(direction_==3){
     centerY_=centerY_+moveBy;
 }
 else if(direction_==4){
     centerX_=centerX_-moveBy;
 }
 }
    }
     /**
     *returns the x coordinate of the left side of the imaginary square
     *circumscribed around the ghost
     *@return the x coordinate of the left side of the imaginary square
     *circumscribed around the ghost
     */
    public int getLeft(){
 int left=centerX_-(int)(.5*width_);
 return left;
    }
    /**
     *returns the y coordinate of the top of the imaginary square
     *circumscribed around the ghost
     *@return the y coordinate of the top  of the imaginary square
     *circumscribed around the ghost
     */
    public int getTop(){
 int top=centerY_-(int)(.5*height_);
 return top;
    }
     /**
     *returns the x coordinate of the right side of the imaginary square
     *circumscribed around the ghost
     *@return the x coordinate of the right side of the imaginary square
     *circumscribed around the ghost
     */
    public int getRight(){
 int right=centerX_+(int)(.5*width_);
 return right;
    }
     /**
     *returns the y coordinate of the bottom of the imaginary square
     *circumscribed around the ghost
     *@return the y coordinate of the bottom  of the imaginary square
     *circumscribed around the ghost
     */
    public int getBottom(){
 int bottom=centerY_+(int)(.5*height_);
 return bottom;
    }
    /**
     *Paints the ghost according to the direction he is facing
     */
    public void paint(Color ghostColor){
 if(alive_==true){
 Paint.setColor(ghostColor);
 }
 else if(alive_==false){
     Paint.setColor(Color.GRAY);
 }
 Paint.fillRoundRect(getLeft(),getTop(),width_,height_,100,100);
 Paint.fillRoundRect(getLeft(),(getTop()+((int)(.5*height_))),
       width_,(int)(.5*height_),0,0);
 
   //fancier graphics can be added here
   Paint.setColor(Color.WHITE);
   Paint.fillRoundRect(getLeft()+(width_/5),getTop()+(height_/5),(width_/5),(height_/5),100,100);
   Paint.fillRoundRect(getLeft()+3*(width_/5),getTop()+(height_/5),(width_/5),(height_/5),100,100);
    }
}
