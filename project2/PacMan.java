import java.awt.*;
import javax.swing.*;

/** Alex Cohen
 *4/5/18
 *Project 2
 *This class defines a PacMan object for a game of Pac-Man
 */

public class PacMan{
    private int centerX_;        //PacMan's center x coordinate
    private int centerY_;        //PacMan's center y coordinate
    private int width_;          //PacMan's width
    private int height_;         //PacMan's height
    private int direction_;      //PacMan's direction 1 up 2 right 3 left 4 down
    private int stepsRemaining_; //number of powered up steps remaining
    private boolean alive_;      //True if PacMan is alive
    private Color color_;        //PacMan's color
    /**
     *Make Pac-Man
     *@param centerX PacMan's center x coordinate
     *@param centerY PacMan's center y coordinate
     *@param width PacMan's width
     *@param height PacMan's height
     *@param direction PacMan's direction 1 up 2 right 3 left 4 down
     *@param alive True if PacMan is alive
     *@param color_ PacMan's color
     */
    public PacMan(int centerX, int centerY, int width, int height,
    int direction, boolean alive, Color color){
 centerX_=centerX;
 centerY_=centerY;
 width_=width;
 height_=height;
 direction_=((int)(Math.random()*4+1));
 stepsRemaining_=0;
 alive_=alive;
 color_=color;
    }
    /**
     *Set whether or not pacman is alive 
     *@param alive whether or not pacman is alive
     */
    public void setAlive(boolean alive){
	alive_=alive;
    }
    /**
     *get whether or not pacman is alive 
     *@return alive_ whether or not pacman is alive
     */
    public boolean getAlive(){
	return alive_;
    }
    public void setStepsRemaining(){
 stepsRemaining_=1000;
    }
     public int getStepsRemaining(){
  return stepsRemaining_;
    }
     public void incrementStepsRemaining(){
  stepsRemaining_--;
    }
    /**
     *returns the x coordinate of the left side of the imaginary square
     *circumscribed around PacMan
     *@return the x coordinate of the left side of the imaginary square
     *circumscribed around PacMan
     */
    public int getLeft(){
 int left=centerX_-(int)(.5*width_);
 return left;
    }
     /**
     *returns the x coordinate of the right side of the imaginary square
     *circumscribed around PacMan
     *@return the x coordinate of the right side of the imaginary square
     *circumscribed around PacMan
     */
    public int getRight(){
 int right=centerX_+(int)(.5*width_);
 return right;
    }
    /**
     *returns the y coordinate of the top of the imaginary square
     *circumscribed around PacMan
     *@return the y coordinate of the top  of the imaginary square
     *circumscribed around PacMan
     */
    public int getTop(){
 int top=centerY_-(int)(.5*height_);
 return top;
    }
     /**
     *returns the y coordinate of the bottom of the imaginary square
     *circumscribed around PacMan
     *@return the y coordinate of the bottom  of the imaginary square
     *circumscribed around PacMan
     */
    public int getBottom(){
 int bottom=centerY_+(int)(.5*height_);
 return bottom;
    }


    /**
     *returns the x coordinate of the left side of the
     *rectangle for PacMan's mouth
     *@return the x coordinate of the left side of the
     *rectangle for PacMan's mouth
     */
    public int getBoxLeft(){
 int boxLeft=(centerX_-(int)(.5*width_))+(width_/7);
 return boxLeft;
    }
     /**
     *returns the x coordinate of the right side of the
     *rectangle for PacMan's mouth
     *@return the x coordinate of the right side of the
     *rectangle for PacMan's mouth
     */
    public int getBoxRight(){
 int boxRight=(centerX_+(int)(.5*width_))-(width_/7);
 return boxRight;
    }
    /**
     *returns the y coordinate of the top of the rectangle for PacMan's mouth
     *@return the y coordinate of the top of the rectangle for PacMan's mouth
     */
    public int getBoxTop(){
 int boxTop=(centerY_-(int)(.5*height_))+(width_/7);
 return boxTop;
    }
     /**
     *returns the y coordinate of the bottom of the rectangle for PacMan's mouth
     *@return the y coordinate of the bottom of the rectangle for PacMan's mouth
     */
    public int getBoxBottom(){
 int boxBottom=(centerY_+(int)(.5*height_))-(width_/7);
 return boxBottom;
    }
    
    
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
     *Set PacMan's direction
     *@param direction PacMan's direction 1 up 2 right 3 left 4 down
     */
    public void setDirection(int direction){
 direction_=direction;
    }
    public int getDirection(){
      return direction_;
    }
    /**
     *Make PacMan move forward
     *@param moveBy the number of pixels that PacMan moves forward by
     */
    public void move(int moveBy){
 if(direction_==1){
     System.out.println("move y1 "+centerY_);
     centerY_=centerY_-moveBy;
     System.out.println("move y2 "+centerY_);
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
      
  
    
    public void paint(Color pacManColor){
 int stAngle; //the starting angle for PacMan's body
 int endAngle;//the ending angle for PacMan's body
 if(direction_==1){
     stAngle=45; endAngle=-270;
 }
 else if(direction_==2){
     stAngle=-45; endAngle=-270;
 }
 else if(direction_==3){
     stAngle=-45; endAngle=270;
 }
 else{
     stAngle=-225; endAngle=-270;
 }
 Paint.setColor(pacManColor);
 Paint.fillArc(getLeft(),getTop(),width_,height_,stAngle,endAngle);
    }

    public void animatePacMan(PacMan pacman_, int bite, boolean alive){
 Paint.setColor(color_);
 if(alive==true){
	if(direction_==1){
      
       centerY_--;
 }
 else if(direction_==2){

   centerX_++;
 }
 else if(direction_==3){

   centerY_++;
 }
 else if(direction_==4){

   centerX_--;
 }
 }
  int stAngle; //the starting angle for PacMan's body
 int endAngle;//the ending angle for PacMan's body

 if(stepsRemaining_>0){
     Paint.setColor(Color.RED);
 }
 
     if(bite==0){
     if(direction_==1){
     stAngle=45; endAngle=-270;
 }
 else if(direction_==2){
     stAngle=-45; endAngle=-270;
 }
 else if(direction_==3){
     stAngle=-45; endAngle=270;
 }
 else{
     stAngle=-225; endAngle=-270;
 }
     }
     else{
  stAngle=0;
  endAngle=360;
 }
 
 
 Paint.fillArc(getLeft(),getTop(),width_,height_,stAngle,endAngle);
 
 if(alive==false){
     Paint.setColor(Color.GRAY);
     Paint.fillArc(getLeft(),getTop(),width_,height_,0,360);
     }
  }

}
