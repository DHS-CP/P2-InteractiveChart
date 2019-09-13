import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The VikasUmmadisetty class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Vikas Ummadisetty
 * @version 2.0 Sept 11, 2019
 */
public class VikasUmmadisetty extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{

    /**
     * Constructor for the VikasUmmadisetty class.
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
    
    
    public VikasUmmadisetty(String f, String l, int r, int s) {
        firstName=f;        // Sets first name to f parameter
        lastName=l;         // Sets last name to l parameter
        myRow=r;            // Sets row number to r parameter
        mySeat=s;           // Sets seat number to s parameter
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // refers to image file as firstnamelastname.jpg
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";   // refers to standing image file as firstnamelsatname-standing.jpg
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);     // Sets the image to the sitting image
        sitting=true;               // Sets sitting variable to true
        numStudents++;              // increments number of students by one
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public VikasUmmadisetty() {
        firstName="Vikas";          // Sets first name to Vikas by default
        lastName="Ummadisetty";     // Sets last name to Ummadisetty by default
        myRow=1;                    // Sets row number to 1 by default
        mySeat=1;                   // Sets first name to l by default
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";             // refers to image file as firstnamelastname.jpg
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";    // refers to standing image file as firstnamelsatname-standing.jpg
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";               // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);     // Sets the image to the sitting image
        sitting=true;               // Sets sitting variable to true
        numStudents++;              // increments number of students by one
    }
    
     /**
     * Controls the user interaction with the mouse click to run animations and dialogue sessions
     */   
    public void act() 
    {

        if(Greenfoot.mouseClicked(this)){       // When mouse is clicked on VikasUmmadisetty
            if (sitting){                       
                sitting=false;          // turn off standing
                setImage(standingFile); // set image to standing file
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();              // Call getName method
                sayName(soundFile);     // Play sound file of name
            
                myHobby("I like to make robots.");
                
                moveAround();
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
     * Allows user to interact with the student through a question and answer  interface and provides user the ability to instruct
     * object to sit down. User can ask questions about hard topics over summer hw and number of students in the class
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");  // 
        if (q.contains("hard")){

            String hardTopics[] = {"recursions", "2d arrays", "merge sorting", "abstract classes", "interfaces"};   // declare an array of hard topics
            
            // Declares an array of messages for further dialogue corresponding to array hardTopics
            String hardTopicsDialogue[] = {"Recursions were a headache to understand! I actually had to write the logic on paper to understand how the call stack works.", 
                "I always forget the syntax to initialize a 2D array!", "Merge sorting was pretty intuitive but hard to implement in code.", 
                "Abstract classes were an interesting concept that I had not been exposed to previously.", 
                "Intefaces are like contracts in a way. They specify what methods and member variables should be defined in the class."
            };
            
            // Start further dialogue about hard topics
            String q2=Greenfoot.ask("recusions, 2d arrays, merge sorting, abstract classes, and interfaces... Which topic would you like to know more about?");
            
            String q3 = "yes"; // Initialize answer to q3 with yes
            
            // Start further dialogue about what topics user wants to know more about
            if(q2.contains("recursion")) {
                q3 = Greenfoot.ask(hardTopicsDialogue[0] + " May I sit down now?");
            }
            else if(q2.contains("array")) {
                q3 = Greenfoot.ask(hardTopicsDialogue[1] + " May I sit down now?");
            }
            else if(q2.contains("merge")) {
                q3 = Greenfoot.ask(hardTopicsDialogue[2] + " May I sit down now?");
            }
            else if(q2.contains("abstract")) {
                q3 = Greenfoot.ask(hardTopicsDialogue[3] + " May I sit down now?");
            }
            else if(q2.contains("interface")) {
                q3 = Greenfoot.ask(hardTopicsDialogue[4] + " May I sit down now?");
            }
            
            // if user allows VikasUmmadisetty to sit down
            if(q3.contains("yes")) {
                sitDown();
            }
            
        }
        // if user asks about how many students, outputs number of students in class
        else if(q.contains("students")) {
            q=Greenfoot.ask("There are " + numStudents + " students in the class. May I sit down now?");
        }
        // if no question matches cases, asks to sit down
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
          if(q.contains("yes")) sitDown();
        }
        
        
    }
    /**
     * Animation method that makes original Kilgore Trout object move. Mostly kept for reference
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
           Greenfoot.delay(20);
           returnToSeat();
    }
    /**
     * Defines animation for main movements of VikasUmmadisetty object. Randomly generates coordinates for object to move at a fast rate of 1 ms per movement while spinning and randomly changing size.
     * Then sets object back to original position and changes picture to standing file
     */
    public void moveAround() {
        setLocation(4,3);       // Intialize position of object at 4,3
        Greenfoot.delay(10);    // Have a short delay before beginning animation 
        
        int [][] twodarray= new int [1000][2];  // Declare and initialize a 2D array that is 1000 x 2
        twodarray[0][0] = 4;                    // Initialize first x coordinate to 4
        twodarray[0][1] = 3;                    // Initialize first y coordinate to 3
        
        GreenfootImage originalImage = getImage();  // Get image of current image
        int originalWidth = originalImage.getWidth();   // store original width of image
        int originalHeight = originalImage.getHeight(); // store original height of image
        
        // Loops 999 times to initialize values of 2D array
        for(int i=1; i<=999; i++) {
            // Randomly generate -1 or 1 to add it to the previous item in 2D array for both x and y coordinate
            twodarray[i][0] = (twodarray[i-1][0] + ((Math.random() > 0.5) ? 1 : -1));
            twodarray[i][1] = twodarray[i-1][1] + ((Math.random() > 0.5) ? 1 : -1);
            
            if(twodarray[i][0] > 9) twodarray[i][0] = 9;   // Max boundary for x coordinate
            if(twodarray[i][0] < 0) twodarray[i][0] = 0;   // Min boundary for x coordinate
            if(twodarray[i][1] > 5) twodarray[i][1] = 5;   // Max boundary for y coordinate
            if(twodarray[i][1] < 0) twodarray[i][1] = 0;   // Min boundary for y coordinate
            
            //System.out.println(twodarray[i][0] + " " + twodarray[i][1]);    // Print coordinates to console for debugging
            
        }
        
        // Loops 1000 times to set position based on 2D array values
        for(int i=0; i<=999; i++) {
            turn(20);                                       // Turns image 20 degrees per increment
            GreenfootImage image = getImage();              // Get image in GreenfootImage object
            int scale = ((Math.random() > .5) ? 5 : -5);    // Randomly choose -5 or 5
            int newWidth = image.getWidth() + scale;        // Scale width based on random increment
            int newHeight = image.getHeight() + scale;      // Scale height based on random increment
            if(newWidth < 20) newWidth = 20;                // Min boundary for width
            if(newHeight < 20) newHeight = 20;              // Min boundary for height
            if(newWidth > 1000) newWidth = 1000;            // Max boundary for width
            if(newHeight > 1000) newHeight = 1000;          // Max boundary for height
            
            image.scale(  newWidth, newHeight);     // scale image to new width and height 
            setImage(image);                        // set image to new dimensions
            setLocation(twodarray[i][0], twodarray[i][1]);  // set location of random coordinate
            Greenfoot.delay(1);                     // Delay animation by 1 ms
        }
        setRotation(0);     // Return rotation back to normal
        originalImage.scale(originalWidth, originalHeight); 
        setImage(standingFile);
        returnToSeat();
        
    }
    /**
    * Prints my hobby from SpecialInterest or Hobby Interface
    */
     public void myHobby(String s) {
         System.out.println(s);
}
    /**
    * Returns the total number of siblings from NumberofSiblings interface
    * @return int number of siblings
    */
    public int numberOfSiblings() {
        return 1;
    }
    /**
    * Returns the total number of brothers from NumberofSiblings interface
    * @return int number of brothers
    */
    public int numberOfBrothers() {
        return 0;
    }
    /**
    * Returns the total number of sisters from NumberofSiblings interface
    * @return int number of sisters
    */
    public int numberOfSisters() {
        return 1;
    }

}
