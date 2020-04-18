/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Zeke Farkas
 * Section: 11am
 * Date: 4/15/2020
 * Time: 9:43 AM
 *
 * Project: csci205finalprojectSP2020
 * Package: PACKAGE_NAME
 * Class: Property
 *
 * Description:
 *
 * ****************************************
 */

public class Property {
    // Name of the property (may not be needed?)
    private String propertyName;

    // Color group of the property (may not be needed)
    private String propertyColor;

    // Owned or unowned
    private Boolean owned;

    // Player class needs to be implemented
    private Player whoOwns;

    // Does or does not have houses
    private Boolean hasHouse;

    // Number of houses on property
    private int numOfHouses;

    // Price per house for this property
    private int housePrice;

    // Does or does not have a hotel, can only have one
    private Boolean hasHotel;

    // Price of hotel for this property
    private int hotelPrice;

    // The price of the property
    private int costOfProperty;

    // The current price of rent
    private int currentRent;

    public Property(String propertyName, String propertyColor, int costOfProperty, int housePrice, int hotelPrice, int initialRent) {
        // Should be constant
        this.propertyName = propertyName;
        this.propertyColor = propertyColor;
        this.costOfProperty = costOfProperty;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;

        // currentRent set to the initialRent, changes as houses and hotels are added
        this.currentRent = initialRent;

        // Should at first be false
        this.owned = false;
        // Should at first be null
        this.whoOwns = null;
        // Should at first be false
        this.hasHouse = false;
        // Should at first be 0
        this.numOfHouses = 0;
        // Should at first be false
        this.hasHotel = false;
    }

    /**
     * Called in order to complete the action of purchasing a property
     * Buyer will have the cost of the property subtracted from their money, and the property added to their list of owned properties
     * The property will have owned changed to true and whoOwns changed to the buyer
     * @param buyer - an object of Player class
     */
    public void buyProperty(Player buyer) {
        if(this.owned == true) {
            // Property is already owned, cannot buy it
            System.out.println("This property is already owned. We should never have gotten here. Why is this printing?");
            return;
        } else if(buyer.getMoney() < this.costOfProperty) {
            // TODO Should we create a custom exception class? (Insufficient funds)
            // Buyers balance is less than the cost of the property
            System.out.println("Insufficient money to purchase this property");
            return;
        }
        // Subtract the amount the property costs
        buyer.setMoney(buyer.getMoney() - this.costOfProperty);
        // Change the state of owned to true
        this.owned = true;
        // Change the owner to buyer
        this.whoOwns = buyer;
        // Add the property to the list of owned property for the buyer

    }

    /**
     * Called in order to complete the action of selling a property
     * Seller will have the cost of the property added to their money, and the property will be removed from their list of owned properties
     * The property will have owned changed to false and whoOwns changed to false
     * @param seller - an object of Player class
     */
    public void sellProperty(Player seller){
        if(this.owned == false) {
            // Property is unowned, it should not be able to be sold
            System.out.println("This is an unowned property. I don't know how we got to this line. Oops");
            return;
        }
        // Add the price of the property to the seller
        seller.setMoney(seller.getMoney() + this.costOfProperty);
        // Change the state of owned to false
        this.owned = false;
        // Change the owner to null
        this.whoOwns = null;
        // Remove the property from the sellers list of owned properties

    }

    /**
     * Checks to see if the rentPayer has enough money, and then subtracts the current rent price from their funds
     * @param rentPayer - an object of Player class
     */
    public void payRent(Player rentPayer){
        if(rentPayer.getMoney() < this.currentRent) {
            // Potentially add the insufficient funds custom exception
            System.out.println("Insufficient funds, can't pay rent");
            return;
            // TODO - add action for selling off properties or go bankrupt
        }
        // Remove the rent price from the rentPayer's money
        rentPayer.setMoney(rentPayer.getMoney() - this.currentRent);
    }

    public void buyHouse() {
        if(this.whoOwns.getMoney() < this.housePrice) {
            // Potentially add the insufficient funds custom exception
            System.out.println("Insufficient funds, can't buy house");
            return;
        }

    }

    public void sellHouse() {

    }

    public void buyHotel() {

    }

    public void sellHotel() {

    }

    public Boolean getOwned() { return owned; }

    public void setOwned(Boolean owned) { this.owned = owned; }

    public Player getWhoOwns() { return whoOwns; }

    public void setWhoOwns(Player whoOwns) { this.whoOwns = whoOwns; }

    public Boolean getHasHouse() { return hasHouse; }

    public void setHasHouse(Boolean hasHouse) { this.hasHouse = hasHouse; }

    public int getNumOfHouses() { return numOfHouses; }

    public void setNumOfHouses(int numOfHouses) { this.numOfHouses = numOfHouses; }

    public Boolean getHasHotel() { return hasHotel; }

    public void setHasHotel(Boolean hasHotel) { this.hasHotel = hasHotel; }
}