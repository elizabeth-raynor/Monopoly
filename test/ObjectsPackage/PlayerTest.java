package ObjectsPackage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {

    /** The Player */
    Player player;

    /** the Properties */
    propertiesMain props;

    @BeforeAll
    void beforeAll() {
        player = new Player("Name", Token.CANNON);
        props = new propertiesMain();
    }

    @Test
    void removeProperty() {
        player.addProperty(props.atlanticAve);
        player.addProperty(props.balticAve);
        assertEquals(2, player.getProperties().size());
        player.removeProperty(props.atlanticAve);
        assertEquals(1, player.getProperties().size());
    }

    @Test
    void setPosition() {
        assertTrue(player.getPosition() == 0);
        player.setPosition(10);
        assertEquals(10, player.getPosition());
    }


    @Test
    void setToken() {
        assertEquals(Token.CANNON, player.getToken());
        player.setToken(Token.CAR);
        assertEquals(Token.CAR, player.getToken());
    }


    @Test
    void setName() {
        assertEquals("Name", player.getName());
        player.setName("Hello");
        assertEquals("Hello", player.getName());
    }

    @Test
    void addMoney() {
        assertEquals(1500, player.getMoney());
        player.addMoney(500);
        assertEquals(2000, player.getMoney());
    }

    @Test
    void removeMoney() {
        assertEquals(1500, player.getMoney());
        player.removeMoney(100);
        assertEquals(1000, player.getMoney());
    }

    @Test
    void removeRR() {
        assertEquals(0, player.getRR().size());
        player.addRR(props.readingRailroad);
        assertEquals(1, player.getRR().size());
        player.removeRR(props.readingRailroad);
        assertEquals(0, player.getRR().size());
    }

    @Test
    void removeUtil() {
        assertEquals(0, player.getUtils().size());
        player.addUtil(props.waterWorks);
        assertEquals(1, player.getUtils().size());
        player.removeUtil(props.waterWorks);
        assertEquals(0, player.getUtils().size());
    }


}