/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Amisha Chhetri
 * Section: 11 am
 * Date: 4/29/2020
 * Time: 9:38 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: DieModel
 *
 * Description: makes a die that rolls a random number from 1-6
 *
 * ****************************************
 */

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
