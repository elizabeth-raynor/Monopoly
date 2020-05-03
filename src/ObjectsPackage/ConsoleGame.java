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
    private static ArrayList<Player> playerList = new ArrayList<>();

    /** empty constructor */
    public ConsoleGame() {
    }

    /**
     * overloaded constructor
     */
    public ConsoleGame(ArrayList<Player> players) {
        this.playerList = players;
    }

    /**
     * Main method used to run the game
     * @param args
     */
    public static void main(String[] args) {
        InitializePlayers initializePlayers = new InitializePlayers((ArrayList) playerList);
        playerList = initializePlayers.runInitializePlayers();
        System.out.println(playerList);
    }

}