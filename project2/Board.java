/** Alex Cohen
 *4/5/18
 *Project 2
 *This class defines a board class for a game of Pac-Man
 */

import java.awt.*;
import javax.swing.*;


public class Board{
    private Wall leftWall_;
    private Wall rightWall_;
    private Wall topWall_;
    private Wall bottomWall_;
    private Wall innerWall1_;
    private Wall innerWall2_;
    private PacMan pacman_;
    private Pellet[] pellets= new Pellet[100]; //the pellets
    Wall[] walls= new Wall[6];
    int bite= 0;
    int animateStepCounter=0;
    Ghost[] ghosts= new Ghost[4]; //the ghosts
    Color ghostColor;
    public Board(){

 
 
 int numPowerPellets=4; //the number of power pellets
 boolean power=true; //true if the pellet is a power pellet
 Pellet p;
 int x=0;
 int y=0;
 for(int i=0; i<pellets.length; i++){
     if(i<=(numPowerPellets-1)){
  power=true;
  if(i==0){
      x = 350;
      y = 700;
  }
    if(i==1){
       x = 500;
      y =700;
  }
      if(i==2){
       x = 200;
       y = 700;
  }
        if(i==3){
       x = 700;
       y = 700;
  }
     }
     else{
  power=false;
  x = (int)(Math.random()*790)+55;
  y = (int)(Math.random()*790)+55;
     }
     
     p= new Pellet(x, y, 10, 10, power);
     pellets[i]=p;
 }
 Ghost g;
 for(int i=0; i<ghosts.length; i++){
    
     g= new Ghost((150*i)+100, 200, 50, 50, true);
     ghosts[i]=g;
}
 
      leftWall_= new Wall(25, 450, 50, 800);
      rightWall_= new Wall(875, 450, 50, 800);
      topWall_= new Wall(450, 25, 900, 50);
      bottomWall_ =new Wall(450, 875, 900, 50); 
      //Inside walls are numbered from left to right starting at 1
      innerWall1_= new Wall(450, 300, 500, 50);
      innerWall2_= new Wall(450, 600, 500, 50);
      pacman_=new PacMan(450,450,50,50, 3, true, Color.YELLOW);


      walls[0]=topWall_;
      walls[1]=rightWall_;
      walls[2]=bottomWall_;
      walls[3]=leftWall_;
      walls[4]=innerWall1_;
      walls[5]=innerWall2_;
      
 

      
    }
    
    public void doAnimateStep(){
 animateStepCounter++;
 Paint.clear();
 
 for(int i=0; i<100; i++){
     pelletOverlap(pellets[i]);
     
     if(pellets[i].getEaten()==false){
     if(pellets[i].getPower()==true){
  pellets[i].paint(true);
     }
     else if(pellets[i].getPower()==false){
  pellets[i].paint(false);
     }
     }
 }

 
 

 
 
 leftWall_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");
 rightWall_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");
 topWall_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");
 bottomWall_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");
 innerWall1_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");
 innerWall2_.paint(Color.BLACK,Color.BLUE,"rounded rectangle");


     pacman_.animatePacMan(pacman_, bite %2,pacman_.getAlive());
     
   for(int i=0; i<=5; i++){
  
       wallOverlap(walls[i]);
   }
   if(pacman_.getStepsRemaining()>0 && animateStepCounter %15==0){
 bite++;
    }
    else if(animateStepCounter %35==0){
 bite++;
    }
    
   if((pacman_.getStepsRemaining())>0){
       pacman_.incrementStepsRemaining();
   }

    for(int i=0; i<ghosts.length; i++){
      
      if(i==0){
   ghostColor=Color.RED;
      }
        if(i==1){
   ghostColor=Color.PINK;
      }
          if(i==2){
   ghostColor=Color.BLUE;
      }
     if(i==3){
   ghostColor=Color.YELLOW;
      }
    
   ghosts[i].paint(ghostColor);
   if(animateStepCounter %3==0){
       if(animateStepCounter %60==0){

  int randomDirection=((int)(Math.random()*4+1));
  ghosts[i].setDirection(randomDirection);
     }
  

  for(int j=0; j<((int)(Math.random()*2+2));j++){
   for(int k=0; k<=5; k++){
  
       ghostWallOverlap(ghosts[i],walls[k]);

       
   }
          ghosts[i].move(1);
   }
       
     
   }


   if(pacmanGhostOverlap(ghosts[i])==true && pacman_.getStepsRemaining()>0 && pacman_.getAlive()==true){
       ghosts[i].setAlive(false);
       }
   else if(pacmanGhostOverlap(ghosts[i])==true && pacman_.getStepsRemaining()<=0&&ghosts[i].getAlive()==true){
       pacman_.setAlive(false);
       break;
       }
   
 }
    
    }

    
    public void pelletOverlap(Pellet pellet){
 if(pacman_.getDirection()==1 && pacman_.getBoxTop()==pellet.getCenterY() 
    && pacman_.getBoxRight()>=pellet.getCenterX() && pacman_.getBoxLeft()<=pellet.getCenterX()&&pellet.getEaten()==false){
     pellet.setEaten(true);
      if(pellet.getPower()==true){
     pacman_.setStepsRemaining();
 }
 }
 
 else if(pacman_.getDirection()==2 && pacman_.getBoxRight()==pellet.getCenterX()
      && pacman_.getBoxTop()<=pellet.getCenterY() && pacman_.getBoxBottom()>=pellet.getCenterY()&&pellet.getEaten()==false){
          pellet.setEaten(true);
      if(pellet.getPower()==true){
     pacman_.setStepsRemaining();
 }
 }
 else if(pacman_.getDirection()==3 && pacman_.getBoxBottom()==pellet.getCenterY() 
  && pacman_.getBoxRight()>=pellet.getCenterX() && pacman_.getBoxLeft()<=pellet.getCenterX()&&pellet.getEaten()==false){
          pellet.setEaten(true);
      if(pellet.getPower()==true){
     pacman_.setStepsRemaining();
 }
 }
 
 else if(pacman_.getDirection()==4 && pacman_.getBoxLeft()==pellet.getCenterX() 
      && pacman_.getBoxTop()<=pellet.getCenterY() && pacman_.getBoxBottom()>=pellet.getCenterY()&&pellet.getEaten()==false){
          pellet.setEaten(true);
      if(pellet.getPower()==true){
     pacman_.setStepsRemaining();
 }
     }
    }
    
    public void wallOverlap(Wall wall){
 if(pacman_.getDirection()==1 && pacman_.getTop()==wall.getBottom() 
      && pacman_.getRight()>=wall.getLeft() && pacman_.getLeft()<=wall.getRight()){
        pacman_.backup(1);

 }
 
 else if(pacman_.getDirection()==2 && pacman_.getRight()==wall.getLeft() 
      && pacman_.getTop()<=wall.getBottom() && pacman_.getBottom()>=wall.getTop()){
     pacman_.backup(1);
 }
 else if(pacman_.getDirection()==3 && pacman_.getBottom()==wall.getTop() 
      && pacman_.getRight()>=wall.getLeft() && pacman_.getLeft()<=wall.getRight()){
     pacman_.backup(1);
 }

 else if(pacman_.getDirection()==4 && pacman_.getLeft()==wall.getRight() 
      && pacman_.getTop()<=wall.getBottom() && pacman_.getBottom()>=wall.getTop()){
     pacman_.backup(1);
 }
    }
    public boolean pacmanGhostOverlap(Ghost ghost){
 int count=0;
 if(pacman_.getDirection()==1 && pacman_.getTop()<=ghost.getBottom() && pacman_.getTop()>=ghost.getTop()
      && pacman_.getRight()>=ghost.getLeft() && pacman_.getLeft()<=ghost.getRight()){

     return true;

 }
 else{count++;}
 
 if(pacman_.getDirection()==2 && pacman_.getRight()>=ghost.getLeft() && pacman_.getRight()<=ghost.getRight()
      && pacman_.getTop()<=ghost.getBottom() && pacman_.getBottom()>=ghost.getTop()){

     return true;
 }
 else{count++;}
 if(pacman_.getDirection()==3 && pacman_.getBottom()>=ghost.getTop() && pacman_.getBottom()<=ghost.getBottom()
      && pacman_.getRight()>=ghost.getLeft() && pacman_.getLeft()<=ghost.getRight()){

     return true;
 }
 else{count++;}

 if(pacman_.getDirection()==4 && pacman_.getLeft()<=ghost.getRight() && pacman_.getLeft()>=ghost.getLeft()
      && pacman_.getTop()<=ghost.getBottom() && pacman_.getBottom()>=ghost.getTop()){

     return true;
 }
 else{count++;}
 if(count==4){
     return false;
 }

 return true;

    }
    
      public void ghostWallOverlap(Ghost ghost, Wall wall){
 if(ghost.getDirection()==1 && ghost.getTop()==wall.getBottom() 
      && ghost.getRight()>=wall.getLeft() && ghost.getLeft()<=wall.getRight()){
        ghost.backup(1); //*************LIKE BATTLESHIP NEED TO CHECK BEFORE MOVING

 }
 
 else if(ghost.getDirection()==2 && ghost.getRight()==wall.getLeft() 
      && ghost.getTop()<=wall.getBottom() && ghost.getBottom()>=wall.getTop()){
     ghost.backup(1);
 }
 else if(ghost.getDirection()==3 && ghost.getBottom()==wall.getTop() 
      && ghost.getRight()>=wall.getLeft() && ghost.getLeft()<=wall.getRight()){
     ghost.backup(1);
 }

 else if(ghost.getDirection()==4 && ghost.getLeft()==wall.getRight() 
      && ghost.getTop()<=wall.getBottom() && ghost.getBottom()>=wall.getTop()){
     ghost.backup(1);
 }
    }
    
    
    public void handleChar(int keypress){
      if(keypress==Paint.UP){
        pacman_.setDirection(1);
      }
      else if(keypress==Paint.RIGHT){
        pacman_.setDirection(2);
      }
      else if(keypress==Paint.DOWN){
        pacman_.setDirection(3);
      }
      else if(keypress==Paint.LEFT){
        pacman_.setDirection(4);
      }
      
    }
}
