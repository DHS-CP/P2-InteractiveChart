import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class which puts my 'character' into the proper position in the class
 *
**/
public class DaylenBoen extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{

    /**
     * Constructor for the DaylenBoen class.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     *
     */
    public DaylenBoen(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"sitting" + ".jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public DaylenBoen() {
        firstName="Daylen";
        lastName="Boen";
        myRow=3;
        mySeat=2;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"sitting" + ".jpg";
        soundFile="daylenboen.wav";
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }

     /**
     * Act - do whatever the DaylenBoen actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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

                myHobby("I read a lot of comic books...");

                slideClass();  // Own personal movement class
            }
            else {
                answerQuestion(); //calls conversation
                sitDown(); //sits down character
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
     * Method that deals with conversation. Uses if/else chains and recursion to create a continuous flow.
     * NumberOfSiblings implemented here
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("Interfaces, 2D arrays, constructors, recursion, and maybe static vs instance variables. May I sit down?");
            if (q.contains("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else if (q.contains("no")) {
                q=Greenfoot.ask("What else would you like to know?");
                if (q.contains("Interfaces") || q.contains("interfaces")){
                   q=Greenfoot.ask("I just have a hard time understanding the concept, and when/why you should use it...May I sit down?");
                   if (q.contains("yes")){
                       Greenfoot.delay(10);
                       sitDown();
                   }
                   else if(q.contains("no")){
                       answerQuestion();
                   }
                }
            }
        }
        else if(q.contains("brother") || q.contains("brothers") ){
            q=Greenfoot.ask("I have " + numberOfBrothers() + " brothers. It would be cool to have one though. May I sit down?");
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else if(q.contains("no")){
                    answerQuestion();
                }
        }
        else if(q.contains("sister") || q.contains("sisters")){
            q=Greenfoot.ask("I have " + numberOfSisters() + " sister. She's a freshman now at this school. May I sit down?");
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else if(q.contains("no")){
                    answerQuestion();
                }
        }
        else if(q.contains("siblings")){
            q=Greenfoot.ask("I have " + numberOfSiblings() + " sibling. May I sit down?");
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else if(q.contains("no")){
                    answerQuestion();
                }
        }

    }

    public int numberOfSisters() {
        return 1;
    }

    public int numberOfSiblings() {
        return 1;
    }

    public int numberOfBrothers() {
        return 0;
    }

    /**
     * Method that performs an animation once image is clicked. Iterates through 2D arrays to deal with movement, and math.random for a random rotation.
     */
    public void slideClass(){
        int tempRow; //used to change row of image
        int tempSeat; //used to change seat of image
        //Math.random is used to generate a random number with a minium of row, column 1,1 and a maximum of row, column 7, 7. It is used
        //to place my profile picture randomly in the classroom. It is also used to set my rotation randomly each time I change.
        int [][] seatLayout = new int[10][5]; //declaring a 2d array with rough estimates of the dimension of the classroom

        for (int i = 0; i < 10; i++) {
            setRotation((int)(Math.random() * 360));
            for (int j = 0; j < 10; j++) {
                tempRow = i;
                tempSeat = j;
                Greenfoot.delay(2);
                setLocation(tempRow,tempSeat);
            }
        }


        for (int j = 5; j >= myRow; j--) {
            setRotation((int)(Math.random() * 360));
            for (int i = 10; i >= mySeat; i--) {
                tempRow = i;
                tempSeat = j;
                Greenfoot.delay(2);
                setLocation(tempRow,tempSeat);
            }
        }
        setRotation(0); //makes image go back to original rotation

    }
     public void myHobby(String s) {
         System.out.println(s);
}

}
