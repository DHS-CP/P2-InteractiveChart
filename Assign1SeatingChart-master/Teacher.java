import greenfoot.*;

/**
 * This class contains instance variables and allows the studnet to sit at their seat and say their name from the student class. 
 * 
 * @Soumya Kakarlapudi 
 * @September 11, 2019 (a version number or a date)
 */
public abstract class Teacher extends Actor
{
        //Instance variables
   public String firstName;
   public String lastName;
   public static final int myRow=5;         // rows start in the front of class (1), and end in the back of class
   public static final int mySeat=4;        // seats are left to right, 1-8
   
   public void sayName(String myNameFile){
        //Greenfoot.playSound(myNameFile);
        
    }
    
    public void sitDown(){
        setLocation(mySeat,myRow);
    }
        
 
}
