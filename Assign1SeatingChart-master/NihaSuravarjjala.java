import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The NihaSuravarjjala class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class NihaSuravarjjala extends Student implements SpecialInterestOrHobby,StudentAthlete
{

    /**
     * Constructor for the NihaSuravarjjala class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
*NihaSuravarjjala - initializes the world to set up for the animation and sound. 
*This method is called as soon as the ‘Act’ or ‘run’ button gets 
*pressed in the environment. Creates the variables necessary to start the program (portrait, sound, name).
*/ 
    public NihaSuravarjjala(String f, String l, int r, int s) {
        firstName=f; //Niha with capital N, stores my first name 
        lastName=l; //Suravarjjala with captal S, stores my last name 
        myRow=r;  //creates a variable for my section in the class via rows 
        mySeat=s; //creates a variable for my seat in the class with seat locations 
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // sets my portrait file to my first and last name so it can be referenced
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  //sets my sound file to my first and last name for reference 
        setImage(portraitFile); //sets the image in my seat to the portrait 
        sitting=true; //makes sure i am sitting not standing when program starts in my seat
        numStudents++;
    }
    /**
     * NihaSuravarjjala - calls the method above and stores the values necessary in strings for the information
     * created above. Each of the variables store information necessary to make sure the program begins with me seated, and
     * references my  identity correctly. 
     */
    public NihaSuravarjjala() {
        firstName="Niha"; //stores my first name in the variable 
        lastName="Suravarjjala"; //stores my last name in the variable 
        myRow=1; //stores my row as 1, which is modified later on
        mySeat=1; //stores my seat as 1, which is modified later on 
       //imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg"; //fixes my name for my portrait file to my picture in images
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg"; //calls the standing picture for when the picture is pressed
        soundFile= "nihasuravarjjala.wav"; //stores my sound file 
        setImage(portraitFile); //sets my image to the portrait file 
        sitting=true; //sets my sitting to true
        numStudents++;
    }
    
     /**
     * Act - do whatever the NihaSuravarjjala actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.I stand up when my image on the chart is pressed. 
     * I print my hobby and sport out to the screen and return the values to the program. 
     * 
     * I also reference here my circleClass which is explained in later documentation, but essentially is used to animate
     * my standing position.I am ready to answer a question after the animation because of the else statement. 
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
            
                myHobby("I like to play basketball!");
                mySport("I do contemporary dance in my free time."); 
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Niha Suravarjjala's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
     * I used the basic model as an outline but then expanded off of them for my expanded dialogue. I descirbe some context for concepts if you type in 
     * easy (which is one part of the extension), and the same for hard. You also have the option of asking me a question again, if you answer no for me to sit down. 
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
        
        }
        else if(q.contains("easy")){
            q= Greenfoot.ask ("modular arithmetic and loops...May I sit  down?"); 
            if (q.contains("loops")){
                q = Greenfoot.ask("if statements and for loops...May I sit down?"); 
            }
            else if (q.contains("modular arithmetic")){
                q =Greenfoot.ask("I learned these basics in Algebra 1. May I sit down?"); 
            }
            else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        }
            
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
            Greenfoot.stop(); 
        }
        else {
            Greenfoot.delay(10); 
            Greenfoot.stop(); 
        }
        
    }
    /**
     * circleClass - This is my special animation for my class specifically. I essentially spin around 360 degrees on each side using an incrementing 
     * variable x, and use it to animate my character. Once I spin, I also move in a diagonal line and use the 2D array to generate values for where my animation
     * moves to around the area. 
     */
    public void circleClass(){
        Greenfoot.delay(20);
        int x = 0; 
       /* for (int i=0; i<360; i++){
            x++; 
            turn(1+x); 
            Greenfoot.delay(1); 
        }
       */
        setImage("nihasuravarjjala-standing.jpg"); 
        for (int i=0; i<120; i++){
            turn(3); 
            Greenfoot.delay(1); 
            
        }
        int[][] coordinates = {{5,5},{4,4},{3,3},{2,2},{1,1}, {4,4}};
        for (int i = 0; i < coordinates .length; i++) {
             setLocation(coordinates [i][0],coordinates [i][1]);   
              Greenfoot.delay(5);  
    }
        Greenfoot.delay(20); 
        setImage("nihasuravarjjala.jpg"); 
        
    }
    /** 
*LoopTester - This class creates my 2D array which is 4x5 and iterates through the loop to generate the values above for my motion in my animation. 
*When you first click on my seat my soundfile will play, then I spin, and then I use this class to call values for my diagonal motion. 
*/ 
    public class LoopTester {
        int [] [] a = new int [4] [5]; 
        int count = 1;
        public void main (String [] args)
        {
            for (int r = 0; r< a.length; r++) {
                for (int c = 0; c< a[0].length; c++){
                    a[r][c] = count; 
                    count++; 
                }
            }
            printArr(a); 
        }
        public void printArr(int [][] b) {
            for (int r = 0; r< b.length; r++){
                for (int c = 0; c<b[0].length; c++){
                    System.out.print(a[r][c] + ", "); 
                }
                System.out.println(); 
            }
        }
    }
    /** 
*myHobby and mySport - Here I reference the two methods from earlier in order to set a string and return the values when my name is first 
*clicked on the seating chart. 
*/ 
      public void myHobby(String s) {
         System.out.println(s);
}
public void mySport(String d) {
    System.out.println(d); 
}}