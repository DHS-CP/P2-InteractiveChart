import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The RinaKaura class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class RinaKaura extends Student implements SpecialInterestOrHobby, NumberOfSiblings, StudentAthlete 
{

    /**
     * Constructor for the RinaKaura class.
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
    public RinaKaura(String f, String l, int r, int s) {
        firstName="Rina";
        lastName="Kaura";
        myRow=2;
        mySeat=2;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public RinaKaura() {
        firstName="Rina";
        lastName="Kaura";
        myRow=2;
        mySeat=2;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    
     /**
     * Act - do whatever the RinaKaura actor wants to do. This method is called whenever
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
                crunch();
                color();
                myHobby("I like to dance!");
                numberOfSisters();
                mySport("I play tennis");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            

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
            q=Greenfoot.ask("Abstract classes and merge sort... May I sit down?");
        
        }
        else if(q.contains("friends")){
            q=Greenfoot.ask("What are those?... May I sit down?");
           
        }
        else if(q.contains("friends")){
            q=Greenfoot.ask("What are those?... May I sit down?");
           
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        if (q.equals("no")){
            act();
        }
        
    }
    /**
     * This is a local method specific to the RinaKaura class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void crunch(){
        GreenfootImage img = getImage();
        img.scale(img.getWidth()/2, img.getHeight());
        setImage(img);
        Greenfoot.delay(10);
        img.scale(img.getWidth(), img.getHeight()/2);
        setImage(img);
        Greenfoot.delay(10);
        setImage(standingFile);
    }
    public void color(){
        GreenfootImage bg = getWorld().getBackground();
        GreenfootImage orig = new GreenfootImage(bg);
        for (int i=1; i<10; i++) {
            ArrayList<Color> colors 
                = new ArrayList<Color>()
                {{ add(Color.RED); 
                    add(Color.CYAN);
                    add(Color.BLUE);
                    add(Color.GREEN);
                    add(Color.MAGENTA);
                    add(Color.YELLOW); }};
            GreenfootImage pic = new GreenfootImage(bg.getWidth(), bg.getHeight());
            pic.setColor(colors.get(Greenfoot.getRandomNumber(colors.size())));
            pic.fill();
            bg.drawImage(pic, 0, 0);
            Greenfoot.delay(10);
        } 
        getWorld().setBackground(orig);
    }
    private int dropSpeed = 5;
    private boolean hitBox = false;
    private void fall()
    {
        //Add your falling code here
        if (!hitBox){
            setLocation(getX(),getY()+dropSpeed); 
            hitBox = checkBox();
        }

    }
    private boolean checkBox()
    {
        //Add your checkBottom code here
        if (getY()>570){
            return true;
        }
        else{
            return false;
        }
    
    }
    /*
    private boolean canCatch(){
        GreenfootImage openbox = new GreenfootImage("openbox.jpg");
        Actor box = setImage();
        if(box != null) {
            return true;
        }
        else {
            return false;
        }
    }
    private void Pack() {
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if(gold != null) {
            Greenfoot.playSound("cha_ching.wav");
            getWorld().removeObject(gold);
        }
    }
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
    public int numberOfSiblings() {
         return(1);
    }
    public int numberOfBrothers() {
         return(0);
    }
    public int numberOfSisters() {
        System.out.println("I have a sister");
        return(1);
    }
    public void mySport(String s){
        System.out.println(s);
    }
    
}
