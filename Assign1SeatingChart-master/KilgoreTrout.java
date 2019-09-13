import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class KilgoreTrout extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KilgoreTrout class.
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
    public KilgoreTrout(String f, String l, int r, int s) {
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
    public KilgoreTrout() {
        firstName="Kilgore";
        lastName="Trout";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
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
            
                myHobby("I like to time travel!");
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
        String q=Greenfoot.ask("What did you find challenging about the AP Computer Science Summer Homework?");
        if (q.contains("arrays")){
            q=Greenfoot.ask("To me, the concept of an abstract class was confusing. Working with arraylists and operating on 2-D arrays was also difficult initially. Also, recursion and  the concept of overloading methods were challenging. Which one would you like to know more about?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.contains("arrays")){
            q=Greenfoot.ask("Evaluating 2-D arrays and figuring out what element was at which cell was difficult. May I sit down now?" );
        
        }
        if (q.contains("overloading methods")){
            q=Greenfoot.ask("At first I was confused with how overloading methods was different to overriding methods. May I sit down now?");
        
        }
        if (q.contains("arraylists")){
            q=Greenfoot.ask(" thought it was difficult to create for loops with arraylists.");
        
        }
        if (q.contains("recursion")){
            q=Greenfoot.ask(" may I please sit down?");
        
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        
        
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(10);
         
        int move1 [][]=new int [2][3];
        for (int i=0; i<move1.length; i++){
            
            for (int j=1;j<=9;j++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int j=1;j<=5;j++){
            setLocation(9,j);
            Greenfoot.delay(10);
        }      
         // move left
        for (int j=9;j>=0;j--){
            setLocation(j,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int j=5;j>=0;j--){
            setLocation(0,j);
            Greenfoot.delay(10);
        }   
          Greenfoot.delay(10);
          returnToSeat();
        }
        
      
    }
     public void myHobby(String s) {
         System.out.println(s);
}

}