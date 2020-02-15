/** Alex Cohen
 *4/5/18
 *Project 2
 *This class defines a Pellets class for a game of Pac-Man
 */

import java.awt.*;
import javax.swing.*;

public class Pellet{

    private int centerX_;        //Pellet's center x coordinate
    private int centerY_;        //Pellet's center y coordinate
    private int width_;          //Pellet's width
    private int height_;         //Pellet's height
    private boolean power_;      //Is it a power pellet?
    private boolean eaten_;      //Has PacMan chomped it yet?
    


    public Pellet(int centerX, int centerY, int width, int height, boolean power){
      centerX_=centerX;
      centerY_=centerY;
      width_=width;
      height_=height;
      power_=power;
      eaten_=false;
    }
    public boolean getPower(){
	return power_;
    }
    public int getCenterX(){
	return centerX_;
    }
    public int getCenterY(){
	return centerY_;
	}
     public void setEaten(boolean eaten){
	eaten_=eaten;
    }
    public boolean getEaten(){
	return eaten_;
    }
    public void paint(boolean power){
      if(power==true){
        Paint.setColor(Color.RED);
      }
      else{
        Paint.setColor(Color.WHITE);
      }
      Paint.fillOval(centerX_-(int)(.5*width_),centerY_-(int)(.5*height_),width_,height_);     
    }


}

