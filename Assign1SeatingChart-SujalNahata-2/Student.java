import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This class is universal amongst all student subclasses. Thus, each student class must implement this code.
 * 
 * @author (Sujal Nahata) 
 * @version (2.0)
 */
public abstract class Student extends Actor
{
   //Instance variables
   public String firstName;
   public String lastName;
   public int myRow;         // rows start in the front of class (1), and end in the back of class
   public int mySeat;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
   protected static int numStudents = 0;// variable to use keyboard entry for all the instance of a student
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   
   //  public String imgFile;   // These will be created in subclass as firstName.toLowerCase()+
   public String portraitFile; // image used when sitting
   public String standingFile; // image used when standing
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   public void setRow(int r){
       myRow=r;
   }
   public void setSeat(int s){
       mySeat=s;
   }
   public abstract void  getName(); //This is an abstract methods. You will have to implement it                           // in your own class file. See KilgoreTrout for an example
   public abstract void  answerQuestion(); //This is an abstract method. You will have to implement it
   // in your own class file.
   // Requirement - prompt and accept a question in some fashion.
   // Based on question, give appropriate response.
   // Questions include:
   //    1 What were 3 hard Java topics from summer homework, and why?
   //    2 What were three things that you found interesting about Java from summer homework?
   //    3 What was one syntactical Java construct that you will have to work at to remember, and how?
   //    4 How might you work towards remembering it?
   
   public int GetRow(){
       return myRow;
   }
   public int GetSeat(){
       return mySeat;
   }
   public void sayName(String myNameFile){
       Greenfoot.playSound(myNameFile);
   }
   public void returnToSeat(){
       setLocation(mySeat,myRow);
   }
   public void sitDown(){
       returnToSeat();
       setImage(portraitFile);
       sitting=true;
   }
}
