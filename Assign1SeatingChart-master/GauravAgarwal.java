    import greenfoot.*; 
    import java.lang.Math;
 /**
 * GauravAgarwal represents me in the class and my seating location in AP CSA second period; it also performs the actions that happen and the 
 * interactions with the user
 * The 2d-array called array 2d is created here that is 6 x 10 and represents the cells created in the world
 * @author Gaurav Agarwal
 * @version Sep 10, 2019
*/
public class GauravAgarwal extends Student implements myHobbyInterest, CSALearnedSoFar, StudentLeadership, StudentAthlete, NumberOfSiblings{
       int array2d [] [] = new int [6] [10];
       boolean couldNotSit = false;
       /**
         * GauravAgarwal sets up the file names for the two images and the sound file
         * It also sets up the name variables and the row/seat variables
         * @param String f (first name)
         * @param String l (last name)
         * @param int r (row number)
         * @param int s (seat number)
         * 
       */
       public GauravAgarwal(String f, String l, int r, int s) {
            firstName = f;
            lastName = l;
            myRow = r;
            mySeat = s;
            portraitFile = f.toLowerCase()+l.toLowerCase()+".jpg";
            standingFile = firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
            soundFile = f.toLowerCase()+l.toLowerCase()+".mp3";  
            setImage(portraitFile);
            sitting=true;
            numStudents ++;
       }
       /**
         * Default constructor, if you don't pass in a name and seating location
         * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
         * of the classroom.
         */
       public GauravAgarwal() {
           firstName = "Gaurav";
           lastName = "Agarwal";
           myRow = 1;
           mySeat = 1;
           portraitFile = firstName.toLowerCase()+lastName.toLowerCase()+".jpg";
           standingFile = firstName.toLowerCase()+lastName.toLowerCase()+"-standing.jpg";
           soundFile = "Sounds/"+firstName.toLowerCase()+lastName.toLowerCase()+".mp3";
           setImage(portraitFile);
           sitting = true;
       }
        
       /**
         * Act checks if GauravAgarwal can sit or not:
         * If it cannot, it stands up, plays a sound, uses the 5 interfaces, and calls the class to move around the background
         * If it can, it calls the class to answer the user's questions
       */   
       public void act() {
         if(Greenfoot.mouseClicked(this) || couldNotSit == true) {
                if (sitting || couldNotSit == true){
                    sitting = false;
                    couldNotSit = false;
                    setImage(standingFile);
                    System.out.println("");
                    getName();
                    Greenfoot.playSound("gauravagarwal.mp3");
                
                    myHobby("I like to hike and camp!");
                    learnedSoFar("I've learned a lot of about classes and initerfaces in Java in AP CSA");
                    mySport("I don't play any sports on a school team");
                    numberOfSiblings("I have one sister");
                    myRoleInLeadership("I am a boy scout leader");
                    System.out.println("There are " + numStudents + " student(s) in the class");

                    moveClass(); 
                }
                else 
                    answerQuestion();
                }    
       } 
       /**
        * getName prints the first and last name to the console
       */
       public void getName(){
           System.out.println("My name is " + firstName + " " + lastName);
       }
       /**
        * Class answerQuestion allows the user to ask questions while GauravAgarwal is standing up about what was hard in CSA and 
        * lets them know more about the one they choose
        * At the end, it asks if GauravAgarwal can sit down or not:
        *   If it can sit, it sits down
        *   If it cannot, it calls the class to move around, say his name, and use the two interfaces
        * The Class also uses the function .cotains() to parse through the user's string and look for certain words it can use to
        * answer the question
        * Finally, this class uses a second level of reasoning to expand on the first question about what was hard in the summer homework
       */
       public void answerQuestion(){
           boolean firstQuestion = false;
           boolean canUnderstand = false;
           String q = Greenfoot.ask("What would you like to know").toLowerCase();
           if (q.contains("hard")){
               q = Greenfoot.ask("I found 2D arrays, interfaces, remembering to put the semicolon, merge sort, and overloading hard. Which one would you like to know more about?");
               firstQuestion = true;
           }
           if (q.contains("array") && firstQuestion == true){
               q = Greenfoot.ask("A 2D array is an array of arrays! I actually used one to move around! Can I sit down now?");
               canUnderstand = true;
           }
           if (q.contains("interface") && firstQuestion == true){
               q = Greenfoot.ask("Java is similar to a class, but not quite; it's a collection of abstract methods. Can I sit down now?");
               canUnderstand = true;
           }
           if (q.contains("semicolon") && firstQuestion == true){
               q = Greenfoot.ask("Every command in java requires a semicolon at the end. Can I sit down now?");
               canUnderstand = true;
           }
           if (q.contains("merge") && firstQuestion == true){
               q = Greenfoot.ask("Merge sort is a divide and conquer algorithm that can sort a list from smallest to greatest. Can I sit down now?");
               canUnderstand = true;
           }
           if (q.contains("overload") && firstQuestion == true){
               q = Greenfoot.ask("Overloading a method lets two classes with the same name exist, if their argument lists are different. Can I sit down now?");
               canUnderstand = true;
           }
           if (!canUnderstand){
               q = Greenfoot.ask("I don't understand the question. Can I sit down?");
               if (q.equals("yes")){
                   Greenfoot.delay(10);
                   sitDown();
               }
               else{
                   couldNotSit = true;
                   act();
               }
           }
           if (canUnderstand){
               if (q.equals("yes")){
                   Greenfoot.delay(10);
                   sitDown();
               }
               else{
                   couldNotSit = true;
                   act();
               }
           }
       } 
    
       /**
        * randomWithRange generates a random number within the given range using Math.random
        * The class used Math.random and manipulates to create a user-given min and max value
        * @param int min (the minumum number the number generator can output)
        * @param int max (the maximum number the number generator can output)
        * @return random number between min and max values
        */
       public int randomWithRange(int min, int max){
           int rangevalue = (max - min) + 1;     
           return (int)(Math.random() * rangevalue) + min;
       }
    
       /**
        * moveClass moves GauravAgarwal around the background using a 2d array and the random number generator class and returns him to his 
        * seat in the end
        * The nested for loops interate through the 2d array and set the location to the indexes of the 2d array
        */
       public void moveClass(){
            setLocation(0,0);
            Greenfoot.delay(5);
            for (int i = 0; i < array2d.length; i++){
                for (int j = 0; j < array2d[0].length; j++){
                setLocation(i,j);
                setRotation(randomWithRange(0,360));
                Greenfoot.delay(2);
                }
            }
            Greenfoot.delay(2);
            returnToSeat();
       }
       /**
        * myHobby prints out the string from the abstract class
        * @param String s (string that is printed)
        */
       public void myHobby(String s) {
            System.out.println(s);
       }
       /**
        * learnedSoFar prints out the string from the abstract class
        * @param String t (string that is printed)
        */
       public void learnedSoFar(String t){
           System.out.println(t);
       }
       /**
        * mySport prints out the string from the abstract class
        * @param String k (string that is printed)
        */
       public void mySport(String k) {
           System.out.println(k);
       }
       /**
        * numberOfSiblings prints out the string from the abstract class
        * @param String l (string that is printed)
        */
       public void numberOfSiblings(String l){
           System.out.println(l);
       }
       /**
        * myRoleInLeadership prints out the string from the abstract class
        * @param String m (string that is printed)
        */
        public void myRoleInLeadership(String m){
          System.out.println(m);
       }

}