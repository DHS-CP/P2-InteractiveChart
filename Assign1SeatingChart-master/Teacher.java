import greenfoot.*;

/**
 * This class describes attributes of the teacher
 * 
 * @author Parth Joshi
 * @version 09/11/19
 */
public abstract class Teacher extends Actor
{
        //Instance variables
   public String firstName;
   public String lastName;
   public static final int myRow=5;         // rows start in the front of class (1), and end in the back of class
   public static final int mySeat=4;        // seats are left to right, 1-8
   
   /**
    * This method says the name of the teacher
    */
   public void sayName(String myNameFile){
        Greenfoot.playSound(myNameFile);
        
    }
    
   /**
    * This method sits the teacher back down
    */
    public void sitDown(){
        setLocation(mySeat,myRow);
   }
        
 
}
