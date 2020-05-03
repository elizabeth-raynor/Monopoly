package ObjectsPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonopolyPropertyTest {

    /** The Player who owns the property */
    private Player owner;

    /** The Player who rents the property */
    private Player renter;

    /** The properties */
    private propertiesMain props;

    @BeforeEach
    void beforeEach() {
        owner = new Player("Owner", Token.CANNON);
        renter = new Player("Renter", Token.CAR);
        props = new propertiesMain();
    }

    @Test
    void buyProperty() {
        assertEquals(0, owner.getProperties().size());
        props.northCarolinaAve.buyProperty(owner);
        assertEquals(owner, props.northCarolinaAve.getWhoOwns());
        assertEquals(1500-props.northCarolinaAve.getCostOfProperty(), owner.getMoney());
        assertEquals(1, owner.getProperties().size());
    }

    @Test
    void sellProperty() {
        props.northCarolinaAve.buyProperty(owner);
        props.northCarolinaAve.sellProperty(owner);
        assertEquals(0, owner.getProperties().size());
        assertEquals(1500, owner.getMoney());
        assertEquals(null, props.northCarolinaAve.getWhoOwns());
    }

    @Test
    void payRent() {
        props.northCarolinaAve.buyProperty(owner);
        props.northCarolinaAve.payRent(renter);
        assertEquals(1500-26, renter.getMoney());
        assertEquals(1200+26, owner.getMoney());
    }

    @Test
    void buyHouse() {
        props.northCarolinaAve.buyProperty(owner);
        props.northCarolinaAve.buyHouse();
        assertEquals(1500-300-200, owner.getMoney());
        assertEquals(130, props.northCarolinaAve.getCurrentRent());
        props.northCarolinaAve.buyHouse();
        assertEquals(1500-300-200-200, owner.getMoney());
        assertEquals(390, props.northCarolinaAve.getCurrentRent());
        assertEquals(2, props.northCarolinaAve.getNumOfHouses());
    }

    @Test
    void sellHouse() {
        props.northCarolinaAve.buyProperty(owner);
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.sellHouse();
        assertEquals(1500-300-200-100, owner.getMoney());
        assertEquals(130, props.northCarolinaAve.getCurrentRent());
    }

    @Test
    void buyAndSellHotel() {
        props.northCarolinaAve.buyProperty(owner);
        assertFalse(props.northCarolinaAve.getHasHotel());
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.buyHouse();
        props.northCarolinaAve.buyHotel();
        assertEquals(1500-300-(200*5), owner.getMoney());
        assertTrue(props.northCarolinaAve.getHasHotel());
        props.northCarolinaAve.sellHotel();
        assertEquals(1500-300-(200*4)-100, owner.getMoney());
        assertFalse(props.northCarolinaAve.getHasHotel());
    }

}