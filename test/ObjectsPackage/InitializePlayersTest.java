/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 5/2/2020
 * Time: 3:27 PM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: InitalizePlayers
 *
 * Description:
 *
 * ****************************************
 */
package ObjectsPackage;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests InitalizePlayer methods
 *  @see <h ref = https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input referenced stackoverflow </h> to understand simulated user input
 */
class InitializePlayersTest {

    ArrayList<Player> players;
    InitializePlayers initPlayers;

    /**
     * Tests for all acceptable numbers of players
     */
    @Test
    void askNumPlayers() {

        // 2 players to start
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertEquals(2,initPlayers.askNumPlayers());

        // 3 players to start
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertEquals(3,initPlayers.askNumPlayers());

        // 4 players to start
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        assertEquals(4,initPlayers.askNumPlayers());
    }

    /**
     * Tests for two instances that would not be accepted as number of players (only 2, 3, and 4 are accepted).
     * Normally it would loop back around until input meets expectations, but as there is only one given input it should throw a "NoSuchElement" exception.
     */
    @Test
    void askNumPlayersFail() {
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
//        assertThrows();
        assertThrows(NoSuchElementException.class, () -> initPlayers.askNumPlayers());
    }

    /**
     * Successfully tests for valid name choices
     * @author Michelle Pham
     */
    @Test
    void askPlayerName() {
        // case 1 - regular name / word
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("ProfDancy".getBytes()));
        String nameOne = initPlayers.askPlayerName();
        assertEquals("ProfDancy",nameOne);

        // case 2 - just numbers
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("1234".getBytes())); // assigned name should be
        String nameTwo = initPlayers.askPlayerName();
        assertEquals("user1234",nameTwo);

        // case 3 - numbers and letters
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("player9876".getBytes())); // assigned name should be
        String nameThree = initPlayers.askPlayerName();
        assertEquals("player9876",nameThree);
    }

    /**
     * Successfully tests for two valid token choices
     * @author Michelle Pham
     */    @Test
    void askPlayerNameFail() {
        // case one: not long enough
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("c".getBytes()));
        assertThrows(NoSuchElementException.class, () -> initPlayers.askPlayerName());

        // case two: name already used
        initPlayers = new InitializePlayers((ArrayList) players);
        initPlayers.setNames(Arrays.asList("ProfDancy", "Lily", "Michelle","Elizabeth","Amisha","Zeke"));
        System.out.println(initPlayers.getNames()); // display some initialized names
        System.setIn(new ByteArrayInputStream("ProfDancy".getBytes()));
        assertThrows(NoSuchElementException.class, () -> initPlayers.askPlayerName());
    }

    /**
     * Successfully tests for two valid token choices
     * @author Michelle Pham
     */
    @Test
    void askToken() {
        // choice 1: moneybag
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("MONEYBAG".getBytes()));
        assertEquals(Token.MONEYBAG,initPlayers.askToken());

        // choice 2: wheelbarrow
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("WHEELBARROW".getBytes()));
        assertEquals(Token.WHEELBARROW,initPlayers.askToken());
    }

    /**
     * Tests for two instances that would not be accepted as valid token inputs.
     * Normally it would loop back around until valid, but as there is only one given input, it should throw a "NoSuchElement" exception.
     * @author Michelle Pham
     */
    @Test
    void askTokenFail() {
        // case one: not a valid enum choice
        initPlayers = new InitializePlayers((ArrayList) players);
        System.setIn(new ByteArrayInputStream("CAT".getBytes()));
        assertThrows(NoSuchElementException.class, () -> initPlayers.askToken());

        // case two: token already used
        initPlayers = new InitializePlayers((ArrayList) players);
        initPlayers.setAvailableTokens(Arrays.asList(Token.CANNON,Token.CAR,Token.DOG,Token.HAT,Token.HORSE,Token.MONEYBAG)); // removed choices of penguin, purse, shoe and wheelbarrow
        System.setIn(new ByteArrayInputStream("PENGUIN".getBytes()));
        assertThrows(NoSuchElementException.class, () -> initPlayers.askToken());
    }
}