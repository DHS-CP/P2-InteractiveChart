import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The SujalNahata class is used as a model for my own class that represents me and my seating location in AP CSA.
 * 
 * @author Sujal Nahata
 * @version 2.0
 */
public class SujalNahata extends Student implements SpecialInterestOrHobby
{
    /**
     * Constructor for the SujalNahata class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors do not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (first name)
     * @param String l (last name)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     */
    public SujalNahata(String f, String l, int r, int s) {
        numStudents += 1;
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
     * This constructor sets the location of the image of me based on the row and seat variables. Furthermore, it it determines the image and 
     * sound file names to be used in the interaction. My image increases the numStudents variable by 1 as I am 1 student in the class.
     */
    public SujalNahata() {
        numStudents += 1;
        firstName="Sujal";
        lastName="Nahata";
        myRow=6;
        mySeat=2;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * This act method determines what happens when my image is clicked (or standing up). Once clicked, the method changes my image to the 
     * standing file, plays the audio of my name, and calls coolMethod() to display the animation. Afterwords, it calls the answerQuestion()
     * method for user interaction. After all that is complete, it reverts back to its original image and location.
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
            
                myHobby("I like to play badminton.");
                // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
                // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
                // Call the sitDown() method to move back  to your seat
            
                coolMethod();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
                Greenfoot.delay(10);
                //Greenfoot.playSound("cha-ching.wav");
                //Greenfoot.delay(10);
                
            }
            else {
                answerQuestion();
                sitDown();
            }     
        }
    } 
    /**
     * This prints my first and last name to the console.
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method allows the user to interact with my image through a question and answer interface. The user may ask about which topics in
     * Java I felt were the most difficult by typing "hard." Otherwise, the user may ask the number of siblings brothers, or sisters I have by 
     * typing "siblings," "brothers," or "sisters" respectively. After the question is answered, the interface asks the user whether I can sit 
     * down or not. If the user types "yes," then sitDown() is called and the image is reverted
     * back to the original file.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("The most challenging topics were recursions, boolean operations, 2D arrays, interfaces, and conditionals. May I sit down?");
        }
        else if(q.contains("siblings")){
            q=Greenfoot.ask("I have " + numberOfSiblings() + " sibling. May I sit down?");
        }
        else if(q.contains("brothers")){
            q=Greenfoot.ask("I have " + numberOfBrothers() + " brothers. May I sit down?");
        }
        else if(q.contains("sisters")){
            q=Greenfoot.ask("I have " + numberOfSisters() + " sister. May I sit down?");
        }
        else if(q. contains("students")){
            q=Greenfoot.ask("There are " + numStudents + " students in the class.");
        }
        else {
            q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
    /**
     * This is a local method specific to the SujalNahata class used to animate the character once the image is clicked on. First, the image is
     * changed to the fidget spinner image and moved to (200, 200). Then, it moves right until it reaches the right side of the screen while the
     * image is rotating and the color of the background is rapidly changing. This pattern continues as the fidget spinner image moves left, up
     * and down, completing for loops that make it move around the whole perimeter of the screen. The number of rotations during each movement 
     * is random and set by the integer numRand. The color of the background alternatess through a set of colors in a 2D array. After the for
     * loops stop running, the fidget spinner image returns to the original location, ready to answer questions.
     */
    public void coolMethod(){
        setLocation(200,200);
        GreenfootImage bg = getWorld().getBackground();
        GreenfootImage bgBak = new GreenfootImage(bg);
        Greenfoot.delay(10);
        Random r = new Random();
        int numRand = (int)(Math.random() * (8)) + 4;
        int color[][] = new int[8 * numRand + 1][4];
        // move right
        for (int x=1;x<=9;x++){
            setLocation(x,0);
            Greenfoot.delay(5);
            turn(75);
            GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
            screen.setColor(new Color(color[x][0], color[x][1], color[x][2]));
            screen.fill();
            bg.drawImage(screen, 0,0);
            Greenfoot.delay(1);
            Greenfoot.delay(1);
            for(int i=0; i<color.length; i++) {
              for(int j=0; j<color[i].length; j++) {
                color[i][j] =  r.nextInt(256);
              }
            }
        }
        // move back
        for (int x=1;x<=5;x++){
            setLocation(9,x);
            Greenfoot.delay(5);
            turn(75);
            GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
            screen.setColor(new Color(color[x][0], color[x][1], color[x][2]));
            screen.fill();
            bg.drawImage(screen, 0,0);
            Greenfoot.delay(1);
            Greenfoot.delay(1);
            for(int i=0; i<color.length; i++) {
              for(int j=0; j<color[i].length; j++) {
                color[i][j] =  r.nextInt(256);
              }
            }
        }      
        // move left
        for (int x=9;x>=0;x--){
            setLocation(x,5);
            Greenfoot.delay(5);
            turn(75);
            GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
            screen.setColor(new Color(color[x][0], color[x][1], color[x][2]));
            screen.fill();
            bg.drawImage(screen, 0,0);
            Greenfoot.delay(1);
            Greenfoot.delay(1);
            for(int i=0; i<color.length; i++) {
              for(int j=0; j<color[i].length; j++) {
                color[i][j] =  r.nextInt(256);
              }
            }
        }       
        // move Forward
        for (int x=5;x>=0;x--){
            setLocation(0,x);
            Greenfoot.delay(5);
            turn(75);
            GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
            screen.setColor(new Color(color[x][0], color[x][1], color[x][2]));
            screen.fill();
            bg.drawImage(screen, 0,0);
            Greenfoot.delay(1);
            Greenfoot.delay(1);
            for(int i=0; i<color.length; i++) {
              for(int j=0; j<color[i].length; j++) {
                color[i][j] =  r.nextInt(256);
              }
            }
        }
        returnToSeat();
        turn(270);
        bg.drawImage(bgBak, 0,0);
    }
    /**
     * This is the constructor for printing "I like to play badminton." It is called in act().
     */
    public void myHobby(String s){
       System.out.println(s);
    }
    /**
     * This is the constructor for printing 1 as the number of siblings I have. It is called in answerQuestion().
     */
    public int numberOfSiblings(){
       return 1;
    }
    /**
     * This is the constructor for printing 0 as the number of brothers I have. It is called in answerQuestion().
     */
    public int numberOfBrothers(){
       return 0;
    }
    /**
     * This is the constructor for printing 1 as the number of sisters I have. It is called in answerQuestion().
     */
    public int numberOfSisters(){
       return 1;
    }
}
