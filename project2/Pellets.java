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
    private boolean power_;      //Is it a power pellet


    public void paint(){
 width_=10;
 height_=10;
 for (int i=0; i<20; i++){
     centerX_=(int)Math.random()*900;
 centerY_=(int)Math.random()*900;
 Paint.fillOval(centerX_-(int)(.5*width_),centerY_-(int)(.5*height_),width_,height_);
 
    }
}
}
