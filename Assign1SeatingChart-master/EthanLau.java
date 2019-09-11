import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import static java.lang.Math.*; 

/**
 * The EthanLau class 
 * Adapted from KilgoreTrout
 * 
 * @author Ethan Lau
 * @version 2.0 Aug 13, 2019
 */
public class EthanLau extends Student implements SpecialInterestOrHobby, StudentAthlete 
{


    /**
     * Constructor for the EthanLau class.
     *  lists to initalize for different conditions (depending on what constructors have been written)
     * @param String f Ethan
     * @param String l Lau
     * @param int r 5
     * @param int s 2
     * 
     */
    public EthanLau(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".JPG";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;

    }
    /**
     * Default Constructor of the EthanLau class
     * 
     */
    public EthanLau() {
        firstName="Ethan";
        lastName="Lau";
        myRow=5;
        mySeat=2;
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".JPG";
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
            
                myHobby("I like to go places around the world, whether it be hiking in the desert to skiing in the snow.");
                mySport("I like to play tennis");
                
                moveClass();  // Directs Movement of Ethan Lau
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * getName - Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    
    /**
     * This method determines whether if there will be further questioning (and a recalling of the answerQuestion method) or if the student can sit down. This is based upon the user input of yes or no. 
     */
    public void maySit(String q){
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
            setRotation(0);
          }
        else if (q.equals("no")){
            Greenfoot.delay(10);
            answerQuestion();
          }
        else{
            q=Greenfoot.ask("I don't understand the answer... May I sit down?");
            maySit(q);
        }
    }
    
   /**
     * This method needs to allow the user to interact with the student through a question and answer interface. The user can ask of the specific number of students in the class and what the student has found hard in the course material. The user
     * can further ask of the specifics of what the student has found hard. This method calls upon the maySit method to determine if there will be further questioning or the student can sit down. 
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
          q=Greenfoot.ask("2D arrays, recursion, variable scope, and inheritance... Do you want to know more?");
          if (q.contains("yes")){
              q=Greenfoot.ask("What would you like to know about?");
              if (q.contains("array")){
                  q=Greenfoot.ask("Accessing 2D Arrays .... May I sit down?");
                  maySit(q);                    
                }
              else if (q.contains("recursion")){
                  q=Greenfoot.ask("How to set up recursion in Java .... May I sit down?");
                  maySit(q);                    
                }
              else if (q.contains("scope")){
                  q=Greenfoot.ask("How to access variables in other classes... May I sit down?");
                  maySit(q);                    
                }
              else if (q.contains("inheritance")){
                  q=Greenfoot.ask("How to access methods of parent classes ... May I sit down?");
                  maySit(q);                   
                }
              else {
                  q=Greenfoot.ask("I don't understand the question... May I sit down?");
                  maySit(q);                  
                }                
           }
          else if (q.contains("no")){
              q=Greenfoot.ask("May I sit down?");
              maySit(q);
            }
          else {
              q=Greenfoot.ask("I don't understand the question... May I sit down?");
              maySit(q);
            }
        }
        else if (q.contains("how many")) {
          q=Greenfoot.ask("2D arrays, recursion, variable scope, and inheritance... May I sit down?");
          maySit(q);
        }
        else if (q.contains("l")){
        } 
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?");
          maySit(q);
        }
    }
    /**
     * This is a local method specific to the EthanLau class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void moveClass(){
        int[][] position = new int[100][2];
        int[][] rotate = new int[10][6];
        for (int row = 0; row < position.length; row++) {
            position[row][0] = (int)(Math.random() * 10);
            position[row][1] = (int)(Math.random() * 6);
        }
        for (int row = 0; row < rotate.length; row++) {
            for (int col = 0; col < rotate[row].length; col++) {
                rotate[row][col] = (int)(Math.random() * 360);
            }
        }
        for (int row = 0; row < position.length; row++) {
            setLocation(position[row][0],position[row][1]);
            setRotation(rotate[position[row][0]][position[row][1]]);
            Greenfoot.delay(1);
        }

           Greenfoot.delay(20);
           returnToSeat();
    }
     
    /**
     * myHobby - 
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
    
    /**
     * mySport 
     */
    public void mySport(String s){
        System.out.println(s);
    }

}