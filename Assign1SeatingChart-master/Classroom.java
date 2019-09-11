import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
 
/**
 * Classroom prepares the world and sets up the background
 * 
 * @author Gaurav Agarwal
 * @version Sep 10, 2019
 */
public class Classroom extends World
{
    private ArrayList<Object> listo = new ArrayList<Object>();
    
    /**
     * Classroom creates the new world with cells and prepares it
     */
    public Classroom()
    {    
        super(10, 6, 130); 

        prepare();
    }
    
    /**
     * Prepare prepares the world for the start of the program and creates 
     * the initial objects and adds them to the world
     */
    private void prepare()
    {
        GauravAgarwal gauravagarwal = new GauravAgarwal("Gaurav", "Agarwal", 1, 1);
        addObject(gauravagarwal, 1, 1);
        gauravagarwal.sitDown();
    }  
}
