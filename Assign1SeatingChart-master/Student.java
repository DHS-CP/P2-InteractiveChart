
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**



 * This class sets all the instance variables for the objects of this class like the SoumyaKakarlapudi
 * class. It also introduces the functions that allow the SoumyaKakarlapudi class to perform all of their
 * functions incorporated in the actor.
 *
 * @Soumya Kakarlapudi
 * @September 11, 2019


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
   public String redboneFile;
   protected static int numStudents = 0;
   Classroom clas = (Classroom) getWorld();



   public void setRow(int r){
       myRow=r;

    }

    public void setSeat(int s){
       mySeat=s;
    }


    public abstract void  getName(); //This is an abstract methods. You will have to implement it

                                     // in your own class file. See KilgoreTrout for an example

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




    public int GetSeat(){

        return mySeat;
    }



    public void sayName(String myNameFile){


        Greenfoot.playSound(soundFile);

    }

    public void returnToSeat(){
        setLocation(mySeat,myRow);

    }

    /**
     * Executes the methods returnToSeat to return the image back to its seat
     * Executes the method setImage to set the image back to the portrait picture
     * Also resets the boolean sitting to true
     */

    public void sitDown(){
        returnToSeat();//returns to seat
        setImage(portraitFile);//returns image to original image
        sitting=true;//boolean for sitting
    }


}
