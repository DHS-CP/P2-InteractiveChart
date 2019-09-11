import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The SiriPhaneendra class represents Siri Phaneendra's seating location in AP CSA
 * 
 * @author Siri Phaneendra
 * @version 2.0 Sep 8, 2019
 */
public class SiriPhaneendra extends Student implements SpecialInterestOrHobby {
    
    
    /**
     * Constructor for the SiriPhaneendra class.
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
    public SiriPhaneendra(String f, String l, int r, int s) {
       
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  
        
        //GreenfootImage images = new GreenfootImage(portraitFile);  
        //images.scale(30, 30);
        //setImage(images);
        //setImage(portraitFile);
        
        sitting=true;

    }
    /**
     * This is the default constructor. It defines Siri's row and column in the seating chart, as well as the various sound/image files.
     * 
     */
    public SiriPhaneendra() {
        firstName="Siri";
        lastName="Phaneendra";
        myRow=3;
        mySeat=6;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        
        GreenfootImage images = new GreenfootImage(portraitFile); 
        images.scale(30, 30); //sizing of the portraitFile image
        setImage(images);
        
        sitting=true;
       
       
    }
    
     /**
      * This method focuses on actions, specifically rotationArray(), which is my unique animation method. 
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); 
                getName();
                sayName(soundFile);
            
                myHobby("I like to play the guitar, piano, and clarinet!");
                
                myRoleInLeadership("I am in the process of launching my company!"); 
                
                rotationArray(); //my animation method

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
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("Hi there!! What would you like to know?"); 
        
        if(q.contains("number")){
            q=Greenfoot.ask("Ahh yes, you want to know how many students we have in this class. We have " + " students."); //static variable: numStudents
        }
            
        if (q.contains("hard")){
            q=Greenfoot.ask("Overriding, Constructors, Polymorphism, Recursions, and Overloading. Do you want to learn about these topics?");

           if(q.contains("yes")){
                q=Greenfoot.ask("Which topic are you interested in learning about? Choose from: Overriding, Constructors, Polymorphism, Recursions, or Overloading. Please use the same capitalization as shown in the options.");  
                if(q.contains("Overriding")){
                   q=Greenfoot.ask("Overriding has the same name as a method in the parent class. It may or may not have the same number of parameters. ...");
                }
                if(q.contains("Constructors")){
                   q=Greenfoot.ask("A constructor is a method that builds an instance of a class. It does not have a return type associated with it. ");
                }
                if(q.contains("Overloading")){
                   q=Greenfoot.ask("Overloading is when you create a class object with a different number of parameters.  ...");
                }
                if(q.contains("Polymorphism")){
                   q=Greenfoot.ask("Polymorphism is when values of different types can be handled using a same interface  ...");
                }
                if(q.contains("Recursions")){
                   q=Greenfoot.ask("Recursive methods consist of 2 parts - a call to itself and a base case to stop the recursion.  ...");
                }
           }
           
           else{
                Greenfoot.ask("It was nice talking to you. Have a nice day!");
                sitDown();
           }
        }
        
        else{
                Greenfoot.ask("I do not understand, unfortunately."); //if given an output that is something other than 'yes'
                sitDown();
        }
    }
    
    /**
     * This pre-made method prints out a string related to a hobby.
     */
    public void myHobby(String s) {
         System.out.println(s);
    }
    
    /**
     * This pre-made method prints out a string related to a role in leadership.
     */
    public void myRoleInLeadership(String b) {
        System.out.println(b);
    }
    
    /**
     * The rotationArray method creates an array with 3x3 dimensions consisting of all integer values. It goes through two for loops and delays the image movement by a time 
     * determined by the value in a randomly chosen array 'box.' The image moves left to right in three different columns with a random speed. After the animation, the 
     * standing-up picture will return back to the original seating chart location. 
     */
    public void rotationArray() {
        int row; 
        int col; 

        int [][] array = new int[3][3]; //creating an array with 3x3 dimensions consisting of all integers
        
        //the following is defining every 'box' in the array
        array[0][0] = 10;
        array[0][1] = 20;
        array[0][2] = 50;
        
        array[1][0] = 10;
        array[1][1] = 20;
        array[1][2] = 50;
        
        array[2][0] = 10;
        array[2][1] = 20;
        array[2][2] = 50;
        

        for (int i = 0; i < 6; i += 2) 
            for (int j = 0; j < 10; j += 2) {
                Greenfoot.delay(array[Greenfoot.getRandomNumber(2)][Greenfoot.getRandomNumber(2)]); //delays the image movement by random seconds
                setLocation(j,i); //setting the location
            }
        
        Greenfoot.delay(5); //delay by five seconds
        setLocation(6,3); //sets location back to Siri's original seating chart position

    }
}

        