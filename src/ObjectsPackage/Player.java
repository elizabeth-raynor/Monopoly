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

    /** player's game token */
    private Token token;
    /** player's name */
    private String name;
    /** Initial amount Amount of money player has */
    private int money = 1500;
    /** Initializes player's position on the board */
    private int position = 0;
    /** Array of properties that they own */
    private ArrayList<MonopolyProperty> properties = new ArrayList<MonopolyProperty>();

    /** Empty constructor
     */
    public Player() {
    }

    /**
     * Constructor to instantiate new player
     */
    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
        this.position = position;
        this.money = money;
        this.properties = properties;
    }

    /**
     * Helper method used to update a player's position on the board by rolling the die
     * @author Michelle Pham
     */
    private void movePosition(int numSpaces) {
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

    public Token getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(Token token) {
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

    @Override
    public String toString() {
        return "Player information: {" + "name = " + name + ", token = " + token +
                ", money available $=" + money + ", Position (#) = " + position + ", properties = " + properties + '}';
    }
}