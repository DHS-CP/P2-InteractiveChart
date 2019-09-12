import greenfoot.*;

/**
 * The Teacher class is a subclass of the actor class and the parent class of the MrKaehms class
 * It defines behavior that will be inherited by the child class, such as the first and last names of the actor,
 * its location, and when to play the name audiofile.
 * 
 * @author Samiksha Yelthimar 
 * @version 9/11/2019
 */
public abstract class Teacher extends Actor
{
        //Instance variables
   public String firstName;
   public String lastName;
   public static final int myRow=5;         // rows start in the front of class (1), and end in the back of class
   public static final int mySeat=6;        // seats are left to right, 1-8
   
   /**
     * This void method plays sthe audiofile of the actor's name, when the argument is passed in.
     * @param myNameFile - a string variable that is passed in to indicate which audio file to play.
     */
   public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
        
    }
    
   /**
     * This void method will seat the actor back in its original position when it is called.
     */
   public void sitDown(){
        setLocation(mySeat,myRow);
    }
}
