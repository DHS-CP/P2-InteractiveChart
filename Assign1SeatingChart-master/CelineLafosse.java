import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Celine Lafosse
 * @version 2.0 Aug 13, 2019
 */
public class CelineLafosse extends Student implements SpecialInterestOrHobby
{ 
    
    /**
     * Constructor for the CelineLafosse class.
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
    public CelineLafosse(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
   /**
     * Default constructor, if you don't pass in a name and seating location
     */
    public CelineLafosse() {
        firstName="Celine";
        lastName="Lafosse";
        myRow=4;
        mySeat=3;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".mp3";
        setImage(portraitFile);
        sitting=true;
    }
        /**
           * Act - do whatever the CelineLafosse actor wants to do. This method is called whenever
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
                 String[][]songs;
                 songs = new String[3][1];
                 songs[0][0]="music1.mp3";
                 songs[1][0]="music2.mp3";
                 songs[2][0]="music3.mp3";
                 int random = (int) (Math.random()*3);
                 Greenfoot.playSound(songs[random][0]);
                sayName(soundFile);
  
                myHobby("I like to draw!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();
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
     * hardQuestion - This method starts after the user asks the question "what was hard about the summer homework". At the end of the statements,
     * it always asks if the user would like for the character to sit down. If they say no, it gives more options on what to say.
     * If the user tells the interface "yes" or "sit", it ends.
     */
    public void hardQuestion(){
        String b=Greenfoot.ask("2D arrays, boolean expressions, if-else statements, for loops, and recursion..Would you like me to sit?(Yes/No)");
        if (b.contains("sit")){
           Greenfoot.delay(10);
            sitDown();
        }
        if (b.contains("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        while (b.contains("no")){
            b=Greenfoot.ask("Ok! What would you like to know about?(2D arrays/ boolean expressions/ if-else statements/ for loops/recursion)");
            if (b.contains("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            if (b.contains("arrays")){
                b=Greenfoot.ask("2D arrays are hard because there are multiple steps that the computer needs to do, so you need to be specific. Would you like me to sit down? (Yes/No)");
            }
        
            else if (b.contains("boolean")){
                b=Greenfoot.ask("I mainly find it difficult trying to use multiple boolean expressions, because then it gets hard to tell if something is true or false Would you like me to sit down? (Yes/No)");
            }
        
            else if (b.contains("statements")){
                b=Greenfoot.ask("Its hard to make sure your using it correctly, or else your code will just cut right to the end.Would you like me to sit down? (Yes/No)");
            }
        
            else if (b.contains("for loops")){
               b=Greenfoot.ask("I find it hard to be able to loop a certain amount of times, instead of just keeping it going on forever. Would you like me to sit down? (Yes/No)");
        
            }
            else if (b.contains("recursion")){
               b=Greenfoot.ask("I also just gererally find it confusing and it is something I need to study more of. Would you like me to sit down?(Yes/No)");
            }
            else {
              b=Greenfoot.ask("I don't understand the question... May I sit down? (Yes/No)"); 
            }
        }
        
    }
    /**
     * answerQuestion-Starts the questions with "What would you like to know". If the user asks about anything that contains the word "hard", 
     * it starts the hardQuestion method. If it contains the word "yes", the student sits down. 
    */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
          hardQuestion();
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if(q.contains("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
   /**
     * This is a local method specific to the CelineLafosse class used to animate the character once the image is clicked on.
     */
    private int i = 1; //Moving
    private int j = 1; //animating the walk
    private int x = 1; //animating the jump
    /**
     * animationRunTop - Creates the animation of the avatar running through the top by going through all the images quickly 
     * on loop until it gets to the end of the screen.
     */
    public void animationRunTop(){
        for (int i=1;i<=9;i++){
            j++;
            String animationSlide = "ani" + (j) + ".jpg" ;
            setImage(animationSlide);
            Greenfoot.delay(1);
            i++;
            setLocation(i,0);
            Greenfoot.delay(10);
            if (j >= 7) { 
                j = 0;
            }
        }
    }
    /**
     * animationRunTop - Creates the animation of the avatar jumping from the top, to the 
     * bottom of the screen 
     */
    public void animationJumpDown(){
        for (int i=1;i<=5;i++){
           x++;
           String animationSlide = "ani" + (x) + "-jump.jpg" ;
           setImage(animationSlide);
           Greenfoot.delay(1);
           setLocation(9,i);
           Greenfoot.delay(20);
           if (x >= 7) { 
               x = 0;
           }
        } 
    }
    /**
     * animationRunBack - Creates the animation of the avatar running on the bottom of the screen
     */
    public void animationRunBack(){
        for (int i=9;i>=0;i--){
           j++;
           String animationSlide = "ani" + (j) + ".jpg" ;
           setImage(animationSlide);
           Greenfoot.delay(1);
           setLocation(i,5);
           Greenfoot.delay(10);
           if (j >= 7) { 
               j = 0;
           }
        } 
    }
    /**
     * animationJumpUp- Creates the animation of the avatar jumping to the top of the screen
     */
    public void animationJumpUp(){
        for (int i=5;i>=0;i--){
           x++;
           String animationSlide = "ani" + (x) + "-jump.jpg" ;
           setImage(animationSlide);
           Greenfoot.delay(1);
           setLocation(0,i);
           Greenfoot.delay(20);
           if (x >= 7) { 
               x = 0;
           }
           setImage("ani1-jump.jpg");
        } 
    }
    /**
     * circleClass-connects all the animation methods together to create the entire animation
     */
    public void circleClass(){
        setLocation(0,0);
         Greenfoot.delay(5);
        // move right
        animationRunTop();
        Greenfoot.delay(10);
        animationJumpDown();
        animationRunBack();
        animationJumpUp();
        x = 0;
        j = 0;
        returnToSeat();
         
    }
    /** 
     *  prints myHobby
     */
    public void myHobby(String s) {
         System.out.println(s);
     }

}