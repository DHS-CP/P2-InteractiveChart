import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * This class sets up the Classroom for all of the student classes to be in. It initalizes a world and adds the students
 * as the variables. This creates a world with restrictions for sizing. 
 * 
 * @Soumya Kakarlapudi 
 * @September 11, 2019
 */
public class Classroom extends World
{
    private ArrayList<Object> listo = new ArrayList<Object>();
    /**
     * Constructor for objects of class Classroom.
     * 
     */
    public Classroom()
    {    
        // Create a new world with 10x6 cells with a cell size of 130x130 pixels.
        super(10, 6, 130); 

        prepare();
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world. This incorporates the SoumyaKakarlapudi class. 
     */
   
     private void prepare()
    {
        // Add three lines to this doc with your class constructor and your row and seat number
        // Make sure to match your first and last name to the class file you created.

        /* Example */
        SoumyaKakarlapudi soumyakakarlapudi = new SoumyaKakarlapudi("Soumya", "Kakarlapudi", 1, 7);
        addObject(soumyakakarlapudi, 1, 7);
        soumyakakarlapudi.sitDown();
         
        


    }  
}
