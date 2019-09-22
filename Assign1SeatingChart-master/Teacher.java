import greenfoot.*;

/**

 * This class contains instance variables and allows the studnet to sit at their seat and say their name from the student class.
 *
 * @Soumya Kakarlapudi
 * @September 11, 2019 (a version number or a date)


 */
public abstract class Teacher extends Actor
{
   public String firstName;
   public String lastName;
   
   public static final int myRow=5;         // rows start in the front of class (1), and end in the back of class

   public static final int mySeat=6;        // seats are left to right, 1-8

   /**
     * This void method plays sthe audiofile of the actor's name, when the argument is passed in.
     * @param myNameFile - a string variable that is passed in to indicate which audio file to play.
     */

   public void sayName(String myNameFile){
        //Greenfoot.playSound(myNameFile);

    }

   /**
     * This void method will seat the actor back in its original position when it is called.
     */
   public void sitDown(){
        setLocation(mySeat,myRow);
    }

}
