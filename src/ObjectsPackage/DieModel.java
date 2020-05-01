package ObjectsPackage;

import java.util.Random;

public class DieModel {
    private static Random randNumRoller = new Random();
    private static Random randNumRollerTwo = new Random();
    private static int numSides = 6;
    private static int addOne = 1;
    private static int diceRollNum;
    private static int diceRollNumTwo;

    public void roll() {
        int rollNum = randNumRoller.nextInt(numSides);
        diceRollNum = rollNum + addOne;
    }

    public void rollTwo() {
        int rollNumTwo = randNumRollerTwo.nextInt(numSides);
        diceRollNumTwo = rollNumTwo + addOne;
    }

    public static int getDiceRollNum() {
        return diceRollNum;
    }

    public static int getDiceRollNumTwo() {
        return diceRollNumTwo;
    }
}
