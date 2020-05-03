package ObjectsPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InitializePlayersTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    ArrayList<Player> players;
    InitializePlayers initPlayers;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        initPlayers = new InitializePlayers((ArrayList) players);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void askNumPlayers() {
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        initPlayers.askNumPlayers();
        assertEquals(4,initPlayers.askNumPlayers());
    }

    @Test
    void askPlayerName() {
        // case 1 - regular name / word
        ByteArrayInputStream in = new ByteArrayInputStream("ProfDancy".getBytes());
        System.setIn(in);
        String nameOne = initPlayers.askPlayerName();
        assertEquals("ProfDancy",nameOne);

        // case 2 - just numbers
        System.setIn(new ByteArrayInputStream("1234".getBytes())); // assigned name should be
        String nameTwo = initPlayers.askPlayerName();
        assertEquals("user1234",nameTwo);
    }

    @Test
    void askToken() {
        System.setIn(new ByteArrayInputStream("MONEYBAG".getBytes()));
    }
}