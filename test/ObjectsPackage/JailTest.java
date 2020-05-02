package ObjectsPackage;

//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JailTest {

    /** The Player */
    private Player player;

    @BeforeAll
    void beforeAll() {
        player = new Player("Name", Token.CANNON);
    }

    @Test
    void jailInit() {
        assertFalse(player.jail.inJail && player.jail.justVisiting);
    }

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

    @Test
    void rollGetOutOfJail() {
        player.jail.goToJail();
        player.jail.getOutOfJail(1,1);
        assertFalse(player.jail.inJail);
    }

    @Test
    void goToJail() {
        player.jail.goToJail();
        assertTrue(player.jail.inJail);
    }

    @Test
    void landOnJail() {
        player.jail.landOnJail();
        assertFalse(player.jail.inJail);
    }

    @Test
    void leaveJail() {
        player.jail.goToJail();
        assertTrue(player.jail.inJail);
        player.jail.leaveJail();
        assertFalse(player.jail.inJail);
    }
}