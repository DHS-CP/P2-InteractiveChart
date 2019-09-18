import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The TariqRahman class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class TariqRahman extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the TariqRahman class.
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
    public TariqRahman(String f, String l, int r, int s) {
        firstName=f;
        lastName= l;
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
    public TariqRahman() {
        firstName="Tariq";
        lastName="Rahman";
        myRow=3;
        mySeat=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase() + lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile="tariqrahman.wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the TariqRahman actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * All of the methods that were in the KilgoreTrout class were only modified. As a result, the contents of the act method
     * should not be changed from the original.
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
            
                myHobby("I like to play basketball during my free time!");
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
     * 
     * After enacting changes, the interaction method allows the user to first ask about the hardest summer homework topics, then 
     * utilizes a while loop and flag system to answer several additional questions. The keyword idea was kept the same as the
     * original. However, this class can continue running as the long as the flag holds true (if the user wants to ask an additional
     * question).
     */
   public void answerQuestion(){
        boolean explanation;
        String q=Greenfoot.ask("Hi, what would you like to know.");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort. Would you like to know about my hobbies, favorite interesting lessons, or syntax tendencies?");
            if (q.contains("yes")) {
                explanation = true;
                while (explanation = true) {
                q = Greenfoot.ask("Which would you like to know about?");
                    if (q.contains("hobby")) {
                        q = Greenfoot.ask("My favorite thing to do is play basketball. Would you like to know more about me?");
                        if (q.contains("yes")) {
                            explanation = true;
                        }
                        else {
                            explanation = false;
                            Greenfoot.ask("Thank you.");
                            break;
                        }
                    }
                    if (q.contains("syntax")) {
                        q = Greenfoot.ask("The most common syntax error I ran into is also the most simple: the semicolon at the end of statements. Would you like to learn more about me?");
                        if (q.contains("yes")) {
                            explanation = true;
                        }
                        else {
                            explanation = false;
                            Greenfoot.ask("Thank you.");
                            break;
                        }                        
                    }
                    if (q.contains("interesting")) {
                        q = Greenfoot.ask("The most interesting lessons from the summer homework were also the hardest in some cases: recursion and 2d arrays. I also found conditional statements interesting because of their scalability. Would you like to learn more about me??");
                        if (q.contains("yes")) {
                            explanation = true;
                        }
                        else {
                            explanation = false;
                            Greenfoot.ask("Thank you.");
                            break;
                        }                    
                    }
                }
            }
            else {
                Greenfoot.ask("Thank you, goodbye.");
                Greenfoot.delay(10);
                sitDown();
            }
        }
        else {
          q = Greenfoot.ask("I don't understand the question... May I sit down?"); 
        } 
         if (q.equals("yes")){
            Greenfoot.ask("Thank you, goodbye.");
            Greenfoot.delay(10);
            sitDown();
        }
        
    }
   /**
     * This is a local method specific to the TariqRahman class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
    */ 
   /**
    * Rearrangments on the original circleClass method using a 2d array to model the class map. The initialzied array sets
    * the map and then uses for loops to move the object (my file image) up and down, and to the right. Math random is then
    * used to randomize the angle of the image up to 180 degrees
    */
    public void circleClass(){
        int newRow; 
        int newSeat; 
        int [][] seatMap = new int[8][7]; 
        
        for (int i = 0; i < 8; i++) {
            setRotation((int)(Math.random() * 180));
            for (int t = 0; t < 10; t++) {
                newRow = i;
                newSeat = t;
                Greenfoot.delay(1);
                setLocation(newRow,newSeat);
            }
        }
        for (int t = 7; t >= myRow; t--) {
            setRotation((int)(Math.random() * 180));
            for (int i = 8; i >= mySeat; i--) {
                newRow = i;
                newSeat = t;
                Greenfoot.delay(8);
                setLocation(newRow,newSeat);
            }
        }
        setRotation(0);
       
    }
    //below method print the hobby string to the console.
   public void myHobby(String s) {
         System.out.println(s);
        }
}
