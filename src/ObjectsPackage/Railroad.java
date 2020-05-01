/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Zeke Farkas
 * Section: 11am
 * Date: 4/25/2020
 * Time: 11:39 AM
 *
 * Project: csci205finalprojectSP2020
 * Package: ObjectsPackage
 * Class: Railroad
 *
 * Description:
 *
 * ****************************************
 */
package ObjectsPackage;

public class Railroad {
    // Position of railroad on board
    private int position;

    // Name of the railroad
    private String railRoadName;

    // Who owns the railroad
    private Player whoOwns;

    // Price of each railroad is $200
    private int costOfRailroad;


    public Railroad(int position, String name) {
        this.position = position;
        this.railRoadName = name;

        this.whoOwns = null;
        this.costOfRailroad = 200;
    }

    /**
     * Pay rent to the owner of the railroad, based on how many railroads they owned
     * 25 for 1 railroad owned
     * 50 for 2 railroads owned
     * 100 for 3 railroads owned
     * 200 for 4 railroads owned
     * @param rentPayer
     */
    public void payRent(Player rentPayer) {
        // Change how much is charger based on the number of railroads owned
        switch (this.whoOwns.getNumRailRoadsOwned()) {
            case 1:
                // Rent is $25
                if(rentPayer.getMoney() < 25) {
                    System.out.println("Insufficient funds, can't pay rent");
                    return;
                    // TODO - add action for selling off properties or go bankrupt
                }
                rentPayer.setMoney(rentPayer.getMoney() - 25);
                this.whoOwns.setMoney(this.whoOwns.getMoney() + 25);
                break;
            case 2:
                // Rent is $50
                if(rentPayer.getMoney() < 50) {
                    System.out.println("Insufficient funds, can't pay rent");
                    return;
                    // TODO - add action for selling off properties or go bankrupt
                }
                rentPayer.setMoney(rentPayer.getMoney() - 50);
                this.whoOwns.setMoney(this.whoOwns.getMoney() + 50);
                break;
            case 3:
                // Rent is $100
                if(rentPayer.getMoney() < 100) {
                    System.out.println("Insufficient funds, can't pay rent");
                    return;
                    // TODO - add action for selling off properties or go bankrupt
                }
                rentPayer.setMoney(rentPayer.getMoney() - 100);
                this.whoOwns.setMoney(this.whoOwns.getMoney() + 100);
                break;
            case 4:
                // Rent is $200
                if(rentPayer.getMoney() < 200) {
                    System.out.println("Insufficient funds, can't pay rent");
                    return;
                    // TODO - add action for selling off properties or go bankrupt
                }
                rentPayer.setMoney(rentPayer.getMoney() - 200);
                this.whoOwns.setMoney(this.whoOwns.getMoney() + 200);
                break;
        }
    }

    /**
     * Buy a railroad, and add 1 to the number of railroads owned by that player
     * @param buyer
     */
    public void buyRailroad(Player buyer) {
        if(this.whoOwns != null) {
            System.out.println("This railroad is already owned!");
            return;
        } else if(buyer.getMoney() < this.costOfRailroad) {
            System.out.println("Insufficient funds to purchase railroad!");
            return;
        }
        // Set the new owner
        this.whoOwns = buyer;
        // Subtract money
        this.whoOwns.setMoney(this.whoOwns.getMoney() - this.costOfRailroad);
        // Add one to the numRailroadsOwned for that person
        this.whoOwns.setNumRailRoadsOwned(this.whoOwns.getNumRailRoadsOwned() + 1);
    }

    /**
     * Sell a railroad for half the amount it was bought for, and remove 1 from that players number of railroads owned
     */
    public void sellRailroad() {
        if(this.whoOwns == null) {
            // ObjectsPackage.Property is unowned, it should not be able to be sold
            System.out.println("This is an unowned property. I don't know how we got to this line. Oops");
            return;
        }
        // Subtract 1 from number of railroads owned
        this.whoOwns.setNumRailRoadsOwned(this.whoOwns.getNumRailRoadsOwned() - 1);
        // Add half the amount that was paid for the railroad
        this.whoOwns.setMoney(this.whoOwns.getMoney() + (this.costOfRailroad / 2));
        // Remove the owner
        this.whoOwns = null;
    }
}