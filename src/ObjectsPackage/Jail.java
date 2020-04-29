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

public class Jail {

    /** The player associated with this Jail */
    private Player player;

    /** The status of the player in relation to Jail */
    private boolean justVisiting;
    private boolean inJail;

    /** The number of rolls attempted to escape Jail */
    private int numRolls = 0;

    /**
     * The constructor that instantiates this Jail object with a player
     * @param player - the player associated with this jail
     */
    public Jail(Player player) {
        this.player = player;
    }

    /** Sets the players inJail status to true */
    private void goToJail() {
        this.inJail = true;
    }

    /** Sets the players inJail status to false */
    private void leaveJail() {
        this.inJail = false;
    }

    /** Sets the players justVisiting status to true */
    private void landOnJail() {
        this.justVisiting = true;
    }

    /**
     * A method to get the player out of jail
     */
    private void getOutOfJail() {
        int roll1 = DieModel.roll();
        int roll2 = DieModel.rollTwo();
        if (numRolls == 3 && roll1 != roll2) {
            System.out.println("You've had 3 tries to rolls doubles. Now you must pay $50 to leave jail");
            player.setMoney(player.getMoney() - 50);
            leaveJail();
        }
        else if (roll1 == roll2) {
            System.out.println("Congratulations you rolled doubles!");
            leaveJail();
        }
        else {
            numRolls++;
            System.out.println("Sorry, you didn't roll doubles. Better luck next time!");
        }
    }
}