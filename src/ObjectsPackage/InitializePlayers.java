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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Helper class containing methods for prompting all player related information
 */
public class InitializePlayers {

    /**
     * console used for all user input
     */
    private Scanner sc = new Scanner(System.in);
    /**
     * instantiated list of all players - gets initialized later
     */
    private ArrayList<Player> players = new ArrayList<>();
    /**
     * reference list of player names already used (Strings)
     */
    private List<String> names = new ArrayList<String>();
    /**
     * reference list of all available tokens.
     * Respective token will be removed whenever chosen by a player.
     */
    private List<Token> availableTokens = new ArrayList<Token>(Arrays.asList(Token.CANNON,Token.CAR,Token.DOG,Token.HAT,Token.HORSE,Token.MONEYBAG,Token.PENGUIN,Token.PURSE,Token.SHOE,Token.WHEELBARROW));

    /** number of players in game */
    private int numP;


    /** empty constructor */
    public InitializePlayers() {
    }

    /**
     * overloaded constructor
     */
    public InitializePlayers(ArrayList<Player> players) {
        this.players = (ArrayList) players;
    }

    /**
     * Main method used to run the game
     */
    public ArrayList<Player> runInitializePlayers() {
        System.out.println("Welcome to the wonderful game of Monopoly!\n");

        askNumPlayers();

        // loop to initialize the correct number of players
        for (int i = 0; i < numP; i++) {
            System.out.println("\n*** Enter player number " + (i+1) + "'s information ***");
            initPlayerInfo();
        }

        return players;
    }

    /**
     * Helper method used to prompt for the amount of players to start game
     * Only accepts single digit of 2, 3, or 4
     * @author Michelle Pham
     */
    private int askNumPlayers() {
        String num;
        String nPlayers;
        while (true) {
            System.out.println("How many players would you like to have? [2, 3, or 4]");
            nPlayers = sc.next();
            if (nPlayers.matches("^[2-4]{1}$")) {
                System.out.println("Game will start with " + nPlayers + " players.");
                break;
            } else {
                System.out.println("ERROR: Input must be single digit of 2, 3, or 4. Please try again!");
            }
        }
        numP = Integer.parseInt(nPlayers);
        return numP;
    }

    /**
     * Helper method used to prompt for a single player's name.
     * Checks if name has already been claimed, looping until it is not.
     * @return desired player name
     * @author Michelle Pham
     */
     private String askPlayerName() {
        String playerName = "";
        while (true) {
            System.out.println("What would you like your player name to be?");
            playerName = sc.next();
            if (playerName.matches("^[0-9]+$")) { // if only provided numbers, add that to end of "player"
                playerName = "user" + playerName;
                if (!names.contains(playerName)) {
                    names.add(playerName);
                    break;
                } else {
                    System.out.println("ERROR: this name has already been used, Please try again!");
                }
            } else if (playerName.length() < 2) {
                System.out.println("ERROR: Player name must have more than two letters. Please try again!");
            } else {
                if (!names.contains(playerName)) {
                    names.add(playerName);
                    break;
                } else {
                    System.out.println("ERROR: this name is already in use. Please try again!");
                }
            }
        }
        System.out.println("Welcome " + playerName + "!");
        return playerName;
    }

    /** Helper method used to prompt for player's desired token.
     * Checks that it hasn't already been claimed
     * @author Michelle Pham
     * @return Token of user's choice */
     private Token askToken() {

        Token chosenToken = null;
        while (true) {
            System.out.println("Which token would you like to use?");
            System.out.println("Those still available: " + availableTokens);
            try {
                String input = sc.next();
                input = input.toUpperCase();
                chosenToken = Token.valueOf(input);
                if (availableTokens.contains(chosenToken)) {
                    break;
                } else {
                    System.out.println("ERROR: this token is already in use. Please try again!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Not a valid token choice! Please try again!");
            }
        }
        availableTokens.remove(chosenToken);
        return chosenToken;
    }

    /**
     * Creates a new player object and initializes their information.
     * Uses information obtained from the helper methods
     * @author Michelle Pham
     */
    private void initPlayerInfo() {
        String pName = askPlayerName();
        Token pToken = askToken();
        Player newPlayer = new Player(pName, pToken);
        players.add(newPlayer);
//        System.out.println(newPlayer);    // uncomment to see what the player initialized information looks like
    }

    public int getNumP() {
        return numP;
    }
}