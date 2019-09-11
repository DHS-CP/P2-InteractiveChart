import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Likhit Gudisay
 */
public class LikhitGudisay extends Student
{
    public LikhitGudisay(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    public LikhitGudisay() {
        firstName="Likhit";
        lastName="Gudisay";
        myRow=1;
        mySeat=4;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
        /**
         * static numstudents is used to see class size
         */
        //numStudents = numStudents + 1;
    }
    public void act() {
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println("");
                getName();
                sayName(soundFile);
                circleClass();
            }
            else {
                answerQuestion();
                sitDown();
            }      
        }
    } 
    public void myHobby(String s) {
        System.out.println(s);
    }
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    public void answerQuestion(){
        /**
         * The avatar is asked a question and has programmed responses, including extra explanation on each topic ... and an unforeseen hatred of semicolons!
         */
        String q=Greenfoot.ask("Que quieres conocer?");
        if (q.contains("hard")){
            /**
             * student says the diffuculties of summer hw and expands on answer
             */
            q=Greenfoot.ask("2D arrays, abstract classes, syntax, doubles, and semicolons!! Which would you like to know more about?");
            if (q.contains("2D")){
                q=Greenfoot.ask("2D arrays are collections of data cells that are organized in a mtarix of rows and collumns. May I sit down?");
            }
            if (q.contains("abstr")){
                q=Greenfoot.ask("Abstract classes allow the child class to assign values or methods. May I sit down?");
            }
            if (q.contains("synt")){
                q=Greenfoot.ask("Syntax is important in order for your Java code to be error proof. May I sit down?");
            }
            if (q.contains("doub")){
                q=Greenfoot.ask("Doubles are a type of variable that only contain numerical values with a decimal. May I sit down?");
            }
            if (q.contains("semi")){
                q=Greenfoot.ask("Semicolons are an absolute pain and are the worst thing to ever be implemented into Java. I sincerely hope that whoever created the semicolon is happy with the pain and suffereing they have caused. May I sit down?");
            }
        }
        /*if (q.contains("student")){
            q=Greenfoot.ask("There are " + numStudents + " students in this class. May I please sit down?");
        }*/
        else {
            q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
    public void circleClass(){
        /** 
        * Math.random() is used to create a random integer for one of the array values.
        */
        double dad = Math.random();
        dad = dad * 10.0;
        int mom = (int) dad;
        /**
         * Here a 2D array is created using integer values
         */
        int[][] array = {
            {mom, 6, 4},
            {2, 9, 5},
            {3, 1, 5}
        };
        setLocation(0,0);
        Greenfoot.delay(10);
        /**
         * The array is iterated through using nested for loops
         */
        for (int i=0;i<3;i++){
            for (int j=0; j<3;j++){
                setLocation(array[i][j],array[i][j]);
                Greenfoot.delay(40);
            }
        }
        Greenfoot.delay(40);
        returnToSeat();
    }
}
