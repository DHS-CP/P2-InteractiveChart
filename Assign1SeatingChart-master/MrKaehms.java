import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "MrKaehms class is a child class of the Teacher class.
 * It includes additional features besides those inherited from the Teacher class that are to be added to the MrKaehms actor.
 * 
 * @author Samiksha Yelthimar 
 * @version 9/11/2019
 */
public class MrKaehms extends Teacher //implements JustForFun
{
    /**
     * This method sets the MrKaehms actor's location to the values of mySeat and myRow
     */

    public MrKaehms () {

    setLocation(mySeat,myRow);
 
    }
    
    /**
     * This method plays Mr.Kaehms's audiofile when his actor is clicked on.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
         //   getName(); 
              sayName("bobkaehms.wav");
        }
    } 
    
    /**
     * This void method prints out "My Name is Bob Kaehms"
     */
    public void getName(){
        System.out.println("\n My name is Bob Kaehms");
    }
}
