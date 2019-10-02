import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math; 

/**
 * The MichaelRejo class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class MichaelRejo extends Student implements NumberOfSiblings, SpecialInterestOrHobby
{

    /**
     * Constructor for the MichaelRejo class.
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
    public MichaelRejo(String f, String l, int r, int s) {
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
    public MichaelRejo() {
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
        numStudents++;
    }
    
     /**
     * Act - do whatever the MichaelRejo actor wants to do. This method is called whenever
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
            
                myHobby("I like to play music!");
                System.out.println("I have " + numberOfSiblings() + " siblings!");
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
        String a=Greenfoot.ask("Ask me something!");
        boolean done = false;
        boolean concept_done = false;
        while(!done){
            if (a.contains("hard")){
                concept_done = false;
                a=Greenfoot.ask("I thought that concepts like abstract classes, recursion, and constructor chaining were hard. Ask me about one of these concepts.");
                while(!concept_done){
                    if(a.contains("abstract")){
                        a=Greenfoot.ask("An abstract class is a class that will not instantiate. Rather it is inherited by other subclasses, which inherit it's methods and attributes. What else would you like to know?");
                        concept_done = true;
                    } else if(a.contains("recursion")){
                        a=Greenfoot.ask("Recursions are methods that are called within themselves. Usually they have a case that stops the recursion. What else would you like to know?");
                        concept_done = true;
                    } else if(a.contains("constructor chaining")){
                        a=Greenfoot.ask("Constructor chaining allows you to create multiple constructors with different parameters. Depedning on what information is given, it will construct and fill in the rest of the information with preset values. What else would you like to know?");
                        concept_done = true;
                    } else{
                        a = Greenfoot.ask("That was not one of the topics I listed. Ask me a question about abstract classes, recursion, or constructor chaining!");
                    }
                }
            }else if(a.contains("students")){

                a=Greenfoot.ask("There are " + numStudents + " students in the class. What would you like to know?");
            }else {
              a=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            }
             if (a.equals("yes")){
                Greenfoot.delay(5);
                sitDown();
                done=true;
            } else if(a.equals("no")){
                a = Greenfoot.ask("What else do you want to know?");
            }
        }
    }
    /**
     * This is a local method specific to the MichaelRejo class used to animate the character once the image is clicked on.
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
     public void myHobby(String s) {
         System.out.println(s);
}
    public int numberOfSisters(){
        return 0;
    }
    public int numberOfBrothers(){
        return 0;
    }
    public int numberOfSiblings(){
        return numberOfBrothers() + numberOfSisters();
    }
}

