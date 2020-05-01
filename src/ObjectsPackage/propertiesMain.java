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
 */

public class propertiesMain {
    public static void main(String[] args) {
        // Brown
        MonopolyProperty mediterraneanAve = new MonopolyProperty(1,"Mediterranean Avenue","Brown",60,50,2,10,30,90,160,250);
        MonopolyProperty balticAve = new MonopolyProperty(3,"Baltic Avenue","Brown",60,50,4,20,60,180,320,450);
        // Light Blue
        MonopolyProperty orientalAve = new MonopolyProperty(6,"Oriental Avenue","Light Blue",100,50,6,30,90,270,400,550);
        MonopolyProperty vermontAve = new MonopolyProperty(8,"Vermont Avenue","Light Blue",100,50,6,30,90,270,400,550);
        MonopolyProperty connecticutAve = new MonopolyProperty(9,"Connecticut Avenue","Light Blue",120,50,8,40,100,300,450,600);
        // Pink
        MonopolyProperty stCharlesPlace = new MonopolyProperty(11,"St. Charles Place","Pink",140,100,10,50,150,450,625,750);
        MonopolyProperty statesAve = new MonopolyProperty(13,"States Avenue","Pink",140,100,10,50,150,450,625,750);
        MonopolyProperty virginiaAve = new MonopolyProperty(14,"Virginia Avenue","Pink",160,100,12,60,180,500,700,900);
        // Orange
        MonopolyProperty stJamesPlace = new MonopolyProperty(16,"St. James Place","Orange",180,100,14,70,200,550,750,950);
        MonopolyProperty tennesseeAve = new MonopolyProperty(18,"Tennessee Avenue","Orange",180,100,14,70,200,550,750,950);
        MonopolyProperty newYorkAve = new MonopolyProperty(19,"New York Avenue","Orange",200,100,16,80,220,600,800,1000);
        // Red
        MonopolyProperty kentuckyAve = new MonopolyProperty(21,"Kentucky Avenue","Red",220,150,18,90,250,700,875,1050);
        MonopolyProperty indianaAve = new MonopolyProperty(23,"Indiana Avenue","Red",220,150,18,90,250,700,875,1050);
        MonopolyProperty illinoisAve = new MonopolyProperty(24,"Illinois Avenue","Red",240,150,20,100,300,750,925,1100);
        // Yellow
        MonopolyProperty atlanticAve = new MonopolyProperty(26,"Atlantic Avenue","Yellow",260,150,22,110,330,800,975,1150);
        MonopolyProperty ventnorAve = new MonopolyProperty(27,"Ventnor Avenue","Yellow",260,150,22,110,330,800,975,1150);
        MonopolyProperty marvinGardens = new MonopolyProperty(29,"Marvin Gardens","Yellow",280,150,24,120,360,850,1025,1200);
        // Green
        MonopolyProperty pacificAve = new MonopolyProperty(31,"Pacific Avenue","Green",300,200,26,130,390,900,1100,1275);
        MonopolyProperty northCarolinaAve = new MonopolyProperty(32,"North Carolina Avenue","Green",300,200,26,130,390,900,1100,1275);
        MonopolyProperty pennsylvaniaAve = new MonopolyProperty(34,"Pennsylvania Avenue","Gree",320,200,28,150,450,1000,1200,1400);
        // Dark Blue
        MonopolyProperty parkPlace = new MonopolyProperty(37,"Park Place","Dark Blue",350,200,35,175,500,1100,1300,1500);
        MonopolyProperty boardwalk = new MonopolyProperty(39,"Boardwalk","Dark Blue",400,200,50,200,600,1400,1700,2000);
        // Railroads
        Railroad readingRailroad = new Railroad(5,"Reading Railroad");
        Railroad pennsylvaniaRailroad = new Railroad(15,"Pennsylvania Railroad");
        Railroad boRailroad = new Railroad(25,"B. & O. Railroad");
        Railroad shortLine = new Railroad(35,"Short Line");
        //Utilities
        Utilities electricCompany = new Utilities(12,"Electric Company");
        Utilities waterWorks = new Utilities(28,"Water Works");
    }
}