import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * The actor HariniGurusankar is in a seated position until clicked upon, where the actor changes to a standing position and performs an animation.
 * Then, the actor answers a series of questions posed by the user relating to the CSA summer homework and personal questions.
 * 
 * @author Harini Gurusankar 
 * @version 09/04/19
 */
public class HariniGurusankar extends Student implements SpecialInterestOrHobby, StudentAthlete 
{

    boolean flag;
    /**
     * The following two methods sets the actor's image to the sitting position.
     * They also set the sound and standing image for future reference.
     * @return true for image=portraitFile
     */
    public HariniGurusankar(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.JPG";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        flag = true;
        super.numStudents +=1;
    }
    public HariniGurusankar() {
       
        firstName="Harini";
        lastName="Gurusankar";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.JPG";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    public void act() 
    {
       /**
        * This is the act method. When the image is clicked, the sitting image changes to the standing file. The getName method is also called.
        * The animation method is called and the sound file is called to play the name pronounciation.
        * The interfaces SpecialInterestOrHobby and StudentAthlete are called and the following Strins are printed.
        * Then, the answerQuestion method is called, and the sitDown method is called.
        */
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to read");
                mySport("I am a dancer.");
                
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                moveImage();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    public void getName(){
        /**
         * This method prints the name of the actor, which is Harini Gurusankar.
         */
        System.out.println("My name is " + firstName + " " + lastName);
    }
    public void answerQuestion(){
        /**
         * This method has a series of if-else statements, prompting Greenfoot to display a different answer for each code word programmed.
         * If a code word is not understood, the actor will ask to sit down.
         */
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("Recursion, ArrayLists, interfaces, and for loops... May I sit down?");
        
        }
       
        if (q.contains("recursion")) {
            q=Greenfoot.ask("Recursion is a process in which a method calls itself continuously... May I sit down?");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.contains("ArrayLists")) {
            q=Greenfoot.ask("ArrayLists are resizable arrays, also known as dynamic arrays...May I sit down?");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.contains("interfaces")) {
            q=Greenfoot.ask("Interfaces are a mechanism in Java that only has abstract methods... May I sit down?");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(1);
            sitDown();
        }
        
    }
  

    public void moveImage(){
        /**
         * This method causes a random movement of the actor based on the iteration of a 2d array.
         * Then the returntoSeat method is called so that the actor goes back to its original position and then changes back to a sitting image.
         */
      
         int size[][]=new int[30][2];
        for(int i=0; i<size.length; i++) {
        for(int j=0; j<size[i].length; j++) {
                size[i][size[i].length-1] = (int)(Math.random()*10);
                size[j][size[j].length-1] = (int)(Math.random()*20);
                setLocation(size[i][size[i].length-1],size[j][size[j].length-1]);
                Greenfoot.delay(3);
        
           
           returnToSeat(); }
           

}
 }
public void myHobby(String s) {
    /**
     * This method calls the SpecialInterestOrHobby interface to print the String s.
     */
         System.out.println(s);
}
public void mySport (String d) {
    /**
     * This method calls the StudentAthlete interface to print the String d.
     */
    System.out.println(d);
}}

