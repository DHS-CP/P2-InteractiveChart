import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The SoumyaKakarlapudi class can be used as a model for your own class that represents you and your seating location in AP CSA.
 * This class allows the character to move, display a message, and answer questions from a pre-determined response.
 *
 * @Soumya Kakarlapudi
 * @version 2.0 September 11, 2019
 */
public class SoumyaKakarlapudi extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the SoumyaKakarlapudi class.
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
    public SoumyaKakarlapudi(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".png";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standinggg.png";
       soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
       numStudents ++;
       System.out.println(numStudents);
    }
    /**
     * Default constructor, sets the constructors to a value for the name,row/seat, and image file when sitting or standing.
     * Sets the Image and appears in the world.
     */
    public SoumyaKakarlapudi() {
        firstName="Soumya";
        lastName="Kakarlapudi";
        myRow=1;
        mySeat=7;
       //imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".png";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standinggg.png";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
       numStudents ++;
    }

     /**
     * When the world is intialized, the default is a sitting portrait of the student and displays a message of the favorite hobby. Also
     * includes a verbal speech of the name and does an animation defined in circleClass method.
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

                myHobby("I like to watch TV!");
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
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("Hello, Ask me which subjects I thought were hard. ");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, linear search , and booleans... Which subject would you like to know about?");



      }
        else if(q.contains("students")){
            q=Greenfoot.ask("There are" + numStudents + "students in the class");

        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?");
        }

        if (q.contains("2D arrays")){
            q=Greenfoot.ask("The elements of a 2D array are arranged in rows and columns, and the new operator for 2D arrays specifies both the number of rows and the number of columns. May I sit down now? ");
        }
        if (q.contains("linear search")){
            q=Greenfoot.ask("Linear search is used to search a key element from multiple elements. May I sit down now?");
        }
        if (q.contains("booleans")){
            q=Greenfoot.ask("Linear search is used to search a key element from multiple elements. May I sit down now?");
        }

        if (q.equals("yes")){

            Greenfoot.delay(10);
            sitDown();
            Greenfoot.stop();
        }


    }

    /**
     * This is a local public void method specific to the SoumyaKakarlapudi class used to animate the character once the image is clicked on.
     * This uses a Math.random function to take the student around the classroom first. Then a series of 2D arrays are used to create a up and zigzag
     * animation on the classroom.  Finally, it returns to the seat before the student is asked questions.
     */
    public void circleClass(){
        setLocation(0,0);

        Greenfoot.delay(10);



     // move back
        for (int i=1;i<=3;i++){

            setLocation(i,((int)(Math.random()*6)+1));

            Greenfoot.delay(10);

        }
         // move left
        for (int i=9;i>=0;i--){
            for(int j=3; j<=7;j++){
            setLocation(i,j);

            Greenfoot.delay(10);
        }
    }
              // move Forward
        for (int i=5;i>=0;i++){
            for(int j=6; j>=7;j--){
            setLocation(i,j);
            Greenfoot.delay(10);
        }
    }

           Greenfoot.delay(10);
           returnToSeat();


    }
    /**
     * This is a void method that prints my hobby on a new line when the function is run
    */
     public void myHobby(String s) {
         System.out.println(s);
}

}
