import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The child class SamikshaYelthimar is an extension of the parent class Student. 
 * It implements TWO interfaces: SpecialInterestsOrHobby and CSALearnedSoFar to add information about SamikshaYelthimar's hobbies and what she has learned so far in AP CSA.
 * This class defines where SamikshaYelthimar starts, moves to, and finishes, as well as when to be shown as a portrait picture or as a standing caricature picture.
 * It also defines the animation's movement action, initiates the dialog session, and prints the information obtained from implementing the interfaces to the console.
 * 
 * @author Samiksha Yelthimar Period 2 AP CSA
 * @version 9/11/2019
 */
public class SamikshaYelthimar extends Student implements SpecialInterestOrHobby, CSALearnedSoFar  
{

    /**
     * Constructor for the SamikshaYelthimar class.
     * This constructor also sets the variables that set the portrait, standing, and sound files. It also calls the method setImage to the value of portraitFile, and initializes the object to be "sitting down".
     * @param String f sets the first name of the SamikshaYelthimar object to Samiksha
     * @param String l sets the last name of the SamikshaYelthimar object to Yelthimar
     * @param int r Sets the row of seating arrangement to the correct new location
     * @param int s Sets the seat number within the row seating arrangement
     * 
     */
    public SamikshaYelthimar(String f, String l, int r, int s) {
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
     * The act method is a void method that defines what the SamikshaYelthimar actor will do.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * There is a nested if statement in which if the SamikshaYelthimar actor is sitting down and then the mouse clicks on it, then the variable sitting will be set to file, the standing up image will be projected, and the audiofile saying the name will be laced
     *If the the mouse is not clicked on, the actor will excecute the answerQuestion() method and the sitDown() method.
     *
     *This method also calls the methods from the CSALearnedSoFar interface (the LearnedSoFar() method) and the SpecialInterestOrHobby interface (the myHobby() method).
     *SamikshaYethimar's speical method is spinningClass, and describes the actor's special movement.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println("");
                getName();
                sayName(soundFile);
            
                myHobby("Some of my hobbies include cooking, traveling, reading, spending time with my family, and hiking. I also love swimming and playing badminton!");
                LearnedSoFar("This year in AP CSA I've learned about concrete and abstract classes, 1-D and 2-D arrays, for and while loops, how to write algorithms, overriding/overloading methods, and how to use GitHub to manage a large group project.");
            
            
                spinningClass();  
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * This void function prints the first and last name to the console, along with the string "My name is".
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    
    /**
     * This void function allows the user to interact with the student through a question and answer interface, and provides a mechanism that allows the student to sit down once the Q&A session ends.  
     * It contains a string operator that asks the question "Would you like to know what I found challenging about the AP Computer Science Summer Homework?".
     * Then, it contains several if statements (and in some cases else statements) that take the responses to the question, does character match, and then returns a response.
     * The function completes after two levels of questioning is complete.
     * 
     * EXTRA CREDIT: I supported 2 levels of questioning upon the basic "list 5 things you found challenging about the AP CSA summer homework". I go on to ask if the user would like to know more about a topic, and then I list more information about that topic.
     */
    public void answerQuestion(){
       
        String q=Greenfoot.ask("Would you like to know what I found challenging about the AP Computer Science Summer Homework?");
        if (q.contains("yes")){
            q=Greenfoot.ask("To me, the concept of an abstract class was confusing. Working with arraylists and operating on 2-D arrays was also difficult initially. Also, recursion and  the concept of overloading methods were challenging. Which one would you like to know more about?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.contains("arrays")){
            q=Greenfoot.ask("Evaluating 2-D arrays and figuring out what element was at which cell was difficult. May I sit down now?" );
        
        }
        if (q.contains("overloading")){
            q=Greenfoot.ask("At first I was confused with how overloading methods, and how it was different to overriding methods. May I sit down now?");
        
        }
        if (q.contains("arraylists")){
            q=Greenfoot.ask("I thought it was difficult to create for loops with arraylists. May I please sit down?");
        
        }
        if (q.contains("recursion")){
            q=Greenfoot.ask("Tracing code with recursion was difficult because there was a lot to keep track of at once. May I please sit down?");
        
        }
        if (q.contains("class")){
            q=Greenfoot.ask("I was unsure about when to implement a concrete class and when to implement an abstract class. Also, I was confused about the difference between an abstract class and an interface. May I please sit down?");
        
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
            Greenfoot.stop();
        }
        
    }
    /**
     * This is a local method specific to the SamikshaYelthimar class used to animate the character once the image is clicked on.
     * >> There is a 2 by 2 2-D ARRAY used, and it is iterated though with a FOR-LOOP to animate its movement. 
     * The image moves right, backwards, and then left in a random manner, and forward in a random manner as well.
     * 
     * >> The Math.random() method is used to generate random numbers that become the coordinate points of the actor's location.
     */
    public void spinningClass(){
        setLocation(0,0);
        Greenfoot.delay(10);
        
        int move1 [][]=new int [2][2];
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
           //setLocation(j,5);
           setLocation((int) (Math.random()*20),5);
           Greenfoot.delay(10);
        }      
              // move Forward
        for (int j=5;j>=0;j--){
            //setLocation(0,Greenfoot.getRandomNumber(10));
            setLocation(0,(int)(Math.random()*15));
            //setLocation(0,j);
            Greenfoot.delay(10);
        }   
          Greenfoot.delay(10);
       
          returnToSeat();
        }
        
    }
    
    /**
     * This is a void method obtained from the SpecialInterestOrHobby interface that prints out the student's special interests or hobby.
     * It contains a print statement that prints the value of the parameter s.
     * 
     * @param s - a string that contains the description of the student's hobby.
     */
     public void myHobby(String s) {
         System.out.println(s);
}

/**
 *This is a void method from the CSALearnedSoFar interface that displays what the student has learned so far.
 * 
 * @param String b - takes in a string which holds the information about what the student has learned so far. 
 */
public void LearnedSoFar(String b){
    System.out.println(b);
}


}