package ObjectsPackage;/* *****************************************
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
 * Class: ObjectsPackage.Property
 *
 * Description:
 *
 * ****************************************
 */


public class MonopolyProperty {
    // Name of the property (may not be needed?)
    private String propertyName;

    // Color group of the property (may not be needed)
    private String propertyColor;

    // ObjectsPackage.Player class needs to be implemented
    private Player whoOwns;

    // Number of houses on property
    private int numOfHouses;

    // Price per house for this property
    private int housePrice;

    // Does or does not have a hotel, can only have one
    private Boolean hasHotel;

    // The price of the property
    private int costOfProperty;

    // The current price of rent
    private int currentRent;

    // Variables for the rent with 0, 1, 2, 3, or 4 houses, or with a hotel
    private int baseRent;
    private int oneHouseRent;
    private int twoHouseRent;
    private int threeHouseRent;
    private int fourHouseRent;
    private int hotelRent;

    public MonopolyProperty(String propertyName, String propertyColor, int costOfProperty, int housePrice, int baseRent, int oneHouseRent, int twoHouseRent, int threeHouseRent, int fourHouseRent, int hotelRent) {
        // Should be constant
        this.propertyName = propertyName;
        this.propertyColor = propertyColor;
        this.costOfProperty = costOfProperty;
        this.housePrice = housePrice;

        // currentRent set to the baseRent, changes as houses and hotels are added
        this.currentRent = baseRent;

        // Initialize the different types of rent
        this.baseRent = baseRent;
        this.oneHouseRent = oneHouseRent;
        this.twoHouseRent = twoHouseRent;
        this.threeHouseRent = threeHouseRent;
        this.fourHouseRent = fourHouseRent;
        this.hotelRent = hotelRent;

        // Should at first be null
        this.whoOwns = null;
        // Should at first be 0
        this.numOfHouses = 0;
        // Should at first be false
        this.hasHotel = false;
    }

    /**
     * Called in order to complete the action of purchasing a property
     * Buyer will have the cost of the property subtracted from their money, and the property added to their list of owned properties
     * The property will have owned changed to true and whoOwns changed to the buyer
     * @param buyer - an object of ObjectsPackage.Player class
     */
    public void buyProperty(Player buyer) {
        if(this.whoOwns != null) {
            // ObjectsPackage.Property is already owned, cannot buy it
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
        // Change the owner to buyer
        this.whoOwns = buyer;
        // Add the property to the list of owned property for the buyer
        this.whoOwns.addProperty(this);
    }

    /**
     * Called in order to complete the action of selling a property
     * Seller will have the cost of the property added to their money, and the property will be removed from their list of owned properties
     * The property will have owned changed to false and whoOwns changed to false
     * @param seller - an object of ObjectsPackage.Player class
     */
    public void sellProperty(Player seller){
        if(this.whoOwns == null) {
            // ObjectsPackage.Property is unowned, it should not be able to be sold
            System.out.println("This is an unowned property. I don't know how we got to this line. Oops");
            return;
        }
        // Add the price of the property to the seller
        seller.setMoney(seller.getMoney() + this.costOfProperty);
        // Change the owner to null
        this.whoOwns = null;
        // Remove the property from the sellers list of owned properties
        this.whoOwns.removeProperty(this);
    }

    /**
     * Checks to see if the rentPayer has enough money, and then subtracts the current rent price from their funds
     * @param rentPayer - an object of ObjectsPackage.Player class
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

    /**
     * The owner of a property can call this function to buy a house on a property
     * Will only work if they have enough money, and don't already have 4 houses
     */
    public void buyHouse() {
        if(this.whoOwns.getMoney() < this.housePrice) {
            // Potentially add the insufficient funds custom exception
            System.out.println("Insufficient funds, can't buy house");
            return;
        } else if(this.numOfHouses == 4) {
            // Can't buy any more houses
            System.out.println("You already have 4 houses, you can't buy anymore");
            return;
        }
        // Subtract the price of a house from the owner's money
        this.whoOwns.setMoney(this.whoOwns.getMoney() - this.housePrice);
        // Add one to the number of houses owned
        this.numOfHouses += 1;
        // Update currentRent
        switch (this.numOfHouses) {
            case 1:
                this.currentRent = this.oneHouseRent;
                break;
            case 2:
                this.currentRent = this.twoHouseRent;
                break;
            case 3:
                this.currentRent = this.threeHouseRent;
                break;
            case 4:
                this.currentRent = this.fourHouseRent;
                break;
        }
    }

    /**
     * Houses and hotels may be sold back for half the amount they were bought for
     */
    public void sellHouse() {
        if(this.numOfHouses < 1) {
            System.out.println("Not enough houses to sell one");
            return;
        } else if(this.hasHotel) {
            System.out.println("You must sell your hotel before you can sell houses");
            return;
        }
        // Add half the price of a house to the owner's money
        this.whoOwns.setMoney(this.whoOwns.getMoney() + (this.housePrice / 2));
        // Subtract one from the number of houses on the property
        this.numOfHouses += -1;
        // Update currentRent
        switch (this.numOfHouses) {
            case 1:
                this.currentRent = this.oneHouseRent;
                break;
            case 2:
                this.currentRent = this.twoHouseRent;
                break;
            case 3:
                this.currentRent = this.threeHouseRent;
                break;
            case 4:
                this.currentRent = this.fourHouseRent;
                break;
        }
    }

    /**
     * May be called by the owner of a property in order to buy a hotel on that property
     * Must already have 4 houses, not have an existing hotel on that property, and enough money
     */
    public void buyHotel() {
        if(this.whoOwns.getMoney() < this.housePrice){
            System.out.println("Insufficient funds to buy a hotel");
            return;
        } else if(this.numOfHouses <= 4) {
            System.out.println("You must have 4 houses in order to buy a hotel");
            return;
        } else if(this.hasHotel) {
            System.out.println("Sorry you can only have one hotel on a property");
            return;
        }
        // Subtract the cost of a hotel (the same as a house) from the owners money
        this.whoOwns.setMoney(this.whoOwns.getMoney() - this.housePrice);
        // Update hasHotel to true
        this.hasHotel = true;
        // Update the currentRent
        this.currentRent = hotelRent;
    }

    /**
     * May be called by the owner of a property to sell the hotel they have on a proerty
     */
    public void sellHotel() {
        if(!this.hasHotel) {
            System.out.println("You don't have a hotel to sell");
            return;
        }
        // Add half the price of a hotel (house) to the owners money
        this.whoOwns.setMoney(this.whoOwns.getMoney() + (this.housePrice / 2));
        // Set hasHotel to false
        this.hasHotel = false;
        // Update currentRent
        this.currentRent = fourHouseRent;
    }

    public Player getWhoOwns() { return whoOwns; }

    public void setWhoOwns(Player whoOwns) { this.whoOwns = whoOwns; }

    public int getNumOfHouses() { return numOfHouses; }

    public void setNumOfHouses(int numOfHouses) { this.numOfHouses = numOfHouses; }

    public Boolean getHasHotel() { return hasHotel; }

    public void setHasHotel(Boolean hasHotel) { this.hasHotel = hasHotel; }
}