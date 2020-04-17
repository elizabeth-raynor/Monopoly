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

    // Does or does not have a hotel, can only have one
    private Boolean hasHotel;

    // The price of the property
    private int costOfProperty;

    public Property(String propertyName, String propertyColor, int costOfProperty) {
        // Should be constant
        this.propertyName = propertyName;
        this.propertyColor = propertyColor;
        this.costOfProperty = costOfProperty;

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
     * Called in order to complete the action of purchasing a property.
     * @param buyer - an object of Player class
     */
    public void buyProperty(Player buyer) {
        if(this.owned == true) {
            // Property is already owned, cannot buy it
            System.out.println("This property is already owned. We should never have gotten here. Why is this printing?");
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

    public void sellProperty(){}

    public void payRent(){}

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