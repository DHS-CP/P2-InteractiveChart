import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The GenePan class sets the image, soundfile, seating location, specific questions, hobbies, and 
 * special behaviors of a GenePan object.
 * 
 * @author Gene Pan
 * @version 1.0 Aug 26, 2019
 */
public class GenePan extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{
    private String actionFile; //sets the image for part of the behavior
    private int actionM[][] = new int[3][3]; //sets a 3x3 2d array for the action behavior
    private boolean followUp = false;
    private int siblings = 2;
    private int brothers = 1;
    private int sisters = 1;
    
    /**
     * Constructor for the Gene Pan class.
     * This constructor is overloaded with another constructor below. If this function is called upon including the parameters below,
     * it will call upon this function. If no parameters are specified, it will call upon the other function. This function allows for
     * the GenePan object to be created in a different place than the default.
     */
    public GenePan(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        actionFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-poof.jpg";
        setImage(portraitFile); 
        sitting=true;
        numStudents++;
    }
    /**
     * Default constructor. If no parameters are specified when creating a GenePan object, it will set certain default options.
     * It sets my name, row, seat, and image files.
     */
    public GenePan() {
        firstName="Gene";
        lastName="Pan";
        myRow=3;
        mySeat=3;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        actionFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-poof.jpg";
        setImage(portraitFile);
        sitting=true;
    }
     /**
     * Act - do whatever the Gene Pan actor wants to do. This method is called whenever
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
            
                myHobby("I like to sleep!");
                FamilyMembers();
                goPoof();  // Gene Pan's unique method. I disappear with a comic-like "poof"
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
        System.out.println("Hi! I'm " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends. There are two possible questions to ask:
     * "What was hard?" and "How's your day?". If the student is asked "What was hard?", it switches a boolean called followUp
     * to true. If this boolean is true, the answerFollowUp function is called if the user does not allow the student to sit.
     * This allows a second set of follow-up questions to be asked. See that function's documentation for more detail.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        followUp = false;
        if (q.contains("hard")){ //What was hard?
            q=Greenfoot.ask("A lot of second semester got pretty tough. Interfaces, array lists, abstractions, sorts, and 2D arrays... May I sit down?");
            followUp = true;
        
        }
        //the below question does not have a follow up questions
        else if (q.contains("day")){ //How's your day?
            q=Greenfoot.ask("Good enough. I finished AP Physics for the day... May I sit down?");
            
        }
        else if (q.contains("many")){ //How's your day?
            q=Greenfoot.ask("There are " + numStudents + " students in this class. May I sit down?");
            
        }
        else {
            q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            
        }
        if (q.equals("yes")){ //sit down after teacher allows it
            Greenfoot.delay(10);
            sitDown();
        }        
        else {
            if (followUp==true) { //if there are any followup questions, prepare to answer
                answerFollowUp();
            } 
            else{
                answerQuestion();
            }
        }
    }
    /**
     * This method is to allow for follow-up questions after being asked about what was hard in AP CSA.
     * It has one question for each of the 5 topics I mentioned as hard. It has the same question-answer interface as the normal
     * answering function, but the questions are different. This is to allow for clearer organization.
     */
    
    public void answerFollowUp(){
        String q=Greenfoot.ask("What else would you like to know?");
        if (q.contains("interface")){ //What was hard about interfaces?
            q=Greenfoot.ask("The purpose behind interfaces was difficult to decipher. From what I understand, it's simply to allow another level of organization, which at first seemed unnecessary. May I sit down?");
        
        }
        else if (q.contains("array")){ //What was hard about arraylists?
            q=Greenfoot.ask("The arraylists were tough for me I think mainly just because it was the first thing we did in second semester, and it was noticeably tougher than the first. The syntax was confusing, and things were harder to follow. May I sit down?");
        
        }
        else if (q.contains("sort")){ //What was hard about sorts?
            q=Greenfoot.ask("I understood how the sorts worked, but not why we used them. The speeds of each were explained too abstractly. May I sit down?");
        
        }
        else if (q.contains("abstractions")){ //What was hard about abstractions?
            q=Greenfoot.ask("The purpose behind abstractions was difficult to decipher. From what I understand, it's simply to allow another level of organization, which at first seemed unnecessary. May I sit down?");
        
        }
        else if (q.contains("2D")){ //What was hard about 2D arrays?
            q=Greenfoot.ask("2D arrays were difficult for me to iterate through, as you need two levels of for loops. May I sit down?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){ //sit down after teacher allows it
            Greenfoot.delay(10);
            sitDown();
        }    
        else { //if there are any follow-up questions, prepare to answer
            answerFollowUp();
        }  
    }
    /**
     * This is a local method specific to the GenePan class used to animate the character once the image is clicked on.
     * For my behavior, I had my image slowly get smaller until it dissappears, changing image to a cartoon "poof"
     * There is an element of randomization using a 2d array. How much smaller my image gets is randomized for each "round"
     * it gets smaller by iterating through a 2d array. When it is initialized, I set each of the elements to randomize. I have
     * my behavior iterate through these randomized elements to determine by what scale my images decrease.
     */
    public void goPoof(){
        for (int row = 0; row < actionM.length; row++) { //populating the 3x3 2d array made above
            for (int col = 0; col < actionM[row].length; col++) { 
                actionM[row][col] = (int)(Math.random()*10);
            }
        }
        for (int i = 0; i<actionM.length; i++){ //iterating through the array, decreasing size according to each element of the array
            for (int j = 0; j<actionM[i].length; j++){
                int shrink = actionM[i][j];
                
                GreenfootImage image = getImage();
                image.scale(image.getWidth() - shrink, image.getHeight() - shrink);
                setImage(image);
                Greenfoot.delay(10);
            }
        }
        Greenfoot.delay(30);
        setImage(actionFile); //makes the image into the poof
        Greenfoot.delay(50);
        for (int i=1;i<=5;i++){ //shrink poof at constant rate
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 20, image.getHeight() - 20);
            setImage(image);
            Greenfoot.delay(10);
        }
        setImage(standingFile); //set image back to regular standing file
    }
    /**
     * This method simply prints out a sentence saying what our hobby is. For my hobby, I chose sleeping.
     */
    public void myHobby(String s) {
         System.out.println(s);
    }
    /**
     * This method implements an interface NumberoOfSiblings to call upon private variables to know how many siblings I have
     */
    public void FamilyMembers() {
        System.out.println("I have " + numberOfSiblings() + " siblings: " + numberOfBrothers() + " brother, and " + numberOfSisters() + " sister." );
    }
    
    //returns private variable siblings
    public int numberOfSiblings(){
        return siblings;
    }
    //returns private variable brothers
    public int numberOfBrothers(){
        return brothers;
    }
    //returns private variable sisters
    public int numberOfSisters(){
        return sisters;
    }
    
}