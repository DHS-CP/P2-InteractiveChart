import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * This class creates the classroom where everybody is placed. It also instantiates
 * each student in the class.
 * 
 * @author Parth Joshi 
 * @version 09/11/19
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
     * objects and add them to the world.
     */
   
     private void prepare()
    {
        // Add three lines to this doc with your class constructor and your row and seat number
        // Make sure to match your first and last name to the class file you created.

        /* Example */
        ParthJoshi parthjoshi = new ParthJoshi("Parth", "Joshi", 1, 6);
        addObject(parthjoshi, 1, 6);
        parthjoshi.sitDown();
        


    }  
}
