package ObjectsPackage;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 4/15/2020
 * Time: 9:15 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: PACKAGE_NAME
 * Class: ObjectsPackage.Player
 *
 * Description: Class used to set up player object
 *
 * ****************************************
 */


import java.util.ArrayList;

/**
 * Main class used to create a new player object and manipulate its variables
 * @author Michelle Pham
 */
public class Player {

    /** ObjectsPackage.Player's game token */
    private String token;
    /** ObjectsPackage.Player name */
    private String name;
    /** Initial amount Amount of money player has */
    private int money = 1500;
    /** Initializes player's position on the board */
    private int position = 0;
    /** Array of properties that they own */
    private ArrayList<MonopolyProperty> properties = new ArrayList<MonopolyProperty>();
    /** Number of railroads owned */
    private int numRailRoadsOwned;
    /** Number of utilities owned */
    private int numUtilitiesOwned;
    /** The Jail object for this player */
    private Jail jail;

    /** Empty constructor
     */
    public Player() {
    }

    /**
     * Constructor to instantiate new player
     */
    public Player(String name, String token) {
        this.name = name;
        this.token = token;
        this.position = position;
        this.money = money;
        this.properties = properties;
    }

    /**
     * Helper method used to update a player's position on the board by rolling the die
     */
    private void movePosition() {
        int numSpaces = DieModel.getDiceRollNum() + DieModel.getDiceRollNumTwo();
        this.position += numSpaces;
    }

    public void addProperty(MonopolyProperty propertyToAdd) { this.properties.add(propertyToAdd); }

    public void removeProperty(MonopolyProperty propertyToRemove) { this.properties.remove(propertyToRemove); }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<MonopolyProperty> getProperties() {
        return properties;
    }

    public int getNumRailRoadsOwned() { return numRailRoadsOwned; }

    public void setNumRailRoadsOwned(int numRailRoadsOwned) { this.numRailRoadsOwned = numRailRoadsOwned; }

    public int getNumUtilitiesOwned() { return numUtilitiesOwned; }

    public void setNumUtilitiesOwned(int numUtilitiesOwned) { this.numUtilitiesOwned = numUtilitiesOwned; }
}