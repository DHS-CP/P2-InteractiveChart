import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * The class RitviksiddhaPenchala is a subclass of the Student class that has specific information and methods about Ritviksiddha Penchala.
 * 
 * @Ritviksiddha Penchala
 * @09/05/2019
 */
public class RitviksiddhaPenchala extends Student implements SpecialInterestOrHobby 
{
   /**
     * Constructor for the Ritviksiddha Penchala class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     * lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public RitviksiddhaPenchala(String f, String l, int r, int s) {
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
    public RitviksiddhaPenchala(int r, int s) {
        firstName="Ritviksiddha";
        lastName="Penchala";
        myRow=r;
        mySeat=s;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile="bad_pic_of_rit.jpg";
       standingFile="kilgoretrout-standing.jpg";
        soundFile="kilgoretrout.wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     * This is the constructor that is prefereed as it has all the specific details about this class and specific file references.
     */
    public RitviksiddhaPenchala() {
        firstName="Ritviksiddha";
        lastName="Penchala";
        myRow=3;
        mySeat=5;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile="bad_pic_of_rit.jpg";
       standingFile="rit_standing_bighead.PNG";
        soundFile="ritviksiddhapenchala.wav";
        setImage(portraitFile);
        sitting=true;
       // add to numStudents int from the Student class to keep count of the class size
       numStudents ++;
       System.out.println(numStudents);
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * It will only carry out the movement and answer questions once it has been "clicked" on. 
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
            
                myHobby("I like to play videogames!");
            
                randomMovement();  // Movement method specific to RitviksiddhaPenchala
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
     * some mechanism that allows the student to sit down once the Q&A session ends.  
     * 
     * The original method has been changed so that it is looped until some kind of resolution is reached in the conversation. In addition, there is now second-level questioning about the summer homework concepts.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know?");
        boolean answered = false;
        boolean concept_check_complete = false;
        while(!answered){
            // the summer hw loop
            if (q.contains("hard")){
                concept_check_complete = false;
                q=Greenfoot.ask("I thought that concepts like abstract classes, sort algorithms, and search algorithms. Ask me something about these concepts...");
                while(!concept_check_complete){
                    if(q.contains("abstract")){
                        q=Greenfoot.ask("An abstract class is classes that cannot be instantiated. They are used as a way to share code when multiple of its subclasses are likely to share code. What would you like to know?");
                        concept_check_complete = true;
                    } else if(q.contains("sort")){
                        q=Greenfoot.ask("Sort algorithms go through a data set and organize it (sort it) into a format the search algorithm can understand later. What would you like to know?");
                        concept_check_complete = true;
                    } else if(q.contains("search")){
                        q=Greenfoot.ask("Search algorithms are a way of looking through large, sorted data sets to find a specific value. Things like search engines or databases use this. What would you like to know?");
                        concept_check_complete = true;
                    } else{
                        q = Greenfoot.ask("I don't think that was one of the concepts I listed. Could you ask a question about abstract classes, sort algorithms, or search algorithms?");
                    }
                }
            } else if(q.contains("language")){
                // what programming languages do I use
                q=Greenfoot.ask("I use JavaScript most frequently, but Java was the first language I learne when I first started coding years ago. What would you like to know?");
            } else if(q.contains("hobbies")){
                // hobbies
                q=Greenfoot.ask("My hobbies include coding, playing videogames, robotics, reading, watching TV, and listening to music. What would you like to know?");
            } else if(q.contains("students")){
                // uses the private numStudents int from the Students class
                q=Greenfoot.ask("There are " + numStudents + " students in the class. What would you like to know?");
            } else if(q.contains("sibling")){
                q=Greenfoot.ask("I have one younger sister. What else would you like to know?");
            }else {
                // default question asked so the conversation keeps going
              q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            }
             if (q.equals("yes")){
                 // only sits when the user wants it to
                Greenfoot.delay(10);
                sitDown();
                answered=true;
            } else if(q.equals("no")){
                // back to start of loop if the user says don't sit
                q = Greenfoot.ask("What would you like to know?");
            }
        }
    }
    /**
     * This is the movement method used only for RitviksiddhaPenchala
     * It will make the sprite randomly jump around the screen and then randomize the transparency and size in each state (using 2DArrays)
     */
    public void randomMovement(){
       
       Greenfoot.delay(5);
       
       // Fill a 2DArray with random values for size 
       int[][] positions = new int[15][15];
       for(int x =0; x<positions.length; x++){
           for(int y = 0; y < positions[x].length; y++){
               positions[x][y] = (int)(Math.random() * ((1000 - 50) + 1)) + 50;
            }
        }
        
        GreenfootImage rit_img = getImage();
        // actual movement
        for(int i = 0; i<50; i++){
            // random size in each location
            int x = (int)(Math.random() * ((10 - 1) + 1)) + 1;
            int y = (int)(Math.random() * ((6 - 1) + 1)) + 1;
            // random location
            setLocation(x,y);
            Greenfoot.delay(5);
            // random size (from 2DArray)
            rit_img.scale(positions[x][y], positions[y][x]);
          
            rit_img.setTransparency((int)(Math.random() * ((255 - 1) + 1)) + 1);
        }
         rit_img.setTransparency(255);

    }
     public void myHobby(String s) {
         System.out.println(s);
}    
}
