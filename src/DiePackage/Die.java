package DiePackage;

import java.util.Random;

public class Die {
    private static Random randNumRoller = new Random();
    private static Random randNumRollerTwo = new Random();
    static int numSides = 6;
    static int addOne = 1;

    public static int roll() {
        int rollNum = randNumRoller.nextInt(numSides);
        return rollNum + addOne;
    }

    public static int rollTwo() {
        int rollNumTwo = randNumRollerTwo.nextInt(numSides);
        return rollNumTwo + addOne;
    }

    public static void main(String[] args) {
        Die dieOne = new Die();
        System.out.println(dieOne.roll());
        System.out.println(dieOne.rollTwo());
    }
}
