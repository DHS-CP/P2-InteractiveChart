import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Student contains some of the functions used by class GauravAagrwal to return to seat or play a sound
 * This class creates the protected static variable numStudents that inincrements everytime a student is created
 * @author Gaurav Agarwal
 * @version Sep 10, 2019
 */
public abstract class Student extends Actor
{
   public String firstName;
   public String lastName;
   public int myRow;         
   public int mySeat;        
   protected static int numStudents; // creates a variable that is incremented everytime a student is created
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   /**
    * setRow sets the row variable to the value passed through it
    * @param int r (row)
    */
   public void setRow(int r){
       myRow = r;
   }
   /**
    * setSeat sets the seat variable to the value passed through it
    * @param int 2 (seat)
   */
   public void setSeat(int s){
       mySeat = s;
   }
    
   public abstract void  getName(); 
                                 
   public abstract void  answerQuestion(); 
   
   /**
    * GetRow returns the GetRow variable
    * @return myRow (variable)
    */
   public int GetRow(){
        return myRow;
   }
   /**
    * GetRow returns the GetRow variable
    * @return myRow (variable)
   */
   public int GetSeat(){
        return mySeat;
   }
   /**
    * sayName plays a sound file when called
    * @param String myNameFile  is the name of the sound file to play, ex "mySound.wav",
   */
    
   public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
   }
   /**
    * returnToSeat returns the character to the correct spot
    */
   public void returnToSeat(){
        setRotation(0);
        setLocation(mySeat,myRow);
   }
   /**
    * sitDown calls the function to return the character and sets the sitting image 
    */
   public void sitDown(){
        returnToSeat();
        setImage(portraitFile);
        sitting=true;
   }
        
 
}
