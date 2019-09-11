import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * joshkoh is a child class of student, so it inherits the attributes of the Student parent class as well.
 * 
 * Class joshkoh contains the instructions and procedures for student "Joshua Koh". When clicked, the student says their name and performs some type of
 * animation. 
 * 
 * @author Joshua Koh
 * @version 9/9/2019
 */
public class joshkoh extends Student implements SpecialInterestOrHobby
{

    /**
     * These are the constructors for the joshkoh class. These constructors can be overloaded, or called with different arguments. This constructor
     * is called with the below parameters in order to initialize the joshkoh class.
     * @param String f (Josh)
     * @param String l (Koh)
     * @param int r (2)
     * @param int s (3)
     * 
     */
    public joshkoh(String f, String l, int r, int s) {
        numStudents += 1;
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // joshkoh.jpg
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg"; // joshkoh-standing.jpg
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // joshkoh.wav
        redboneFile="redbone.wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * This is the constructor that the joshkoh class defaults to if no parameters are called. This causes the object to move to 1,1 and set the 
     * portraitFile and standingFile to the default name. This constructor is similar to the above, except that the parameters are defaulted.
     * 
     * @param args Unused.
     * @return Returns nothing.
     */
    public joshkoh() {
        numStudents += 1;
        firstName="Josh";
        lastName="Koh";
        myRow=1;
        mySeat=1;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg"; // joshkoh.jpg
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg"; // joshkoh-standing.jpg
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav"; // joshkoh.wav
        redboneFile="redbone.wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
    * Act - do whatever the joshkoh actor wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    * 
    * @param args Unused.
    * @return Returns nothing.
    */   
    public void act() 
    {
        // Action code
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                // Actor stands up and says name
                sitting=false;
                getName();
                sayName(soundFile);
                
                // My Hobby
                myHobby("I build robots!");
                
                // Calls my action (which I called mlg)
                mlg();
            }
            else {
                // If the actor is already standing up and is clicked, it will answer the question.
                answerQuestion();
                
                // When the question is answered, the actor will then sit down.
                //sitDown();
            }
                    
        }
    } 
    /**
     * This method prints my first and last name to the console. (Josh Koh)
     * 
     * @param args Unused.
     * @return Returns a print statement.
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName + ".");
    }
    /**
     * This method allows the actor to interact with the teacher and answer questions. Because this happens all of the time,
     * I will start the conversation by talking about Christy. I'm not salty, honest! I just think it's fun to allude to it.
     * The following part is the serious part about what was hard over the summer. If the user asks what about syntax was difficult,
     * I will elaborate. If the question is not recognized, I will not answer, and just sit down.
     * 
     * @param args Unused.
     * @return Returns nothing.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("Sorry I came up so close. What would you like to know about my sister?");
        q = q.toLowerCase();
        
        q=Greenfoot.ask("Christy Koh goes to Berkeley and does EECS. " + 
        "She's done many famous projects such as Stay On Course, Noh Snap, and Blindsight. " + 
        "During her time at high school, she was president of the robotics club, the chemistry club, etc, etc. \n" + 
        "Everyone who talks to me only asks about Christy anyway, so this spiel is kind of memorized. Any other questions?");
        
            if (q.toLowerCase().contains("hard") || q.toLowerCase().contains("difficult"))
            {
                q=Greenfoot.ask("The only thing I found really difficult was getting used to the syntax of Java. Any other questions?");
                
                if (q.toLowerCase().contains("syntax") || q.toLowerCase().contains("difficult") || q.toLowerCase().contains("why"))
                {
                    q=Greenfoot.ask("I usually code in C++, so although the syntax was somewhat similar, I found the way that Java defines \n" +
                    "methods was really odd. In addition, the fact that Java can't do basic integer/double arithmetic somewhat irks me. \n" + 
                    "That's all I really have to say; may I sit down?");
                }
            }
            if (q.toLowerCase().contains("students")) 
            {
                q=Greenfoot.ask("There are " + numStudents + " students in my class. Can I sit down now?");
            }
            if (q.toLowerCase().contains("siblings"))
            {
                q=Greenfoot.ask("I have " + numberOfSiblings() + " siblings. Can I sit down?");
            }
            if (q.toLowerCase().equals("yes"))
            {
                sitDown();
            }
            else 
            {
                q=Greenfoot.ask("Can I please, please sit down now? My legs hurt.");
            }
            if (q.toLowerCase().equals("yes"))
            {
                sitDown();
            }
        }
    /**
     * 
     * This is the method that contains the animation for the actor. The method begins by delaying and allowing the joshkoh.wav file to finish playing,
     * then changes the image to standingFile and plays the redbone.wav sound track.
     * 
     * This method also uses a 2D array to control the sizing of the image. I realized that Greenfoot would freak out if I simply plugged
     * in x*i and y*i into the image.scale function, so I had to find a way to limit the maximum scale. This was done using a 2D array. The 2D array
     * has length 2 and width 73, with each row corresponding to the value of i and each column corresponding to the x and y dimentions, respectively.
     * The 2D array populates using the x*i formula until it reaches row size_limit, after which it repeats the highest dimentions so that the 
     * image stops scaling. This allowed Greenfoot to run smoothly and without overloads.
     * 
     * To rotate the image, a Math.random() method is called in order to vary the degrees of rotation. This allows the rotation of the image
     * to be silly and unpredictable.
     * 
     * Finally, to preserve sanity, the image returns to its original size and orientation.
     * 
     * @param args Unused.
     * @return Returns nothing.
     */
    public void mlg(){
       // Short delay to allow JoshKoh.wav to finish playing
       Greenfoot.delay(70);
       
       // Change the image to the standing image file, and play redbone.wav
       setImage(standingFile);
       
       GreenfootImage image = getImage();
       
       sayName(redboneFile);
       
       // Create new 2D Array:
       int[][] sizing_list = new int[73][2];
       sizing_list[0][0] = 100;
       sizing_list[0][1] = 125;
       
       int size_limit = 45;
       
       // Set X and Y dimentions for the image, but stop increasing at 
       // 100*size_limit and 125*size_limit so that greenfoot doesn't start
       // freaking out.
       for (int i=1;i<size_limit;i++) 
       {
           sizing_list[i][0] = 100*i;
           sizing_list[i][1] = 125*i;
       }
       
       // Implement size_limit, with maximum at the number of columns in
       // the 2D array.
       for (int i=size_limit;i<73;i++) 
       {
           sizing_list[i][0] = sizing_list[size_limit-1][0];
           sizing_list[i][1] = sizing_list[size_limit-1][1];
       }
       
       // Rotate and Scale the image using Math.random() and the 2D array,
       // respectively. 
       
       int rotate_amt = (int)(Math.random() * 10) + 5; // Randomizer
       
       for (int i=0;i<72;i++)
       {
           // Set rotation
           setRotation(getRotation() + 10);
           
           // Resize image
           image.scale(sizing_list[i][0],sizing_list[i][1]);
           
           // Refresh images so that rotation and resizes are saved
           setImage(image);
           
           // Delay for the sake of sanity
           Greenfoot.delay(5);
       }
       
       // Delay to ensure that the song is finished 
       Greenfoot.delay(100);
       
       // Reset the image to the original dimentions and rotation
       image.scale(100,125);
       setRotation(0);
    }
    /**
     * @param Requires string.
     * @return Returns print statement.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
    public int numberOfSiblings() {
        return 2;
    }
}
