import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The ParthJoshi class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Parth
 * @version 09/11/19
 */
public class ParthJoshi extends Student implements SpecialInterestOrHobby,NumberOfSiblings
{
    
    /**
     * Constructor for the ParthJoshi class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public ParthJoshi(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
     public ParthJoshi() {
        firstName="Parth";
        lastName="Joshi";
        myRow=1;
        mySeat=6;
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Act - do whatever the ParthJoshi actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to teach children science. I do this by volunteering at a museum.");
                numberOfSiblings("I have one sibling.");
                numberOfBrothers("I have no brothers.");
                numberOfSisters("My sibling is my one younger sister whom I love very much. ");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    /**
    * This method incriments the numStudents variable by 1 to calculate the number of 
    * students in the class.
    */
    public void numberStudents(){
        numStudents+= 1;
    }
    /**
     * Prints the first and last name to the console
     */
     public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends. 
     * Allows you to further elaborate on certain topics and ask about number of students
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, Recursion, Interfaces, Insertion Sort, and Overriding Methods. Anything Specific you would like to know about?");
            if (q.contains("2D array")){
                String a=Greenfoot.ask("2D arrays were hard for me because iterating through them with a for loop was complex. Now that I am using them often, I understand them better.... May I sit down?"); 
                if (a.contains("yes")){
                    sitDown();
                    }
                else{
                    sitDown();
                    }
            }
            else if (q.contains("Recursion")){
                String b=Greenfoot.ask("Recursion was hard for me because exiting a recursive loop was hard to understand.After I figured out how to create an exiting statement, My understanding of this concept increased... May I sit down?"); 
                if (b.contains("yes")){
                    sitDown();
                    }
                else{
                    sitDown();
                    }
            }
            else if (q.contains("Interfaces")){
                String c=Greenfoot.ask("I didn't understand the difference between interfaces and abstract classes but thinking of an interface like a list of things to do helped me understand.... May I sit down?"); 
                if (c.contains("yes")){
                    sitDown();
                    }
                else{
                    sitDown();
                    }
            }
            else if (q.contains("Insertion Sort")){
                String d=Greenfoot.ask("I didn't understand how the insertion sort worked but after watching an animation of the sort at work I understood.... May I sit down?"); 
                if (d.contains("yes")){
                    sitDown();
                    }
                else{
                    sitDown();
                    }
            }
            else if (q.contains("Overriding Methods")){
                String e=Greenfoot.ask("I didn't understand the way inheritance effected the way a method was overided but after looking deeper into class hierarchy I understood... May I sit down?"); 
                if (e.contains("yes")){
                    sitDown();
                    }
                else{
                    sitDown();
                    }
            }
            else{String r=Greenfoot.ask("I don't understand the question... May I sit down?"); 
                 if (r.contains("yes")){
                    sitDown();
                    }
                 else{
                    sitDown();
                    }
            }
        }
        else if (q.contains("students")){
            numberStudents();
            String r=Greenfoot.ask("There are "+numStudents+" students in our class.... May I sit down?");
            if (r.contains("yes")){
                 sitDown();
                    }
          else{
                 sitDown();
                    }
        }   
        else {
          String p=Greenfoot.ask("May I sit down?"); 
          if (p.contains("yes")){
                 sitDown();
                    }
          else{
                 sitDown();
                    }
        }
        
    }
    /**
     * This is a local method specific to the ParthJoshi class used to animate the character once the image is clicked on.
     * 
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(10);
        
        
        int [][] grid = new int [10][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = (int)(Math.random()*7);
            }
        }
         
        for (int i=1;i<=5;i++){
            setLocation(0,i);
            turn(24);
            Greenfoot.delay(5);
        }   
        
        for (int i=1;i<=9;i++){
            setLocation(i,5);
            turn(24);
            Greenfoot.delay(5);
        }      
        
        for (int i=5;i>=0;i--){
            setLocation(9,i);
            turn(24);
            Greenfoot.delay(5);
        }   
        
        for (int i=9;i>=0;i--){
            setLocation(i,0);
            turn(24);
            Greenfoot.delay(5);
        }
        Greenfoot.delay(20);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                setLocation(grid[i][0],grid[i][1]);
                Greenfoot.delay(10);
            }
        }
        returnToSeat();
    }
    /**
    * This method uses the SpecialInterestOrHobby interface to print my hobby in the console
    */
     public void myHobby(String s) {
         System.out.println(s);
    }
    /**
    * Uses the NumberOfSiblings interface to print the number of siblings I have
    */
     public void numberOfSiblings(String s) {
         System.out.println(s);
    }
    /**
    * Uses the NumberOfSiblings interface to print the number of Brother I have
    */
     public void numberOfBrothers(String s) {
         System.out.println(s);
    }
    /**
    * Uses the NumberOfSiblings interface to print the number of Sisters I have
    */
     public void numberOfSisters(String s) {
         System.out.println(s);
    }

}
