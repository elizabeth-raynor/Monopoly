package ObjectsPackage;

import java.util.Random;

/**
 * @author amishachhetri
 */
public class DieModel {
    private static Random randNumRoller = new Random();
    private static Random randNumRollerTwo = new Random();
    private static int numSides = 6;
    private static int addOne = 1;
    private static int diceRollNum;
    private static int diceRollNumTwo;

    /**
     * method that rolls the die and generates a random number from 1-6
     * sets the random number to a variable
     */
    public static void roll() {
        int rollNum = randNumRoller.nextInt(numSides);
        diceRollNum = rollNum + addOne;
    }

    /**
     * method that rolls the die and generates a random number from 1-6
     * sets the random number to a variable
     */
    public static void rollTwo() {
        int rollNumTwo = randNumRollerTwo.nextInt(numSides);
        diceRollNumTwo = rollNumTwo + addOne;
    }

    /**
     * gets the number rolled
     * @return diceRollNum - number that is rolled
     */
    public static int getDiceRollNum() {
        return diceRollNum;
    }

    /**
     * gets the number rolled
     * @return diceRollNumTwo - number that is rolled
     */
    public static int getDiceRollNumTwo() {
        return diceRollNumTwo;
    }
}
