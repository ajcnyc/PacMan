import java.awt.*;
import javax.swing.*;

/** Alex Cohen
 *4/5/18
 *Project 2
 *This program allows the user to play a game of Pac-Man.
 */

public class PacManMain{
  
  public static void main( String[] args ){

      Paint.buildWindow("PacManMain", 0, 0, 900, 900, Color.BLACK);

      Paint.setColor(Color.BLUE);
      Paint.setFont("SansSerif",Font.BOLD, 80);
      Paint.drawString("Pac-Man",260,400);
       Paint.setColor(Color.WHITE);
      Paint.setFont("SansSerif",Font.BOLD, 30);
      Paint.drawString("Press any key to continue...",225,500);
      Paint.setColor(Color.YELLOW);
      Paint.fillArc(320,50,250,250,-45,-270);
      Paint.setFont("SansSerif",Font.BOLD, 10);
      Paint.drawString("Made by Alex Cohen",700,800);    
      Paint.getArrow();
      Paint.clear();
      Board board = new Board();
      
      PaintAnimator animator = new PaintAnimator(5);
      animator.animate(board);
      
      for ( ; true ; ) {
   int keypress = Paint.getArrow();
   board.handleChar(keypress);
      }
      
  }
    
}
