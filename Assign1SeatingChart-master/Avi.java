import greenfoot.*; 
import java.util.Random;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Avi class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class Avi extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the Avi class.
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

    public Avi(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav"; 
        String cover = "cover.png";// Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents ++; 
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public Avi() {
        firstName="Avi";
        lastName="Patel";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
        numStudents ++;
    }
    
     /**
     * Act - do whatever the Avi actor wants to do. This method is called whenever
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
            
                myHobby("I like to sleep");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();
                answerQuestion();
                
                // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
                
                
            }
            Greenfoot.setWorld(new Classroom());      
        }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /*
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void Question() {
    
    
    
    
    
    }
    public void answerQuestion(){
        Random rand = new Random();
        
        String q=Greenfoot.ask("You just learnt about my passions. What else would you like to know about me?");
        
            
        if (q.contains("hard")){
           q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
          
       }
        else if(q.contains("interesting")){
           q=Greenfoot.ask("interfaces, round off error, and inhertiance... May I sit down?");
       }
        else if(q.contains("syntax")){
           q=Greenfoot.ask("declaring constructor, 2d-arrays, including packages... May I sit down?");
       }
       else {
           q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
       }
       if (q.equals("no")){
           q=Greenfoot.ask("What would you like to know");
       }
        
        Greenfoot.delay(10);
        sitDown();  
        
        
    }
    /**
     * This is a local method specific to the Avi class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
       Random rand = new Random();
       int speed = rand.nextInt(3);
       speed = speed * 3 +1;
       
       setLocation(4,3);

       Greenfoot.delay(1);
       
       for (int i=4; i<=9; i++) {
          
          setLocation(i, 3);
          Greenfoot.delay(5);
          
       }
       returnToSeat();
      
       for (int i=5; i<=9; i++) {
          
          
          getWorld().addObject(new cover(), i, 3);
          Greenfoot.delay(5);
          
       }
       
       Greenfoot.delay(10);
       for (int i=4; i>=0; i--) {
          
          setLocation(i, 3);
          
          Greenfoot.delay(5);
        
       }
       returnToSeat();
       for (int i=3; i>=0; i--) {
          
          
          getWorld().addObject(new cover(), i, 3);
          Greenfoot.delay(5);
        
       }
    
       setImage(portraitFile);
       
       
       Greenfoot.delay(50);
       for (int i=0; i<=143; i++) {
           turn(15);
           Greenfoot.delay(speed);
       }
       
       
       
       
       for (int i=0; i<=2; i++) {
          
          
          getWorld().addObject(new cover(), i, 1);
          Greenfoot.delay(5);
          
       }
       for (int i=7; i<=9; i++) {
          
          
          getWorld().addObject(new cover(), i, 1);
          Greenfoot.delay(5);
          
       }
       for (int i=0; i<=9; i++) {
          
          
          getWorld().addObject(new cover(), i, 2);
          Greenfoot.delay(5);
          
       }
      
       for (int i=0; i<=9; i++) {
          
          
          getWorld().addObject(new cover(), i, 4);
          Greenfoot.delay(5);
          
       }
       for (int i=0; i<=9; i++) {
          
          
          getWorld().addObject(new cover(), i, 5);
          Greenfoot.delay(5);
          
       }
       
       String myTwoDimensionalStringArray[][] = new String[4][];
       myTwoDimensionalStringArray[0] = new String[] {"img1.jpg", "img2.jpg", "img3.jpg", "img4.jpg"};
       myTwoDimensionalStringArray[1] = new String[] {"text1.png", "text2.png", "text3.png", "text4.png"};
       for (int i = 3; i <= 6; i++) {
           int index = (i-3);
           String s = myTwoDimensionalStringArray[0][index];
           setImage(s);
           setLocation(i, 1);
           Greenfoot.delay(70);
           String t = myTwoDimensionalStringArray[1][index];
           setImage(t);
           Greenfoot.delay(70);
        }
       setImage(portraitFile);
       returnToSeat();
       sitDown();
           
    }
    
    
     public void myHobby(String s) {
         System.out.println(s);
     }
}


