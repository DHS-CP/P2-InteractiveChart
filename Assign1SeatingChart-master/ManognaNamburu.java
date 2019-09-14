import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * In this class, which is derived from the student class, is used to set the factors related to my specific seat.
 * It contains my seat and row number, has an animation, and ends with an interactive dialogue session with the user.
 * @author Manogna Namburu
 * @version version 1.0
 */
public class ManognaNamburu extends Student
{
    /**
     * Constructor for the ManognaNamburu class.
     * It has the same exact name as the class name.  
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public ManognaNamburu(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=2;
        mySeat=7;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile="manognanamburu.wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * The first and last name are set
     * The row and seat number are set
     * Sitting is set to true meaning that the original position is when the potrait file picture is activated
     *
     */
    public ManognaNamburu() {
        firstName="Manogna";
        lastName="Namburu";
        myRow=2;
        mySeat=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile="sounds/manognanamburu.wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * When the picture, sitting down, us is clicked the sitting turns to false and so the standing file takes over
     * The picture would they say the name 
     * The circle class would be called
     * An interface is added, says hobby
     * Once the circle class runs and the questions run, the picture would sit down again.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                 myHobby("I like to spend time with friends!");
                 NumOfSiblings("I have 1, a younger sister");
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
             
                
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
     * This method allows an user interaction to ask questions related AP CSA summer hw.
     * It first asks which were the hard topics.
     * Then it can further explain on that topic if the user wishes to know.
     * To access the extra information, the string AskQuestions method is called.
     * Once the questions are asked and answered, the picture would sit back down.The CanISitDown method would be called.
     */
    public void answerQuestion(){
        
          String q=Greenfoot.ask("What would you like to know");
          
         
           
            if (q.contains("hard")){
                q=Greenfoot.ask("2D arrays, binary, merge sort, booleans and recursion, do want to know more about any one of them?(Say yes)");
                if (q.contains("yes")){
              
                     q = Greenfoot.ask("Ok, which one do you want to know?");
                     boolean say = true;
                     while (say)
                     {
                         q = AskQuestion(q);
                         
                           
                         if (q.contains("nothing")){
                             say=false;
                             CanISitDown();
                            } 
                            else q= Greenfoot.ask(q);
                         }
                         
                
                        }else CanISitDown();
                        }
                        
                else if(q.contains("students"))
             q= Greenfoot.ask ("There are" + "" + numStudents);
             
               else
            {
                CanISitDown();
            }  
}
               
           
            
  /**
     * This is a string method that would be called in the previous method.
     * This only runs if the user clicks yes, to know more in dept
     */
        public String AskQuestion(String q)
        {
            String returnString ="nothing";
            if (q.contains("2D array"))
                returnString = "2D arrays were difficult for me since I was not sure when to implement them, any other topic?";
           else if(q.contains("boolean"))
                returnString = "Boolean statements take me some time to decode and I have to put in more attention to them , any other topic?";
           else if(q.contains("students"))
              returnString = ("There are " + numStudents + " students in this class");
           else if(q.contains("binary"))
                returnString = "The conversion between a base ten to a binary number requires that I have to pay a closer attention, any other topic?";
           else if(q.contains("recursion"))
                returnString = "The order of the final answers given from the loop sometimes confuse me,any other topic?";
           else if(q.contains("merge sort"))
                returnString = "Merge sort is difficult since it requires the array to be broken down multiple times causing more complexity, any other topic??";
                return returnString;
        }
        
                   
  /**
     * This is a method that would be called in the answer question method. 
     * It allows the program to sit back down.
    
     */
        public void CanISitDown()
        {
                        String q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
                        if (q.equals("yes")){
                        Greenfoot.delay(10);
                        sitDown();
                       }
        }
    
    
     /**
     * This is a method that is called in the act method.
     * It performs an animation that lasts for seven seconds.
     * It first uses math random to move between random digits between 0 and 7.(Creates a zig zag pattern)
     * Then the rest use 2D arrays to move in an organized routine.
     * After its over, it goes back to its seat.
     * Also calls the hobby method
     */
 
    public void circleClass(){
        //setLocation(0,0);
         Greenfoot.delay(10);
         
         for (int i=7; i>=0;i--){
             setLocation(i,  (int)Math.round(Math.random()*7));
             setRotation(60);
             Greenfoot.delay(10);
        }
        
        
         for (int i=7; i>=0;i--){
           for (int j=2; j>=2;j--){  
             setLocation(i, j);
             setRotation(60);
             Greenfoot.delay(10);
            }
        }
        for (int i=0; i<=0;i++){
           for (int j=3; j<=8;j++){  
             setLocation(i,j);
              setRotation(90);
             Greenfoot.delay(10);
            }
        }
        
        for (int i=0; i<=0;i++){
           for (int j=8; j>=2;j--){  
             setLocation(i,j);
              setRotation(180);
             Greenfoot.delay(10);
            }
        }
        
        for (int i=0; i<=7;i++){
           for (int j=2; j>=2;j--){  
             setLocation(i,j);
              setRotation(60);
             Greenfoot.delay(10);
            }
        }
        for (int i=7; i>=7;i--){
           for (int j=3; j<=8;j++){  
             setLocation(i,j);
             Greenfoot.delay(10);
            }
        }
        for (int i=7; i>=7;i--){
           for (int j=8; j>=2;j--){  
             setLocation(i,j);
              setRotation(360);
             Greenfoot.delay(10);
            }
        }
       
       
           Greenfoot.delay(10);
           returnToSeat();
        }
         public void myHobby(String s) {
         System.out.println(s);
}
 public void NumOfSiblings(String p) {
         System.out.println(p);
}
    }
    
