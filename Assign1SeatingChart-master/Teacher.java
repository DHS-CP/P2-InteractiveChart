import greenfoot.*;

/**
 * Teacher declares the classes to play the sound and sit GauravAgarwal down 
 * 
 * @author Gaurav Agarwal
 * @version Sep 8, 2019
 */
public abstract class Teacher extends Actor
{
   public String firstName;
   public String lastName;
   public static final int myRow = 1;         
   public static final int mySeat = 1;        
   /**
    * sayName plays the sound file that says the name
    * @param String myNameFile (string of sound file)
    */
   public void sayName(String myNameFile) {
        Greenfoot.playSound(myNameFile);
   }
   
   /**
    * sitDown sets the variable to sit down at the correct spot
    */
   public void sitDown() {
        setLocation(mySeat,myRow);
   }
        
 
}
