import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//import java.awt.Color;

/**
 * The DerekXu class can be used as a model for your own class that represents you and your seating location in AP CSA
 * The icon dabs and flashes rainbow, followed by a series of q and a.
 * @author Derek Xu
 * @version September 9, 2019
 */
public class DerekXu extends Student implements SpecialInterestOrHobby, StudentLeadership
{   
    //initiate global variables
    public String standingFile1;
    public String standingFile2;
    
    public int rgb [][];
    
    /**
     * Constructor for the DerekXu class.
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
    public DerekXu(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile1=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing1.png";
        standingFile2=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.png";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
        
        rgb = new int [2][4];
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public DerekXu() {
        firstName="Derek";
        lastName="Xu";
        myRow=5;
        mySeat=4;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile1=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing1.png";
        standingFile2=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting = true;
    }
    
     /**
     * Act - do whatever the DerekXu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
     public void act() 
     {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to dab!"); //implements the specialinterestorhobby interface
                myRoleInLeadership("I'm a robotics captain :D"); //implements the studentleadership interface
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
                dab();
                //circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
        boolean flag;
        String q=Greenfoot.ask("Hi, what would you like to know.");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, interfaces, and linear search. Would you like to know more about them?");
            if (q.contains("yes")) {
                flag = true;
                while (flag = true) {
                q = Greenfoot.ask("Which would you like to know about?");
                    if (q.contains("2d array")) {
                        q = Greenfoot.ask("2D arrays can store one type of data, and is called by 'int name [][] = new int [r][c]. Anything else?");
                        if (q.contains("yes")) {
                            flag = true;
                        }
                        else {
                            flag = false;
                            Greenfoot.ask("Thank you, goodbye.");
                            break;
                        }
                    }
                    if (q.contains("interface")) {
                        q = Greenfoot.ask("An interface is a standard way of doing things across all classes and includes an interface declaration. Anything else?");
                        if (q.contains("yes")) {
                            flag = true;
                        }
                        else {
                            flag = false;
                            Greenfoot.ask("Thank you, goodbye.");
                            break;
                        }                        
                    }
                    if (q.contains("linear search")) {
                        q = Greenfoot.ask("A linear search is used to search a key element from multiple elements, but is slower than binary search and hashing. Anything else?");
                        if (q.contains("yes")) {
                            flag = true;
                        }
                        else {
                            flag = false;
                            Greenfoot.ask("Thank you, goodbye.");
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
     * This is a local method specific to the DerekXu class used to animate the character once the image is clicked on.
     * The DerekXu class first inits a 2D array of random values to symbolize rgb and opacity.
     * DerekXu then dabs by switching between two images 10 times.
     * in a while loop
     */    
    public void dab() {
        int i = 0;
        while (i < 10) {
            rgb[0][0] = Greenfoot.getRandomNumber(255);
            rgb[0][1] = Greenfoot.getRandomNumber(255);
            rgb[0][2] = Greenfoot.getRandomNumber(255);
            rgb[0][3] = 100;
            rgb[1][0] = Greenfoot.getRandomNumber(255);
            rgb[1][1] = Greenfoot.getRandomNumber(255);
            rgb[1][2] = Greenfoot.getRandomNumber(255);
            rgb[1][3] = 100;
            
            GreenfootImage stand1 = new GreenfootImage("derekxu-standing1.png");
            GreenfootImage stand2 = new GreenfootImage("derekxu-standing2.png");
            stand1.setColor(new Color(rgb[0][0], rgb[0][1], rgb[0][2], rgb[0][3]));
            stand2.setColor(new Color(rgb[1][0], rgb[1][1], rgb[1][2], rgb[1][3]));
            
            stand1.fill();
            stand2.fill();
            setImage(stand1);
            Greenfoot.delay(10);
            setImage(stand2);
            Greenfoot.delay(10);

            i++;
        }
    }
     /**
     * This method prints out one line of my hobby, which is dabbing. 
     * uses the SpecialInterestOrHobby interface
     */
    public void myHobby(String s) {
         System.out.println(s);
    }
     /**
     * This method prints out one line of my leadership, which is robotics. 
     * uses the StudentLeadership interface
     */
    public void myRoleInLeadership(String a) {
        System.out.println(a);
    }

}
