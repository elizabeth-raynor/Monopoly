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

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.io.File;


public class BoardView {


    /** The root of the scene */
    private final GridPane root;

    /** The root height */
    private final double BOARD_HEIGHT = 630;

    /** The root width */
    private final double BOARD_WIDTH = BOARD_HEIGHT + 270;

    /** The percent of the board width that each column has */
    private final double EDGE_WIDTH = 9.8;
    private final double MIDDLE_WIDTH = 5.6;
    private final double SIDE_PANEL_WIDTH = 30;

    /** The percent of the board height that each row has */
    private final double EDGE_HEIGHT = 14;
    private final double MIDDLE_HEIGHT = 8;

    /** The background color */
    private final Color BACKGROUND = Color.web("#d4ffde");

    /** The monopoly name */
    private Label monopolyName;


    /**
     * Constructor
     */
    public BoardView() {

        // Initialize and format the root
        root = new GridPane();
        root.setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);

        // Fill background of root
        root.setBackground(new Background(new BackgroundFill(BACKGROUND, null, null)));

        // Size the grids in the root
        sizeColumns();
        sizeRows();

        initCorners();
        initChance();
        initCommChest();
        initUtils();
        initRR();
        initTax();

        // Initialize all the properties
        initProperties();

        // Initialize the die
        initDie();

        // Initialize the controls
        initControls();

        // Create Monopoly name
        initMonopolyName();
    }

    /**
     * Size the columns of the GridPane
     */
    private void sizeColumns() {
        // Size the columns of the GridPane
        ColumnConstraints columnEdge = new ColumnConstraints();
        columnEdge.setPercentWidth(EDGE_WIDTH);
        ColumnConstraints columnMiddle = new ColumnConstraints();
        columnMiddle.setPercentWidth(MIDDLE_WIDTH);
        ColumnConstraints columnSidePanel = new ColumnConstraints();
        columnSidePanel.setPercentWidth(SIDE_PANEL_WIDTH);
        root.getColumnConstraints().addAll(columnEdge, columnMiddle, columnMiddle, columnMiddle,
                columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle,
                columnEdge, columnSidePanel);
    }

    /**
     * Size the rows of the GridPane
     */
    private void sizeRows() {
        // Size the rows of the GridPane
        RowConstraints rowEdge = new RowConstraints();
        rowEdge.setPercentHeight(EDGE_HEIGHT);
        RowConstraints rowMiddle = new RowConstraints();
        rowMiddle.setPercentHeight(MIDDLE_HEIGHT);
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

        BoardTiles tennessee = new BoardTiles(Color.ORANGE, "TENNESSEE", 180);
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

    private void initUtils() {
        // UTILITIES
        BoardTiles waterWorks = new BoardTiles("WATER WORKS", "src/BoardImages/WaterWorks.png",40);
//        BoardTiles waterWorks = new BoardTiles("WATER WORKS", 150);
        root.add(waterWorks, 8, 0);

//        BoardTiles electricity = new BoardTiles("ELECTRIC COMPANY", "src/BoardImages/Electricity.png", 150);
        BoardTiles electricity = new BoardTiles("ELECTRIC COMPANY",  150);
        root.add(electricity, 0, 8);
    }

    private void initRR() {
        // RAILROADS

        BoardTiles boRR = new BoardTiles("B. & O. RAILROAD", "src/BoardImages/Train.png", 200, 35);
//        BoardTiles boRR = new BoardTiles("B. & O. RAILROAD", 200);
        root.add(boRR,5, 0);

        BoardTiles readingRR = new BoardTiles("READING RAILROAD", "src/BoardImages/Train.png", 200, 35);
//        BoardTiles readingRR = new BoardTiles("READING RAILROAD", 200);
        root.add(readingRR, 5, 10);

//        BoardTiles paRR = new BoardTiles("PENNSYLVANIA RAILROAD", "src/BoardImages/Train.png", 200, 35);
        BoardTiles paRR = new BoardTiles("PENNSYLVANIA RAILROAD", 200);
//        paRR.setRotate(90);
        root.add(paRR, 0, 5);

//        BoardTiles shortRR = new BoardTiles("SHORT LINE", "src/BoardImages/Train.png",200);
        BoardTiles shortRR = new BoardTiles("SHORT LINE",200);
        root.add(shortRR, 10, 5);
    }

    private void initTax() {
        // TAX
//        BoardTiles luxTax = new BoardTiles("LUXURY TAX, PAY", "src/BoardImages/LuxuryTax.png", 100);
        BoardTiles luxTax = new BoardTiles("LUXURY TAX, PAY",  100);
        root.add(luxTax, 10, 8);

//        BoardTiles incomeTax = new BoardTiles("INCOME TAX, PAY", "src/BoardImages/LuxuryTax.png", 200);
        BoardTiles incomeTax = new BoardTiles("INCOME TAX, PAY", 200);
        root.add(incomeTax, 6, 10);
    }

    private void initCorners() {

        // CORNERS
        root.add(new BoardTiles("FREE PARKING", "src/BoardImages/FreeParking.png", 50), 0,0);
//        root.add(new BoardTiles("FREE PARKING"), 0,0);

        BoardTiles goToJail = new BoardTiles("GO TO JAIL", "src/BoardImages/GoToJail.png", 50);
//        BoardTiles goToJail = new BoardTiles("GO TO JAIL");
        root.add(goToJail, 10, 0);

//        BoardTiles go = new BoardTiles("GO", "src/BoardImages/GoArrow.png");
        BoardTiles go = new BoardTiles("GO");
        root.add(go, 10, 10);

//        BoardTiles jail = new BoardTiles("JAIL", "src/BoardImages/GoToJail.png");
        BoardTiles jail = new BoardTiles("JAIL");
        root.add(jail, 0, 10);
//        initCommChest();


    }

    private void initCommChest() {
        // COMMUNITY CHEST
        BoardTiles commChest1 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 35);
//        BoardTiles commChest1 = new BoardTiles("COMMUNITY CHEST");
        root.add(commChest1, 0,3 );

        BoardTiles commChest2 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 35);
//        BoardTiles commChest2 = new BoardTiles("COMMUNITY CHEST");
        root.add(commChest2, 8, 10);

        BoardTiles commChest3 = new BoardTiles("COMMUNITY CHEST", "src/BoardImages/CommunityChest.png", 35);
//        BoardTiles commChest3 = new BoardTiles("COMMUNITY CHEST");
        root.add(commChest3, 10, 3);
    }

    private void initChance() {
        // CHANCE
        BoardTiles orangeChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 20);
//        BoardTiles orangeChance = new BoardTiles("CHANCE");
        root.add(orangeChance, 10, 6);

        BoardTiles blueChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 35);
//        BoardTiles blueChance = new BoardTiles("CHANCE" );
        root.add(blueChance, 2, 0);

        BoardTiles pinkChance = new BoardTiles("CHANCE", "src/BoardImages/BlueChance.png", 35);
//        BoardTiles pinkChance = new BoardTiles("CHANCE");
        root.add(pinkChance, 3, 10);
    }

    /**
     * Initializes the die
     */
    private void initDie() {

        DieView dieView = new DieView();
        VBox dieViewRoot = dieView.getRoot();

        dieViewRoot.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        dieViewRoot.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
        root.add(dieViewRoot, 11, 0, 1, 2);

    }

    /**
     * Initializes the controls
     */
    private void initControls() {
        // Mark of where the controls will be // TODO remove this and add the controls
        Label controls = new Label("CONTROLS");
        controls.setTextAlignment(TextAlignment.CENTER);
        controls.setAlignment(Pos.CENTER);
        controls.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        controls.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null)));
        root.add(controls, 11, 2, 1, 9);
    }

    /**
     * Intializes the Monopoly Name in the Middle
     */
    private void initMonopolyName() {
//        monopolyName = new Label("MONOPOLY");
//        monopolyName.setTextFill(Color.WHITE);
//        monopolyName.setAlignment(Pos.CENTER);
//        monopolyName.setFont(new Font("Arial", 40));
//        monopolyName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        monopolyName.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
//        monopolyName.setRotate(325);
//        root.add(monopolyName, 3,5, 5, 1);


        File image = new File("src/BoardImages/MonopolyLogo.png");
        Image monopolyImage = new Image(image.toURI().toString());
        System.out.println(monopolyImage.getHeight());
        System.out.println(monopolyImage.getWidth());
        ImageView monopolyLogo = new ImageView(monopolyImage);
        monopolyLogo.setPreserveRatio(true);
        monopolyLogo.setFitHeight(100);
        root.add(monopolyLogo, 3, 4, 5, 3);
    }
}