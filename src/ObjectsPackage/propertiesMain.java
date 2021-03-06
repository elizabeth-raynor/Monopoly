/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Zeke Farkas
 * Section: 11am
 * Date: 4/22/2020
 * Time: 12:02 AM
 *
 * Project: csci205finalprojectSP2020
 * Package: ObjectsPackage
 * Class: propertiesMain
 *
 * Description:
 *
 * ****************************************
 */
package ObjectsPackage;

/**
 * This is just a temp class where I am setting all of the initiallized properties
 * @Author Zeke Farkas
 */

public class propertiesMain {

    public MonopolyProperty mediterraneanAve;
    public MonopolyProperty balticAve;
    public MonopolyProperty orientalAve;
    public MonopolyProperty vermontAve;
    public MonopolyProperty connecticutAve;
    public MonopolyProperty stCharlesPlace;
    public MonopolyProperty statesAve;
    public MonopolyProperty virginiaAve;
    public MonopolyProperty stJamesPlace;
    public MonopolyProperty tennesseeAve;
    public MonopolyProperty newYorkAve;
    public MonopolyProperty kentuckyAve;
    public MonopolyProperty indianaAve;
    public MonopolyProperty illinoisAve;
    public MonopolyProperty atlanticAve;
    public MonopolyProperty ventnorAve;
    public MonopolyProperty marvinGardens;
    public MonopolyProperty pacificAve;
    public MonopolyProperty northCarolinaAve;
    public MonopolyProperty pennsylvaniaAve;
    public MonopolyProperty parkPlace;
    public MonopolyProperty boardwalk;

    public Utilities electricCompany;
    public Utilities waterWorks;

    public Railroad readingRailroad;
    public Railroad pennsylvaniaRailroad;
    public Railroad boRailroad;
    public Railroad shortLine;

    public propertiesMain() {
        initProperties();
        initRR();
        initUtils();
    }

    public void initProperties() {
        // Brown
        mediterraneanAve = new MonopolyProperty(1,"Mediterranean Avenue","Brown",60,50,2,10,30,90,160,250);
        balticAve = new MonopolyProperty(3,"Baltic Avenue","Brown",60,50,4,20,60,180,320,450);
        // Light Blue
        orientalAve = new MonopolyProperty(6,"Oriental Avenue","Light Blue",100,50,6,30,90,270,400,550);
        vermontAve = new MonopolyProperty(8,"Vermont Avenue","Light Blue",100,50,6,30,90,270,400,550);
        connecticutAve = new MonopolyProperty(9,"Connecticut Avenue","Light Blue",120,50,8,40,100,300,450,600);
        // Pink
        stCharlesPlace = new MonopolyProperty(11,"St. Charles Place","Pink",140,100,10,50,150,450,625,750);
        statesAve = new MonopolyProperty(13,"States Avenue","Pink",140,100,10,50,150,450,625,750);
        virginiaAve = new MonopolyProperty(14,"Virginia Avenue","Pink",160,100,12,60,180,500,700,900);
        // Orange
        stJamesPlace = new MonopolyProperty(16,"St. James Place","Orange",180,100,14,70,200,550,750,950);
        tennesseeAve = new MonopolyProperty(18,"Tennessee Avenue","Orange",180,100,14,70,200,550,750,950);
        newYorkAve = new MonopolyProperty(19,"New York Avenue","Orange",200,100,16,80,220,600,800,1000);
        // Red
        kentuckyAve = new MonopolyProperty(21,"Kentucky Avenue","Red",220,150,18,90,250,700,875,1050);
        indianaAve = new MonopolyProperty(23,"Indiana Avenue","Red",220,150,18,90,250,700,875,1050);
        illinoisAve = new MonopolyProperty(24,"Illinois Avenue","Red",240,150,20,100,300,750,925,1100);
        // Yellow
        atlanticAve = new MonopolyProperty(26,"Atlantic Avenue","Yellow",260,150,22,110,330,800,975,1150);
        ventnorAve = new MonopolyProperty(27,"Ventnor Avenue","Yellow",260,150,22,110,330,800,975,1150);
        marvinGardens = new MonopolyProperty(29,"Marvin Gardens","Yellow",280,150,24,120,360,850,1025,1200);
        // Green
        pacificAve = new MonopolyProperty(31,"Pacific Avenue","Green",300,200,26,130,390,900,1100,1275);
        northCarolinaAve = new MonopolyProperty(32,"North Carolina Avenue","Green",300,200,26,130,390,900,1100,1275);
        pennsylvaniaAve = new MonopolyProperty(34,"Pennsylvania Avenue","Gree",320,200,28,150,450,1000,1200,1400);
        // Dark Blue
        parkPlace = new MonopolyProperty(37,"Park Place","Dark Blue",350,200,35,175,500,1100,1300,1500);
        boardwalk = new MonopolyProperty(39,"Boardwalk","Dark Blue",400,200,50,200,600,1400,1700,2000);
    }

    private void initUtils() {
        //Utilities
        electricCompany = new Utilities(12,"Electric Company");
        waterWorks = new Utilities(28,"Water Works");
    }

    private void initRR() {
        // Railroads
        readingRailroad = new Railroad(5,"Reading Railroad");
        pennsylvaniaRailroad = new Railroad(15,"Pennsylvania Railroad");
        boRailroad = new Railroad(25,"B. & O. Railroad");
        shortLine = new Railroad(35,"Short Line");
    }
}