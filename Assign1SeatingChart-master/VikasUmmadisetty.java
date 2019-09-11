import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The VikasUmmadisetty class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class VikasUmmadisetty extends Student implements SpecialInterestOrHobby
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
    
    static protected int numStudents = 0;
    
    public boolean animateStart = false;
    
    public VikasUmmadisetty(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public VikasUmmadisetty() {
        firstName="Vikas";
        lastName="Ummadisetty";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    
     /**
     * Act - do whatever the VikasUmmadisetty actor wants to do. This method is called whenever
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
            
                //circleClass();  // Vikas Ummadisetty's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            int r = (int)((Math.random()+1) * 4);
            System.out.println(r);
            String hardTopics[] = {"recursions", "2d arrays", "merge sorting", "abstract classes", "interfaces"};
            String hardTopicsDialogue[] = {"Recursions were a headache to understand!", "Merge sorting was pretty intuitive but hard to implement in code", "Abstract classes were interesting", "Intefaces are like contracts in a way"};
            String q2=Greenfoot.ask("recusions, 2d arrays, merge sorting, abstract classes, and interfaces... Would you like to know about " + hardTopics[r] + "?");
            if(q2.contains("yes")) {
                String q3=Greenfoot.ask(hardTopicsDialogue[r] + "... May I sit down now");
                if(q3.contains("yes")) sitDown();
            }
        }
        if(q.contains("students")) {
            q=Greenfoot.ask("There are " + numStudents + " students in the class. May I sit down now?");
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        
        
    }
    /**
     * This is a local method specific to the VikasUmmadisetty class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
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
    
    public void moveAround() {
        sayName(soundFile);
        setLocation(4,3);
        Greenfoot.delay(10);
        
        // Animation
        
        int [][] twodarray= new int [1000][2];
        twodarray[0][0] = 4;
        twodarray[0][1] = 3;
        
        GreenfootImage originalImage = getImage();
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        
        
        for(int i=1; i<=999; i++) {
            twodarray[i][0] = (twodarray[i-1][0] + ((Math.random() > 0.5) ? 1 : -1));
            twodarray[i][1] = twodarray[i-1][1] + ((Math.random() > 0.5) ? 1 : -1);
            
            if(twodarray[i][0] > 9) twodarray[i][0] = 9;
            if(twodarray[i][0] < 0) twodarray[i][0] = 0;
            if(twodarray[i][1] > 5) twodarray[i][1] = 5;
            if(twodarray[i][1] < 0) twodarray[i][1] = 0;
            
            System.out.println(twodarray[i][0] + " " + twodarray[i][1]);
            
        }
        
        for(int i=0; i<=999; i++) {
            turn(20);
            GreenfootImage image = getImage();
            int scale = ((Math.random() > .5) ? 5 : -5);
            int newWidth = image.getWidth() + scale;
            int newHeight = image.getHeight() + scale;
            if(newWidth < 20) newWidth = 20;
            if(newHeight < 20) newHeight = 20;
            if(newWidth > 1000) newWidth = 1000;
            if(newHeight > 1000) newHeight = 1000;
            
            image.scale(  newWidth, newHeight);
            setImage(image);
            setLocation(twodarray[i][0], twodarray[i][1]);
            Greenfoot.delay(1);
        }
        setRotation(0);
        originalImage.scale(originalWidth, originalHeight);
        setImage(originalImage);
        returnToSeat();
        
    }
    
     public void myHobby(String s) {
         System.out.println(s);
}

}
