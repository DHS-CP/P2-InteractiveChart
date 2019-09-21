import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**

 * Write a description of class Classroom here.
 *
 * @author (your name)
 * @version (a version number or a date)

**/

public class Classroom extends World
{
    private ArrayList<Object> listo = new ArrayList<Object>();
    /**
     * Constructor for objects of class Classroom.
     *
     */
    public Classroom()
    {
        // Create a new world with 10x6 cells with a cell size of 130x130 pixels.
        super(10, 6, 130);

        prepare();
    }



    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world. This incorporates the SoumyaKakarlapudi class.
     */

     private void prepare()

    {
        // Add three lines to this doc with your class constructor and your row and seat number
        // Make sure to match your first and lasts name to the class file you created.


        /* Example */

        NihaSuravarjjala nihasuravarjjala = new NihaSuravarjjala("Niha", "Suravarjjala", 4, 4);
        addObject(nihasuravarjjala, 4, 4);
        nihasuravarjjala.sitDown();

        JoshBeatty joshbeatty = new JoshBeatty("Josh", "Beatty", 1, 2);
        addObject(joshbeatty, 2, 1);
        joshbeatty.sitDown();


        joshkoh jish = new joshkoh("Josh", "Koh", 2 , 3);
        addObject(jish, 2, 3);
        jish.sitDown();

        JonathanWang jonathanwang = new JonathanWang("Jonathan", "Wang", 4, 7);
        addObject(jonathanwang, 4, 7);
        jonathanwang.sitDown();


        RupaliSarathy rupalisarathy = new RupaliSarathy("Rupali", "Sarathy", 4, 3);
        addObject(rupalisarathy, 1, 1);
        rupalisarathy.sitDown();

        RinaKaura rinakaura = new RinaKaura("Rina", "Kaura", 2, 2);
        addObject(rinakaura, 2, 2);
        rinakaura.sitDown();




        HrishikKandula hrishikkandula = new HrishikKandula("Hrishik", "Kandula", 2, 1);
        addObject(hrishikkandula, 2, 1);
        hrishikkandula.sitDown();


        SoumyaKakarlapudi soumyakakarlapudi = new SoumyaKakarlapudi("Soumya", "Kakarlapudi", 1, 7);
        addObject(soumyakakarlapudi, 1, 7);
        soumyakakarlapudi.sitDown();


       SamikshaYelthimar samikshayelthimar = new SamikshaYelthimar ("Samiksha", "Yelthimar", 5, 6);
        addObject(samikshayelthimar, 5, 6);
        samikshayelthimar.sitDown();


        ManognaNamburu manognaNamburu = new ManognaNamburu("Manogna", "Namburu", 1, 1);
        addObject(manognaNamburu, 1, 1);
        manognaNamburu.sitDown();

        RitviksiddhaPenchala ritvik = new RitviksiddhaPenchala();
        addObject(ritvik, 5, 3);
        ritvik.sitDown();

        EthanLau ethanlau  = new EthanLau("Ethan", "Lau", 5, 2);
        addObject(ethanlau, 5, 2);
        ethanlau.sitDown();

        LikhitGudisay likhitgudisay = new LikhitGudisay("Likhit", "Gudisay", 1, 4);
        addObject(likhitgudisay, 1, 4);
        likhitgudisay.sitDown();

        ParthJoshi parthjoshi = new ParthJoshi("Parth", "Joshi", 1, 6);
        addObject(parthjoshi, 1, 6);
        parthjoshi.sitDown();

        VikasUmmadisetty vikasu = new VikasUmmadisetty("Vikas", "Ummadisetty", 4,5);
        addObject(vikasu, 4, 5);
        vikasu.sitDown();

        Avi avipatel = new Avi("Avi", "Patel", 3, 4);
        addObject(avipatel, 3, 4);
        avipatel.sitDown();

        LacPhongNguyen lacphongnguyen = new LacPhongNguyen("Lac-Phong", "Nguyen", 3, 1);//creates LacPhong object
        addObject(lacphongnguyen, 3, 1);//adds object LacPhong into the world
        lacphongnguyen.sitDown();//makes LacPhong sit down in the beginning


        GenePan gene = new GenePan("Gene", "Pan", 3, 3);
        addObject (gene, 3, 3);
        gene.sitDown();

        DaylenBoen daylen = new DaylenBoen("Daylen", "Boen", 5, 3);
        addObject (daylen, 3, 3);
        daylen.sitDown();
    }
}
