import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates Mr. Kaehms as a teacher in this classroom
 * 
 * @author Parth Joshi 
 * @version 09/11/19
 */
public class MrKaehms extends Teacher //implements JustForFun
{
    

   
    /**
    * This methodsets location of the Mt.Kaehms object
    */
    public MrKaehms () {

        setLocation(mySeat,myRow);
 
    }
    
    /**
    * This method gives the action for the Mr.Kaehms object
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
    * This method says the name of the object
    */
    public void getName(){
        System.out.println("\n My name is Bob Kaehms");
    }
}
