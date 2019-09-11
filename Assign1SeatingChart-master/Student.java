
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This class contains the abstract methods for the student methods.
 * 
 * 
 * @author Parth Joshi
 * @version 09/11/19
 */
public abstract class Student extends Actor
{
   //Instance variables
   public String firstName;
   public String lastName;
   public int myRow;         // rows start in the front of class (1), and end in the back of class
   public int mySeat;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
   protected static int numStudents = 0; // creates a variable that is incremented everytime a student is created.                          
   
                             // variable to use keyboard entry for all the instance of a student
                             // that we will create?
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   
 //  public String imgFile;   // These will be created in subclass as firstName.toLowerCase()+
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   /**
    * This method gets the row of your seat
    */
   public void setRow(int r){
       myRow=r;
    }
    
    /**
    * This method gets the column of your seat
    */
    public void setSeat(int s){
       mySeat=s;
    }
    
    /**
    * This method gets your name
    */
    public abstract void  getName(); //This is an abstract methods. You will have to implement it
                                     // in your own class file. See KilgoreTrout for an example
     
    /**
    * This abstract method is for answering questions
    */                                 
    public abstract void  answerQuestion(); //This is an abstract method. You will have to implement it
                                            // in your own class file.
                                            // Requirement - prompt and accept a question in some fashion.
                                            // Based on question, give appropriate response.
                                            // Questions include:
                                            //    1 What were 3 hard Java topics from summer homework, and why?
                                            //    2 What were three things that you found interesting about Java from summer homework
                                            //    3 What was one syntactical Java construct that you will have to work at to remember, and how
                                            //      might you work towards remembering it?
    /**
     * Plays a sound file when called
     * @param String myNameFile  is the name of the sound file to play, ex "mySound.wav",
     */
    
    public int GetRow(){
        return myRow;
    }
    
    /**
    * This method gets your seat
    */
    public int GetSeat(){
        return mySeat;
    }
    
    /**
    * This method plays your name from the voice file
    */
    public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
    }
    
    /**
    * This method returns the student to his/her seat
    */
    public void returnToSeat(){
        setLocation(mySeat,myRow);
    }
    
    /**
    * This method sits the student down
    */
    public void sitDown(){
        returnToSeat();
        setImage(portraitFile);
        sitting=true;
    }
        
 
}
