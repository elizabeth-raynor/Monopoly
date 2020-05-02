package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JailTest {

    /** The Player */
    private Player player = new Player("Name", Token.CANNON);

    @BeforeAll
    void beforeAll() {
        player.setMoney(200);
    }

    @org.junit.jupiter.api.Test
    void getOutOfJail() {
        player.jail.goToJail();
        player.jail.getOutOfJail(1,2);
        assertTrue(player.jail.inJail == true);
        player.jail.getOutOfJail(1,2);
        assertTrue(player.jail.inJail == true);
        player.jail.getOutOfJail(1,2);
        assertTrue(player.jail.inJail == false);

    }

    @Test
    void goToJail() {
        assertTrue(player.jail.inJail == false && player.jail.justVisiting == false);
        player.jail.goToJail();
        assertTrue(player.jail.inJail == true);
    }

    @Test
    void leaveJail() {
        assertTrue(player.jail.inJail == false && player.jail.justVisiting == false);
        player.jail.goToJail();
        player.jail.leaveJail();
        assertTrue(player.jail.inJail == false);
    }

    @Test
    void landOnJail() {
        assertTrue(player.jail.inJail == false && player.jail.justVisiting == false);
        player.jail.landOnJail();
        assertTrue(player.jail.inJail == false);
    }
}