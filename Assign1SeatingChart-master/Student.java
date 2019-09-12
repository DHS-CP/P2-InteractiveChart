import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The class "Student" is the parent class of the two child classes of "Student" ("SamikshaYelthimar" and "KilgoreTrout").
 * It contains the abstract class "Student" which is an extension of its parent class "Actor," and defines the instance variables that set up the student's actor. It also sets up how the images will be used in the program.
 * It sets up the basic behavior that will be inherited by the child classes.
 * 
 * @author Samiksha Yelthimar
 * @version 9/11/2019
 */
public abstract class Student extends Actor
{
   //Instance variables
   public String firstName;
   public String lastName;
   public int myRow;         // rows start in the front of class (1), and end in the back of class
   public int mySeat;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
                             // variable to use keyboard entry for all the instance of a student
                             // that we will create?
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   
 //  public String imgFile;   // These will be created in subclass as firstName.toLowerCase()+
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   
   /**
    *  This void method takes in a parameter--an integer--and uses it to set the row in which the student is sitting int.
    *  @param int r - the integer value of the row number
    */
   public void setRow(int r){
       myRow=r;
    }
   
   /**
     *This method sets the value of the mySeat variable based on the integer arguement passed to it
     *@param int s - the integer value of the seat cell number
     */
   public void setSeat(int s){
       mySeat=s;
    }
    
   /**
     * This method retrieves the name of the student
     */ 
   public abstract void  getName(); //This is an abstract methods. You will have to implement it
                                     // in your own class file. See KilgoreTrout for an example
    /**
     * This method, when executed, runs the Q&A session.
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
     * Obtains the row number the actor is in, and returns the value of myRow.
     */
    
    public int GetRow(){
        return myRow;
    }
    
    /**
     * Returns the value of the mySeat variable as an integer
     */
    public int GetSeat(){
        return mySeat;
    }
    
    /**
     * Plays a sound file when called
     * @param String myNameFile  is the name of the sound file to play
     */
    public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
    }
    
    /**
     * Sets the location of the actor to its original position after performing an animation.
     */
    public void returnToSeat(){
        setLocation(mySeat,myRow);
    }
    
    /**
     * Executes the methods returnToSeat to return the image back to its seat
     * Executes the method setImage to set the image back to the portrait picture
     * Also resets the boolean sitting to true 
     */
    public void sitDown(){
        returnToSeat();
        setImage(portraitFile);
        sitting=true;
    }
        
 
}
