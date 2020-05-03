/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Zeke Farkas
 * Section: 11am
 * Date: 4/25/2020
 * Time: 11:40 AM
 *
 * Project: csci205finalprojectSP2020
 * Package: ObjectsPackage
 * Class: Utilities
 *
 * Description:
 *
 * ****************************************
 */
package ObjectsPackage;

/**
 * @Author Zeke Farkas
 */
public class Utilities {
    // The position of the utility
    private int position;

    // Name of the utility
    private String utilityName;

    // Who owns the utility
    private Player whoOwns;

    // Cost of the utility should be $150
    private int costOfUtility;

    public Utilities(int position, String name) {
        this.position = position;
        this.utilityName = name;

        this.whoOwns = null;
        this.costOfUtility = 150;
    }

    /**
     * Pays rent from the rentPayer to the owner, based on rules:
     * 4x the roll if 1 utility is owned
     * 10x the roll is 2 utilities are owned
     * @param rentPayer
     */
    public void payRent(Player rentPayer) {
        int rolls = DieModel.getDiceRollNum() + DieModel.getDiceRollNumTwo();

        if(this.whoOwns.getUtils().size() == 1) {
            // Pay 4x the amount rolled
            if(rentPayer.getMoney() < (4 * rolls)) {
                System.out.println("Insufficient funds, can't pay rent");
                return;
            }
            // Subtract from buyer and add to owner
            rentPayer.removeMoney(4 * rolls);
            this.whoOwns.addMoney(4 * rolls);
            return;
        } else if(this.whoOwns.getUtils().size() == 2) {
            // Pay 10x the amount rolled
            if(rentPayer.getMoney() < (10 * rolls)) {
                System.out.println("Insufficient funds, can't pay rent");
                return;
            }
            // Subtract from buyer and add to owner
            rentPayer.removeMoney(10 * rolls);
            this.whoOwns.addMoney(10 * rolls);
            return;
        } else {
            System.out.println("I'm not sure how we got here");
        }
    }

    /**
     * Buys the utility. Subtracts the cost of the utility from the buyer, and then makes them the owner
     * and adds one to the numUtility property for the new owner
     * @param buyer
     */
    public void buyUtility(Player buyer) {
        if(this.whoOwns != null) {
            System.out.println("This utility is already owned!");
            return;
        } else if(buyer.getMoney() < this.costOfUtility) {
            System.out.println("Insufficient funds to purchase utility!");
            return;
        }
        // Set the new owner
        this.whoOwns = buyer;
        // Subtract money
        this.whoOwns.removeMoney(this.costOfUtility);
        // Add one to the numUtilitiesOwned for that person
//        this.whoOwns.setNumRailRoadsOwned(this.whoOwns.getNumUtilitiesOwned() + 1);
    }

    /**
     * Sells the utility. Removes the player as the owner, and adds back half the amount it cost to buy.
     */
    public void sellUtility() {
        if(this.whoOwns == null) {
            // ObjectsPackage.Property is unowned, it should not be able to be sold
            System.out.println("This is an unowned property. I don't know how we got to this line. Oops");
            return;
        }
        // Subtract 1 from number of utilities owned
//        this.whoOwns.setNumUtilitiesOwned(this.whoOwns.getNumUtilitiesOwned() - 1);
        // Add half the amount that was paid for the utility
        this.whoOwns.addMoney(this.costOfUtility / 2);
        // Remove the owner
        this.whoOwns = null;
    }
}