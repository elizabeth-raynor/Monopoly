/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Elizabeth Raynor
 * Section: 11 am
 * Date: 4/14/2020
 * Time: 7:31 PM
 *
 * Project: csci205finalprojectsp2020
 * Package: Board
 * Class: BoardView
 *
 * Description: creates the scene for the Monopoly board
 *
 * ****************************************
 */
package MonopolyBoard;

import ObjectsPackage.ConsoleGame;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;


/**
 * Creates the scene for the board
 *
 * @author Elizabeth Raynor
 */
public class BoardView {

    /** The root of the scene */
    private final GridPane root;

    /** The root height */
    private final double BOARD_HEIGHT = 630;

    /** The root width */
    private final double BOARD_WIDTH = BOARD_HEIGHT + 270;

    /** The column constraints */
    private final ColumnConstraints columnEdge = new ColumnConstraints();
    private final ColumnConstraints columnMiddle = new ColumnConstraints();
    private final ColumnConstraints columnSidePanel = new ColumnConstraints();

    /** The row constraints */
    private final RowConstraints rowEdge = new RowConstraints();
    private final RowConstraints rowMiddle = new RowConstraints();

    /** The percent of the board width that each column has */
    private final double EDGE_COL_WIDTH = 9.8;
    private final double MIDDLE_COL_WIDTH = 5.6;
    private final double SIDE_PANEL_WIDTH = 30;

    /** The percent of the board height that each row has */
    private final double EDGE_ROW_HEIGHT = 14;
    private final double MIDDLE_ROW_HEIGHT = 8;

    /** The background color */
    private final Color BACKGROUND = Color.web("#d4ffde");

    /** The ConsoleGame */
    ConsoleGame consoleGame = new ConsoleGame();

    /**
     * Constructor
     */
    public BoardView() {

        // Initialize and format the root
        root = new GridPane();
        root.setMaxSize(BOARD_WIDTH, BOARD_HEIGHT);

        // Fill background of root
        root.setBackground(new Background(new BackgroundFill(BACKGROUND, null, null)));

        // Size the grids in the root
        sizeColumns();
        sizeRows();

        // Initialize the board tiles
        initCorners();
        initChance();
        initCommChest();
        initUtils();
        initRR();
        initTax();
        initProperties();

        // Initialize the die
        initDie();

        // Initialize the player info display
        initPlayerInfo();

        // Initialize the controls
        initControls();

        // Create Monopoly name
        initMonopolyName();
    }

    /**
     * Size the columns of the GridPane
     */
    private void sizeColumns() {
        columnEdge.setPercentWidth(EDGE_COL_WIDTH);
        columnMiddle.setPercentWidth(MIDDLE_COL_WIDTH);
        columnSidePanel.setPercentWidth(SIDE_PANEL_WIDTH);
        root.getColumnConstraints().addAll(columnEdge, columnMiddle, columnMiddle, columnMiddle,
                columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle,
                columnEdge, columnSidePanel);
    }

    /**
     * Size the rows of the GridPane
     */
    private void sizeRows() {
        rowEdge.setPercentHeight(EDGE_ROW_HEIGHT);
        rowMiddle.setPercentHeight(MIDDLE_ROW_HEIGHT);
        root.getRowConstraints().addAll(rowEdge, rowMiddle, rowMiddle, rowMiddle, rowMiddle, rowMiddle,
                rowMiddle, rowMiddle, rowMiddle, rowMiddle, rowEdge);
    }

    /**
     * @return the root
     */
    public GridPane getRoot() {
        return root;
    }

    /**
     * Initializes all the properties
     */
    public void initProperties() {

        BoardTiles kentucky = new BoardTiles(Color.RED, "KENTUCKY AVENUE", 220);
        root.add(kentucky, 1, 0);

        BoardTiles indiana = new BoardTiles(Color.RED, "INDIANA AVENUE", 220);
        root.add(indiana , 3, 0);

        BoardTiles illinois = new BoardTiles(Color.RED, "ILLINOIS AVENUE", 220);
        root.add(illinois, 4, 0);

        BoardTiles atlantic = new BoardTiles(Color.YELLOW, "ATLANTIC AVENUE", 260);
        root.add(atlantic, 6, 0);

        BoardTiles ventor = new BoardTiles(Color.YELLOW, "VETNOR AVENUE", 260);
        root.add(ventor, 7, 0);

        BoardTiles marvin = new BoardTiles(Color.YELLOW, "MARVIN GARDENS", 260);
        root.add(marvin, 9, 0);

        BoardTiles connecticut = new BoardTiles(Color.LIGHTBLUE, "CONNECTICUT AVENUE", 120);
        root.add(connecticut, 1, 10);

        BoardTiles vermont = new BoardTiles(Color.LIGHTBLUE, "VERMONT AVENUE", 100);
        root.add(vermont, 2, 10);

        BoardTiles oriental = new BoardTiles(Color.LIGHTBLUE, "ORIENTAL AVENUE", 100);
        root.add(oriental, 4, 10);

        BoardTiles baltic = new BoardTiles(Color.BROWN, "BALTIC AVENUE", 60);
        root.add(baltic, 7,10);

        BoardTiles mediterranean = new BoardTiles(Color.BROWN, "MEDITERRANEAN AVENUE", 60);
        root.add(mediterranean, 9, 10);

        BoardTiles new_york = new BoardTiles(Color.ORANGE, "NEW YORK AVENUE", 200);
        root.add(new_york, 0, 1);

        BoardTiles tennessee = new BoardTiles(Color.ORANGE, "TENNESSEE AVENUE", 180);
        root.add(tennessee, 0, 2);

        BoardTiles stJame = new BoardTiles(Color.ORANGE, "ST. JAMES", 180);
        root.add(stJame, 0, 4);

        BoardTiles virginia = new BoardTiles(Color.DEEPPINK, "VIRGINIA AVENUE", 160);
        root.add(virginia, 0, 6);

        BoardTiles states = new BoardTiles(Color.DEEPPINK, "STATES AVENUE", 140);
        root.add(states, 0, 7);

        BoardTiles stCharles = new BoardTiles(Color.DEEPPINK, "ST. CHARLES PLACE", 140);
        root.add(stCharles, 0, 9);

        BoardTiles pacific = new BoardTiles(Color.GREEN, "PACIFIC AVENUE", 300);
        root.add(pacific, 10, 1);

        BoardTiles northCarol = new BoardTiles(Color.GREEN, "NORTH CAROLINA AVE.", 300);
        root.add(northCarol, 10, 2);

        BoardTiles penn = new BoardTiles(Color.GREEN, "PENNSYLVANIA AVENUE", 320);
        root.add(penn,10, 4 );

        BoardTiles park = new BoardTiles(Color.DODGERBLUE , "PARK PLACE", 350);
        root.add(park, 10, 7);

        BoardTiles boardwalk = new BoardTiles(Color.DODGERBLUE, "BOARDWALK", 400);
        root.add(boardwalk, 10,9);
    }

    /**
     * Initialize the utilities
     */
    private void initUtils() {
        BoardTiles waterWorks = new BoardTiles("WATER WORKS", "src/BoardImages/WaterWorks.png", 150,30);
        root.add(waterWorks, 8, 0);

        BoardTiles electricity = new BoardTiles("ELECTRIC COMPANY", "src/BoardImages/LightBulb.png", 150,18);
        root.add(electricity, 0, 8);
    }

    /**
     * Initialize the railroads
     */
    private void initRR() {
        BoardTiles boRR = new BoardTiles("B. & O. RAILROAD", "src/BoardImages/Train.png", 200, 35);
        root.add(boRR,5, 0);

        BoardTiles readingRR = new BoardTiles("READING RAILROAD", "src/BoardImages/Train.png", 200, 35);
        root.add(readingRR, 5, 10);

        BoardTiles paRR = new BoardTiles("PENNSYLVANIA RAILROAD", "src/BoardImages/Train.png", 200, 18);
        root.add(paRR, 0, 5);

        BoardTiles shortRR = new BoardTiles("SHORT LINE", "src/BoardImages/Train.png",200, 18);
        root.add(shortRR, 10, 5);
    }

    /**
     * Initialize the tax tiles
     */
    private void initTax() {
        BoardTiles luxTax = new BoardTiles("LUXURY TAX, PAY", "src/BoardImages/LuxuryTax.png", 100, 15);
        root.add(luxTax, 10, 8);

        BoardTiles incomeTax = new BoardTiles("INCOME TAX, PAY", 200);
        root.add(incomeTax, 6, 10);
    }

    /**
     * Initialize the corners
     */
    private void initCorners() {
        // Free Parking
        root.add(new BoardTiles("FREE PARKING", "src/BoardImages/FreeParking.png", 50), 0,0);

        // Go to Jail
        BoardTiles goToJail = new BoardTiles("GO TO JAIL", "src/BoardImages/GoToJail.png", 50);
        root.add(goToJail, 10, 0);

        // GO image
        File fGo = new File("src/BoardImages/GoArrow.png");
        ImageView go = new ImageView(new Image(fGo.toURI().toString()));
        go.setPreserveRatio(true);
        go.setFitWidth(90);
        root.add(go, 10, 10);

        // Jail iamge
        File fJail = new File("src/BoardImages/Jail.png");
        ImageView jail = new ImageView(new Image(fJail.toURI().toString()));
        jail.setFitWidth(111);
        jail.setFitHeight(90);
        root.add(jail, 0, 10);


    }

    /**
     * Initialize the community chest tiles
     */
    private void initCommChest() {
        BoardTiles commChest1 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 35);
        root.add(commChest1, 0,3 );

        BoardTiles commChest2 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 45);
        root.add(commChest2, 8, 10);

        BoardTiles commChest3 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 35);
        root.add(commChest3, 10, 3);
    }

    /**
     * Initialize the chance tiles
     */
    private void initChance() {
        BoardTiles orangeChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 18);
        root.add(orangeChance, 10, 6);

        BoardTiles blueChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 35);
        root.add(blueChance, 2, 0);

        BoardTiles pinkChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 35);
        root.add(pinkChance, 3, 10);
    }

    /**
     * Initializes the die
     *
     * @author Amisha Chhetri
     */
    private void initDie() {
        DieRoll dieRoll = new DieRoll();
        VBox dieViewRoot = dieRoll.getRoot();
        dieViewRoot.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        dieViewRoot.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
        root.add(dieViewRoot, 11, 0, 1, 2);

    }

    /**
     * Initialize the player info
     *
     * @author Michelle Pham
     */
    private void initPlayerInfo() {
        PlayerView playerView = new PlayerView();
        VBox playerViewRoot = playerView.getRoot();
        playerViewRoot.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        playerViewRoot.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
        root.add(playerViewRoot, 11, 2, 1, 3);
    }

    /**
     * Initializes the controls
     */
    private void initControls() {
        GridPane controls = new GridPane();
        // Mark of where the controls will be // TODO remove this and add the controls
        controls.setAlignment(Pos.CENTER);
        controls.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        controls.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
        Button token = new Button("Input Player Info");
        token.setOnAction(event -> new TokenStage());
        controls.add(token, 0, 0);

        Button console = new Button("Start Console Game");
        console.setOnAction(event -> consoleGame.runConsoleGame());
        controls.add(console,0, 1);

        root.add(controls, 11, 5, 1, 6);

    }

    /**
     * Initializes the Monopoly Name in the Middle
     */
    private void initMonopolyName() {
        File image = new File("src/BoardImages/MonopolyLogo.png");
        Image monopolyImage = new Image(image.toURI().toString());
        ImageView monopolyLogo = new ImageView(monopolyImage);
        monopolyLogo.setPreserveRatio(true);
        monopolyLogo.setFitHeight(100);
        root.add(monopolyLogo, 3, 4, 5, 3);
    }
}