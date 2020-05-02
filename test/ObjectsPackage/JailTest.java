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
 * Class: JailTest
 *
 * Description: tests the Jail class
 *
 * ****************************************
 */

package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test the Jail class
 *
 * @author Elizabeth Raynor
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JailTest {

    /** The Player */
    private Player player;

    /**
     * Initialize the player before each test
     */
    @BeforeAll
    void beforeAll() {
        player = new Player("Name", Token.CANNON);
    }

    /**
     * Test that the player is initially neither in jail nor just visiting
     */
    @Test
    void jailInit() {
        assertFalse(player.jail.inJail && player.jail.justVisiting);
    }

    /**
     * Test getting out of jail by paying after 3 rolls
     */
    @Test
    void payGetOutOfJail() {
        player.jail.goToJail();
        player.jail.getOutOfJail(1,2);
        assertTrue(player.jail.inJail);
        player.jail.getOutOfJail(1,2);
        assertTrue(player.jail.inJail);
        player.jail.getOutOfJail(1,2);
        assertFalse(player.jail.inJail);
    }

    /**
     * Test getting out of jail by rolling doubles
     */
    @Test
    void rollGetOutOfJail() {
        player.jail.goToJail();
        player.jail.getOutOfJail(1,1);
        assertFalse(player.jail.inJail);
    }

    /**
     * Test going to jail
     */
    @Test
    void goToJail() {
        player.jail.goToJail();
        assertTrue(player.jail.inJail);
    }

    /**
     * Test landing on jail
     */
    @Test
    void landOnJail() {
        player.jail.landOnJail();
        assertFalse(player.jail.inJail);
        assertTrue(player.jail.justVisiting);
    }


    /**
     * Test leaving jail
     */
    @Test
    void leaveJail() {
        player.jail.goToJail();
        assertTrue(player.jail.inJail);
        player.jail.leaveJail();
        assertFalse(player.jail.inJail && player.jail.justVisiting);
    }
}