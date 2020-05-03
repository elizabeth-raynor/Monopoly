/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Elizabeth Raynor
 * Section: YOUR SECTION
 * Date: 4/29/2020
 * Time: 9:38 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: Jail
 *
 * Description: represents the Jail tile on the board
 *
 * ****************************************
 */
package ObjectsPackage;

/**
 * Represents the jail tile on the board. Each player has their own Jail instance
 *
 * @author Elizabeth Raynor
 */
public class Jail {

    /** The player associated with this Jail */
    private Player player;

    /** The status of the player in relation to Jail */
    public boolean justVisiting;
    public boolean inJail;

    /** The number of rolls attempted to escape Jail */
    private int numRolls = 0;

    /**
     * The constructor that instantiates this Jail object with a player who
     * is neither in jail nor visiting
     */
    public Jail(Player player) {
        this.player = player;
        this.justVisiting = false;
        this.inJail = false;
    }

    /** Sets the players inJail status to true */
    public void goToJail() {
        this.inJail = true;
    }

    /** Sets the players inJail status to false */
    public void leaveJail() {
        this.inJail = false;
        this.justVisiting = false;
    }

    /** Sets the players justVisiting status to true */
    public void landOnJail() {
        this.justVisiting = true;
    }


    /**
     * A method to get the player out of jail
     */
    public void getOutOfJail(int rollOne, int rollTwo) {
        if (numRolls == 2 && rollOne != rollTwo) {
            System.out.println("You've had 3 tries to rolls doubles. Now you must pay $50 to leave jail");
            player.removeMoney(50);
            leaveJail();
        }
        else if (rollOne == rollTwo) {
            System.out.println("Congratulations you rolled doubles!");
            leaveJail();
        }
        else {
            numRolls++;
            System.out.println("Sorry, you didn't roll doubles. Better luck next time!");
        }
    }

    public int getNumRolls() {
        return numRolls;
    }
}