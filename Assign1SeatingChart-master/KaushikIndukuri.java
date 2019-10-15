import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * The class KaushikIndukuri is a subclass of the Student class
 * 
 * @Kaushik Indukuri
 * @09/18/2019
 */
public class KaushikIndukuri extends Student implements SpecialInterestOrHobby 
{
   /**
     * Constructor for the KaushikIndukuri class.
     * Constructors have the same name as the class; this constructor sets the parameters and the variables required for later
     * There is a second constructor that we called that would initalize different conditions because it had different parameters
     * The Constructors set up the first and last name as well as my seat and row number; they also call the files 
     * required for the seating chart
     * paramters were different than the first
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public KaushikIndukuri(String f, String l, int r, int s) {
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
    public KaushikIndukuri(int r, int s) {
        firstName="Kaushik";
        lastName="Indukuri";
        myRow=r;
        mySeat=s;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile="kaushikindukuri.jpg";
       standingFile="kilgoretrout-standing.jpg";
        soundFile="kilgoretrout.wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor
     * The row and seat variable set up where the image if each student is. The variables determine which seat teh student is in.
     * Example: row 1 and seat 1 would be the upper left corner
     */
    public KaushikIndukuri() {
        firstName="Kaushik";
        lastName="Indukuri";
        myRow=5; 
        mySeat=5;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile="kaushikindukuri.jpg";
       standingFile="kilgoretrout-standing.jpg";
        soundFile="kaushik.wav";
        setImage(portraitFile);
        sitting=true;
       // add to numStudents int from the Student class to keep count of the class size
       numStudents ++;
       System.out.println(numStudents);
    }
    
     /**
     * Act - do whatever the KaushikIndukuri actor wants to do. This method is called whenever
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
            
                myHobby("I love doing robotics and playing the guitar!");
            
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
     * Uses the first name and last name variables to print the name
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method creates a question and answer interface where the user can learn more information about the student.
     * It also asks if the student could sit down after the question and answer phase is finished
     * 
     * The method is looped, and there is also questioning about the Java concepts we learned over summer.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know?");
        boolean answered = false;
        boolean concept_check_complete = false;
        while(!answered){
            // the summer hw loop
            if (q.contains("hard")){
                concept_check_complete = false;
                q=Greenfoot.ask("I thought that concepts like abstract classes, 2d arrays, and interfaces. Ask me something about these concepts...");
                while(!concept_check_complete){
                    if(q.contains("abstract")){
                        q=Greenfoot.ask("Abstract classes are classes that contain one or more abstract methods. An abstract method is a method that is declared, but contains no implementation. Abstract classes may not be instantiated. What would you like to know?");
                        concept_check_complete = true;
                    } else if(q.contains("arrays")){
                        q=Greenfoot.ask("A 2D array is a collection of data cells, all of the same type, which can be given a single name. It's organized as a matrix. What would you like to know?");
                        concept_check_complete = true;
                    } else if(q.contains("interfaces")){
                        q=Greenfoot.ask("An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. What would you like to know?");
                        concept_check_complete = true;
                    } else{
                        q = Greenfoot.ask("That wasn't one of the concepts listed. Could you ask a question about abstract classes, 2d arrays, or interfaces?");
                    }
                }
            } else if(q.contains("language")){
                // what programming languages do I use
                q=Greenfoot.ask("I use Python most of the time, but I am currently learning Java. What would you like to know?");
            } else if(q.contains("hobbies")){
                // hobbies
                q=Greenfoot.ask("My hobbies include swimming, coding, guitar, drums, and robotics. What would you like to know?");
            } else if(q.contains("students")){
                // uses the private numStudents int from the Students class
                q=Greenfoot.ask("There are " + numStudents + " students in the class. What would you like to know?");
            } else if(q.contains("sibling")){
                q=Greenfoot.ask("I have one older brother. He is one year odler than me What else would you like to know?");
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
     * This is the movement method used for KaushikIndukuri
     * It will make the character randomly move around the screen and then change the transparency and size every time it jumps around the screen
     * uses a 2d array to make the image a random size as it appears randomly around the screen 
     */
    public void randomMovement(){
       
       Greenfoot.delay(5);
       
       int[][] positions = new int[15][15];
       for(int x =0; x<positions.length; x++){
           for(int y = 0; y < positions[x].length; y++){
               //The values at the end of the Math.random ensure the images and animation won't go off the screen
               positions[x][y] = (int)(Math.random() * (900) + 50);
            }
        }
        
        GreenfootImage rit_img = getImage();
        //movement
        for(int i = 0; i<50; i++){
            // random size 
            int x = (int)(Math.random() * (9));
            int y = (int)(Math.random() * (5));
            // random location
            setLocation(x,y);
            Greenfoot.delay(5);
            // random size (from 2DArray)
            rit_img.scale(positions[x][y], positions[y][x]);
        }


    }
     public void myHobby(String s) {
         System.out.println(s);
}    
}
