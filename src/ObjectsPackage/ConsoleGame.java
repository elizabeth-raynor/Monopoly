/* *****************************************
* CSCI205 - Software Engineering and Design
* Spring 2020
* Instructor: Prof. Chris Dancy
*
* Name: Michelle Pham
* Section: 11am
* Date: 4/25/2020
* Time: 5:21 PM
*
* Project: csci205finalprojectsp2020
* Package: ObjectsPackage
* Class: GameSimulation
*
* Description: Actually runs the console version of the game
*
* ****************************************
*/
package ObjectsPackage;

import java.util.*;

/**
 * Main class used to simulate the start of the game in console
 * @author Michelle Pham
 */
public class ConsoleGame {

    /** List with all initialized players */
    private static ArrayList<Player> players = new ArrayList<>();

    /** empty constructor */
    public ConsoleGame() {
    }

    /**
     * overloaded constructor
     */
    public ConsoleGame(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Main method used to run the game
//     * @param args
     */
    public void runConsoleGame() {
        InitializePlayers initializePlayers = new InitializePlayers((ArrayList) players);
        players = initializePlayers.runInitializePlayers();

        printPlayers();
        pickOrder();
    }

    /**
     * Prints each player's information on their own line in the console
     */
    static private void printPlayers() {
        System.out.println("\n*** These are the players of the game ***");
        for (Player p : players) {
            System.out.println(p);
        }
    }

    /**
     * Picks a random person to start the game and displays the order or players
     */
    static private void pickOrder() {
        Random random = new Random();
        int startingPlayer = random.nextInt(players.size());
        ArrayList<Player> copy = (ArrayList<Player>) players.clone();

        if (startingPlayer != 0) {
            int indexPlayer = 0;
            int indexCopy = startingPlayer;
            while (indexCopy < copy.size()) {
                players.set(indexPlayer, copy.get(indexCopy));
                indexPlayer++;
                indexCopy++;
            }

            indexCopy = 0;
            while (indexCopy < startingPlayer) {
                players.set(indexPlayer, copy.get(indexCopy));
                indexCopy++;
                indexPlayer++;

            }
        }

        System.out.println("\n*** The order of players ***");
        for (Player p : players) {
            System.out.println(p.getName());
        }
    }
}