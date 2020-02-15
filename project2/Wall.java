/** Alex Cohen
 *4/5/18
 *Project 2
 *This class defines a Wall class for a game of Pac-Man
 */

import java.awt.*;
import javax.swing.*;


public class Wall{
  private int centerX_;        //Wall's center x coordinate
  private int centerY_;        //Wall's center y coordinate
  private int width_;          //Wall's width
  private int height_;         //Wall's height
  
  /**
 *Make a wall
 *@param centerX Wall's center x coordinate
 *@param centerY Wall's center y coordinate
 *@param width Wall's width
 *@param height Wall's height
 */
  public Wall(int centerX, int centerY, int width, 
              int height){
    centerX_=centerX;
    centerY_=centerY;
    width_=width;
    height_=height;
  }
  /**
   *returns the x coordinate of the left side of the wall
   *@return the x coordinate of the left side of the wall
   */
  public int getLeft(){
    int left=centerX_-(int)(.5*width_);
    return left;
  }
  /**
     *returns the y coordinate of the top of the wall
     *@return the y coordinate of the top  of the wall
     */
  public int getTop(){
    int top=centerY_-(int)(.5*height_);
    return top;
  }
  /**
   *returns the x coordinate of the left side of the wall
   *@return the x coordinate of the left side of the wall
   */
  public int getRight(){
    int right=centerX_+(int)(.5*width_);
    return right;
  }
  /**
   *returns the y coordinate of the top of the wall
   *@return the y coordinate of the top  of the wall
   */
  public int getBottom(){
    int bottom=centerY_+(int)(.5*height_);
    return bottom;
  }
  /**
   *Paints PacMan according to the direction he is facing
   *@param pacManColor PacMan's color
   *@param shape rounded rectangle will create a rounded rectangle
   */
    public void paint(Color fillColor, Color outlineColor, String shape){

    if(shape.equalsIgnoreCase("rounded rectangle")){
 Paint.setColor(fillColor);
 Paint.fillRoundRect(getLeft(),getTop(),width_, height_, 20, 20);
 Paint.setColor(outlineColor);
 Paint.drawRoundRect(getLeft(),getTop(),width_, height_, 20, 20);
    }  
  }
    public void doAnimateStep(){
    }
}
