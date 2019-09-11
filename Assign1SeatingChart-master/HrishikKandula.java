import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random; 
/**
 * The HrishikKandula class is the model for the actor that represents the image and seating location 
 * of Hrishik Kandula in AP CSA
 * 
 * @author Hrishik Kandula
 * @version 2.1 Sep 10, 2019
 */
public class HrishikKandula extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{
    /**
     * Constructor for the HrishikKandula class.
     * Increments the numStudents static variable in Student class to keep track of the number of instances created.
     * Sets up the image and sound files used in this actor.
     * 
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public HrishikKandula(String f, String l, int r, int s) {
        numStudents++; // increments the number of students protected static variable in Student class
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
     * Default constructor for HrishikKandula actor.
     * Sets up first & last name and seating position variables.
     * Initializes the image and sound file variables and sets up the sitting image.
     */
    public HrishikKandula() {
        numStudents++; // increments the number of students protected static variable in Student class
        firstName="Hrishik";
        lastName="Kandula";
        myRow=2;
        mySeat=1;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }

     /**
     * act method sets up code for handling mouse click.
     * When the actor is in sitting position and mouse is clicked, it stands up, says the name and
     * does animations. If it is in standing position, it will answer questions.
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

                myHobby("I like to eat pasta");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat

             coolMethod();  // Special method
            }
            else {
                answerQuestion();
                //sitDown();
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
     * This method allows the user to ask a question and will answer the question.
     * If the user types yes to "May I sit down?" question, it will sit down.
     * Sample questions to ask are "Which subject is hard for you in CSA?", "How many siblings do you have?".
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know?");
        if (q.contains("hard")){
            q=Greenfoot.ask("Merge Sort, 2D arrays, Interfaces, Conditionals, and constructors were difficult... May I sit down?");
    
        }
        else if(q.contains("brother")){
            q=Greenfoot.ask("I have " + numberOfBrothers() +" brothers... May I sit down?");
        }
        else if(q.contains("sister")){
            q=Greenfoot.ask("I have " + numberOfSisters() +" sisters... May I sit down?");
        }
        else if(q.contains("siblings")||q.contains("brother") && q.contains("sister")){
            q=Greenfoot.ask("I have " + numberOfSiblings() +" siblings... May I sit down?");
        }
        else{
            q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
    /**
     * This is a local method specific to the HrishikKandula class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     * This method creates HrihikKandula actors and fills up 6x10 grid with them.
     * After each row of the grid is filled, backgroud color is set to a random color.
     * Once the grid is filled, the actors are removed.
     * Then HrishikKandula avatar walks to the right and comes back to original position.
     */
    public void coolMethod(){
        Random r = new Random();
        GreenfootImage bg = getWorld().getBackground();
        GreenfootImage bgBak = new GreenfootImage(bg);
        GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
        // create a 2 dimensional array to keep the actors so that they can be removed
        // after the animation is complete.
        HrishikKandula[][] hrishikActorsArray = new HrishikKandula[6][10];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                HrishikKandula hrishikkandula = new HrishikKandula("Hrishik", "Kandula", j, i);
                getWorld().addObject(hrishikkandula, j, i);
                Greenfoot.delay(5);
                hrishikActorsArray[i][j] = hrishikkandula;
            }
            // set a random color and fill the screen
            screen.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            screen.fill();
            bg.drawImage(screen, 0,0);
        }
        // remove all the actors added
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                getWorld().removeObject(hrishikActorsArray[i][j]);
                Greenfoot.delay(2);
            }
        }
        // set the background to original image
        bg.drawImage(bgBak, 0,0);
        // move right
         for (int i=1;i<=8;i++){
            setLocation(i,2);
            Greenfoot.delay(10);
        }
         // move left
        for (int i=8;i>=1;i--){
            setLocation(i,2);
            Greenfoot.delay(10);
        }
    }
    /**
     * Prints my hobby to screen.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
    /**
     * Returns the number fo siblings for HrishikKandula
     */
    public int numberOfSiblings(){
        return 1;
    }
    /**
     * Returns the number of brothers for HrishikKandula
     */
    public int numberOfBrothers(){
        return 0;
    }
    /**
     * Returns the number of sisters for HrishikKandula
     */
    public int numberOfSisters(){
        return 1;
    }
    }
