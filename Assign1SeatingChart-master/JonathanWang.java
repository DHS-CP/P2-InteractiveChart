import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * The JonathanWang class defines the initial state and behavior of the Jonathan Wang actor. 
 * 
 * @author Jonathan Wang
 * @version 1.3
 */
public class JonathanWang extends Student implements SpecialInterestOrHobby, StudentAthlete
{

    /**
     * Constructor for the JonathanWang class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * Adds one to numStudents variable
     */
    String speecharray [][] = new String[14][2];
    public JonathanWang(String f, String l, int r, int s) {
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
     * Adds one to the numStudents variable
     */
    public JonathanWang() {
        firstName="Jonathan";
        lastName="Wang";
        myRow=4;
        mySeat=7;
        //imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    
     /**
     * Act - do whatever the JonathanWang actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play badminton and take part in baking!");
                mySport("I also like to go swimming!");
         
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
                animationClass();  
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
     * Creates an array of phrases and responses in a 2D array. 
     * While and for loop are used to iterate through the 2D array and identify if the user input contains any of the corresponding words to return a response.
     * If none of the phrases are seen to be contained in user input, audio file is played, while loop is ended, and student sits down with sitDown() method
     */
    public void answerQuestion(){
        speecharray[0][0] = "hard";
        speecharray[0][1] = "Binary sort, recursion, and merge sort... May I sit down?";
        speecharray[1][0] = "easy";
        speecharray[1][1] = "Binary, Data types, and modulus division... May I sit down?";
        speecharray[2][0] = "fun";
        speecharray[2][1] = "I like to swim, play badminton, and browse Reddit, May I sit down?";
        speecharray[3][0] = "travel";
        speecharray[3][1] = "I like to visit Taiwan to see my relatives, May I sit down?";
        speecharray[4][0] = "binary sort";
        speecharray[4][1] = "Binary sort is an algorithm that determines the position of a value in an array by making comparisons to see if the value is in the first half of the data set or the second half.\n Depending on that comparison, the algorithm sets the middle of the data set as the highest or lowest value, and repeats the process until the value is found. May I sit down?";
        speecharray[5][0] = "recursion";
        speecharray[5][1] = "Recursion is the practice of creating methods that repeat themselves based on the method arguments. In the method, the argument has to be modified in some way to eventually stop the method from repeating forever. May I sit down?";
        speecharray[6][0] = "merge sort";
        speecharray[6][1] = "Merge Sort is an algorithm designed to place a data set in an array in order. It does that by repeatedly dividing the data set in half until each individual data cell is isolated. Then, comparisons are made in between the data to reorder them. May I sit down?";
        speecharray[7][0] = "binary";
        speecharray[7][1] = "Binary is a numbering system of base 2, utilizing only 0's and 1's. The system starts from 2^0 to 2^7 so any integer from 0 to 255 may be represented. 0 signifies false and 1 signifies true. May I sit down?";
        speecharray[8][0] = "data types";
        speecharray[8][1] = "There are many data types in Java. Some primitive data types include integers, booleans, chars, and doubles. Class data types include arrays, strings, and classes. May I sit down?";
        speecharray[9][0] = "modulus division";
        speecharray[9][1] = "Modulus division is an operation that can be used with the \"%\" character. When dividing 2 values, the remainder of the division is returned rather than the quotient. Performing modulus division on a dividend smaller than the divisor will just return the dividend. May I sit down?";
        speecharray[10][0] = "reddit";
        speecharray[10][1] = "Reddit is a discussion site where users are able to join discussion threads based on their common interests. It is one of the most visited websites in the U.S. May I sit down?";
        speecharray[11][0] = "swim";
        speecharray[11][1] = "I refuse to believe that you don't know what that is. May I sit down?";
        speecharray[12][0] = "badminton";
        speecharray[12][1] = "I refuse to believe that you don't know what that is. May I sit down?";
        speecharray[13][0] = "students";
        speecharray[13][1] = "There are " + numStudents + " students in this class!";
        String q=Greenfoot.ask("What would you like to know? ");
        int loop = 1;
        while (loop ==1) {
        for (int r = 0; r < 14; r++) {
        if (q.toLowerCase().contains(speecharray[r][0])) {
                q = Greenfoot.ask(speecharray[r][1]);
        }
        if (q.toLowerCase().contains("yes")) {
            loop = 0;
            Greenfoot.delay(15);
            sitDown();
        }
    }
    if (q.toLowerCase().contains(speecharray[0][0]) == false && q.toLowerCase().contains(speecharray[1][0]) == false && q.toLowerCase().contains(speecharray[2][0]) == false && q.toLowerCase().contains(speecharray[3][0]) == false && q.toLowerCase().contains(speecharray[4][0]) == false && q.toLowerCase().contains(speecharray[5][0]) == false && q.toLowerCase().contains(speecharray[6][0]) == false && q.toLowerCase().contains(speecharray[7][0]) == false && q.toLowerCase().contains(speecharray[8][0]) == false && q.toLowerCase().contains(speecharray[9][0]) == false && q.toLowerCase().contains(speecharray[10][0]) == false  && q.toLowerCase().contains(speecharray[11][0]) == false && q.toLowerCase().contains(speecharray[12][0]) == false && q.toLowerCase().contains("yes")==false ) {
            Greenfoot.playSound("whatyousay.wav");
            loop = 0;
            Greenfoot.delay(15);
            sitDown();
        }
    
}
}
    /**
     * This is a local method specific to the JonathanWang class used to animate the character once the image is clicked on.
     * 
     */
    public void animationClass(){
        int [][] degrees = new int[8][8];
        int a = 0;
        int b = 0;
        for (int r = 0; r < degrees.length; r++) {
            for (int c = 0; c < degrees.length; c++) {
                degrees[r][c] = (int)(Math.random()*360);
            }
        }
        for (int i = 4; i >= 2; i--) {
            setLocation(7,i);
            Greenfoot.delay(4);
        }
        for (int i =7; i >=4; i--) {
            setLocation(i,2);
            Greenfoot.delay(4);
        }
        setRotation(0);
        Greenfoot.delay(36);
        getWorld().setBackground("hawaii.jpg");
        Greenfoot.delay(36);
        setImage("jonathanwang-standing2.jpg");
        Greenfoot.delay(36);
        setImage("jonathanwang-standing3.jpg");
        Greenfoot.delay(36); 
        getWorld().setBackground("hawaii.jpg");
        setRotation(0);
        Greenfoot.delay(36);
        for (int i = 8; i > 0; i--) {
            setRotation(degrees[a][b]);
            a++;
            b++;
            Greenfoot.delay(8);
        }
        Greenfoot.delay(23); 
        getWorld().setBackground("csa.jpg");
        for (int i = 4; i <= 7; i++) {
            setLocation(i,2);
            Greenfoot.delay(5);
        }
        for (int i = 2; i <= 4; i++) {
            setLocation(7,i);
            Greenfoot.delay(5);
        }
        if (getRotation() != 0) {
            setRotation(0);
        }
        Greenfoot.delay(12);
        returnToSeat();
    }
    /**
     * Prints whatever arguments are inputted into the parameters. 
     * Used in the act() method to print student's hobbies.
     */
    public void myHobby (String s) {
         System.out.println(s);
                                      
        }
    /**
     * Prints the sport of the student into the terminal.
     * The method is called in the act() method.
     */
    public void mySport(String mySportSentence) {
        System.out.println(mySportSentence);
    }
    } 