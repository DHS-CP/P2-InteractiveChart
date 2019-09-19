import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Model that represents AravV position in the  class seating chart
 * 
 * @Arav Vyawahare
 * @9/15/2019 
 */
public class AravV extends Student
{
    /**
     * Constructor for the AravV class.
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
    
    public AravV(String f, String l, int r, int s) {
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
    public AravV() {
        firstName="Arav";
        lastName="Vyawahare";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    //Number of students class
    public void numberStudents(){
        numStudents += 1;
    }
    /**
     * Act which does what the AravV actor does
     * Method called when button gets pressed.
     * Used to show hard topics.
     */
    public void act() 
    {
        // Action code which does the dialogue
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play basketball.");
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
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
        
            String hard[] = {"2d Arrays", "Abstract Classes", "Recursion", "Merge Sorting", "Insertion Sort"};
            String hard2[] = {"2d Arrays took time to get used to, but I eventually got it!", "Abstract Classes were weird, but not extremely hard to understand.", "Recursion was the most difficult topic over the summer.", "Merge Sorting was a pain, but I got the hang of it.", "Insertion Sort was a pretty easy algorithm to learn, but it's not as efficient as merge sorting"};
            
             String q2=Greenfoot.ask("2d Arrays, Abstract Classes, Recursion, Merge Sorting, Insertion Sort ...Which topic would you like to know more about?");
            
            String q3 = "yes"; // Initialize answer to q3 with yes
            
            // Specific topics are listed
            if(q2.contains("2d arrays")) {
                q3 = Greenfoot.ask(hard2[0] + " ...May I sit down now?");
            }
            else if(q2.contains("abstract classes")) {
                q3 = Greenfoot.ask(hard2[1] + " ...May I sit down now?");
            }
            else if(q2.contains("recursion")) {
                q3 = Greenfoot.ask(hard2[2] + " ...May I sit down now?");
            }
            else if(q2.contains("merge sorting")) {
                q3 = Greenfoot.ask(hard2[3] + " ...May I sit down now?");
            }
            else if(q2.contains("insertion sort")) {
                q3 = Greenfoot.ask(hard2[4] + " ...May I sit down now?");
            }
            else {
                q3 = Greenfoot.ask("I don't understand " + "...May I sit down now?");
            }
                if (q3.contains("yes")) {
                    Greenfoot.delay(10);
                    sitDown();
                }
        }
        else if (q.contains("students")){
             q=Greenfoot.ask("There are " + numStudents + " students in the class. May I sit down now?");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
         }
         else if (q.equals("no")){
             answerQuestion();
            }
         else {
            }
    }
    
    /**
     * Animation class for AravV
     * Using a 2D array and random number generator to teleport around
     */
    public void circleClass(){
        Greenfoot.delay(150);
        setLocation(3,0);
        
         
         
        //2D Array and Random Number Generator 
        int [][] grid = new int [6][4];
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[i].length; x++) {
                grid[i][x] = (int)(Math.random());
            }
        
            
        }    
        
        for (int i=1; i <= 6; i++) {
            Greenfoot.playSound("teleport.mp3");
            setLocation(0,i);
            turn(20);
            Greenfoot.delay(10);
        }
        
        for (int i=1; i <= 6; i++) {
            Greenfoot.playSound("teleport.mp3");
            setLocation(4,i);
            turn(20);
            Greenfoot.delay(10);
        }
        
        for (int i=1; i <= 6; i++) {
            Greenfoot.playSound("teleport.mp3");
            setLocation(2,i);
            turn(20);
            Greenfoot.delay(10);
        }
        
        for (int i=1; i <= 6; i++) {
            Greenfoot.playSound("teleport.mp3");
            setLocation(1,i);
            turn(20);
            Greenfoot.delay(10);
        }
         
        
         
        
        returnToSeat();
        turn(240);
    }
    
    /**
    * This method uses the SpecialInterestOrHobby interface to print my hobby in the console
    */
     public void myHobby(String s) {
         System.out.println(s);
}

}
