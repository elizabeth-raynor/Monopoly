/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Elizabeth Raynor
 * Section: 11 am
 * Date: 4/29/2020
 * Time: 9:38 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: PlayerTest
 *
 * Description: tests the Player Class
 *
 * ****************************************
 */

package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test the Player class
 *
 * @author Elizabeth Raynor
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {

    /** The Player */
    Player player;

    /** the Properties */
    propertiesMain props;

    /**
     * Initialize the player and properties before each test
     */
    @BeforeAll
    void beforeAll() {
        player = new Player("Name", Token.CANNON);
        props = new propertiesMain();
    }

    /**
     * Test add and remove property
     */
    @Test
    void removeProperty() {
        player.addProperty(props.atlanticAve);
        player.addProperty(props.balticAve);
        assertEquals(2, player.getProperties().size());
        player.removeProperty(props.atlanticAve);
        assertEquals(1, player.getProperties().size());
    }

    /**
     * Test changing player postion
     */
    @Test
    void setPosition() {
        assertTrue(player.getPosition() == 0);
        player.setPosition(10);
        assertEquals(10, player.getPosition());
    }


    /**
     * Test changing token
     */
    @Test
    void setToken() {
        assertEquals(Token.CANNON, player.getToken());
        player.setToken(Token.CAR);
        assertEquals(Token.CAR, player.getToken());
    }


    /**
     * Test setting a player's name
     */
    @Test
    void setName() {
        assertEquals("Name", player.getName());
        player.setName("Hello");
        assertEquals("Hello", player.getName());
    }

    /**
     * Test adding money
     */
    @Test
    void addMoney() {
        assertEquals(1500, player.getMoney());
        player.addMoney(500);
        assertEquals(2000, player.getMoney());
    }

    /**
     * Test removing money
     */
    @Test
    void removeMoney() {
        assertEquals(1500, player.getMoney());
        player.removeMoney(100);
        assertEquals(1000, player.getMoney());
    }

    /**
     * Test adding and removing railroads
     */
    @Test
    void removeRR() {
        assertEquals(0, player.getRR().size());
        player.addRR(props.readingRailroad);
        assertEquals(1, player.getRR().size());
        player.removeRR(props.readingRailroad);
        assertEquals(0, player.getRR().size());
    }

    /**
     * Test adding and removing Utilities
     */
    @Test
    void removeUtil() {
        assertEquals(0, player.getUtils().size());
        player.addUtil(props.waterWorks);
        assertEquals(1, player.getUtils().size());
        player.removeUtil(props.waterWorks);
        assertEquals(0, player.getUtils().size());
    }


}