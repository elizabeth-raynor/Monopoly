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

import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class BoardView {

//    /** The model of the mvc */
//

    /** The root of the scene */
    private final GridPane root;


    /** The root width and height */
    private final double BOARD_SIZE = 630;

    /** The background color */
    private final Color BACKGROUND = Color.web("#d4ffde");

    /** The monopoly name */



    /**
     * Constructor
     */
    public BoardView() {

        // Initialize and format the root
        root = new GridPane();
        root.setPrefSize(BOARD_SIZE, BOARD_SIZE);

        // Fill background of root
        root.setBackground(new Background(new BackgroundFill(BACKGROUND, null, null)));

        // Size the columns and rows
        ColumnConstraints columnEdge = new ColumnConstraints();
        columnEdge.setPercentWidth(14);
        ColumnConstraints columnMiddle = new ColumnConstraints();
        columnMiddle.setPercentWidth(8);
        root.getColumnConstraints().addAll(columnEdge, columnMiddle, columnMiddle, columnMiddle,
                columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnMiddle, columnEdge);

        RowConstraints rowEdge = new RowConstraints();
        rowEdge.setPercentHeight(14);
        RowConstraints rowMiddle = new RowConstraints();
        rowMiddle.setPercentHeight(8);
        root.getRowConstraints().addAll(rowEdge, rowMiddle, rowMiddle, rowMiddle, rowMiddle, rowMiddle,
                rowMiddle, rowMiddle, rowMiddle, rowMiddle, rowEdge);



        initProperties();


//        // Create Monopoly name
//        monopolyName = new Label("MONOPOLY");
//        monopolyName.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
    }

    public GridPane getRoot() {
        return root;
    }

    public void initProperties() {
//        /** the width of the property tiles */
//        double PROP_WIDTH = BOARD_SIZE*.0769;
//        /** The height of the property tiles */
//        double PROP_HEIGHT = BOARD_SIZE*.13;
//        root.add(new BoardTiles("FREE PARKING", PROP_HEIGHT), 0,0);
//        BoardTiles y1 = new BoardTiles(Color.RED, "KENTUCKY AVENUE", 220, PROP_HEIGHT, PROP_WIDTH);
//        root.add(y1, 1, 0);
//        root.add(new BoardTiles("CHANCE", PROP_HEIGHT, PROP_WIDTH), 2, 0);
//        root.add(new BoardTiles(Color.RED, "INDIANA AVENUE", 220, PROP_HEIGHT, PROP_WIDTH), 3, 0);
//        root.add(new BoardTiles(Color.RED, "ILLINOIS AVENUE", 220, PROP_HEIGHT, PROP_WIDTH), 4, 0);
//        root.add(new BoardTiles("B. & O. RAILROAD", 200, PROP_HEIGHT, PROP_WIDTH),5, 0);
//        root.add(new BoardTiles(Color.YELLOW, "ATLANTIC AVENUE", 260, PROP_HEIGHT, PROP_WIDTH), 6, 0);
//        root.add(new BoardTiles(Color.YELLOW, "VETNOR AVENUE", 260, PROP_HEIGHT, PROP_WIDTH), 7, 0);
//        root.add(new BoardTiles("WATER WORKS", 150, PROP_HEIGHT, PROP_WIDTH), 8, 0);
//        root.add(new BoardTiles(Color.YELLOW, "MARVIN GARDENS", 260, PROP_HEIGHT, PROP_WIDTH), 9, 0);
//        root.add(new BoardTiles("GO TO JAIL", PROP_HEIGHT), 10, 0);


        root.add(new BoardTiles("FREE PARKING"), 0,0);

        BoardTiles kentucky = new BoardTiles(Color.RED, "KENTUCKY AVENUE", 220);
        kentucky.setRotate(180);
        root.add(kentucky, 1, 0);

        BoardTiles blueChance = new BoardTiles("CHANCE");
        blueChance.setRotate(180);
        root.add(blueChance, 2, 0);

        BoardTiles indiana = new BoardTiles(Color.RED, "INDIANA AVENUE", 220);
        indiana.setRotate(180);
        root.add(indiana , 3, 0);

        BoardTiles illinois = new BoardTiles(Color.RED, "ILLINOIS AVENUE", 220);
        illinois.setRotate(180);
        root.add(illinois, 4, 0);

        BoardTiles boRR = new BoardTiles("B. & O. RAILROAD", 200);
        boRR.setRotate(180);
        root.add(boRR,5, 0);

        BoardTiles atlantic = new BoardTiles(Color.YELLOW, "ATLANTIC AVENUE", 260);
        atlantic.setRotate(180);
        root.add(atlantic, 6, 0);

        BoardTiles ventor = new BoardTiles(Color.YELLOW, "VETNOR AVENUE", 260);
        ventor.setRotate(180);
        root.add(ventor, 7, 0);

        BoardTiles waterWorks = new BoardTiles("WATER WORKS", 150);
        waterWorks.setRotate(180);
        root.add(waterWorks, 8, 0);

        BoardTiles marvin = new BoardTiles(Color.YELLOW, "MARVIN GARDENS", 260);
        marvin.setRotate(180);
        root.add(marvin, 9, 0);

        BoardTiles goToJail = new BoardTiles("GO TO JAIL");
        root.add(goToJail, 10, 0);

        BoardTiles jail = new BoardTiles("JAIL");
        root.add(jail, 0, 10);

        BoardTiles connecticut = new BoardTiles(Color.LIGHTBLUE, "CONNECTICUT", 120);
        root.add(connecticut, 1, 10);

        BoardTiles vermont = new BoardTiles(Color.LIGHTBLUE, "VERMONT", 100);
        root.add(vermont, 2, 10);

        BoardTiles pinkChance = new BoardTiles("CHANCE");
        root.add(pinkChance, 3, 10);

        BoardTiles oriental = new BoardTiles(Color.LIGHTBLUE, "ORIENTAL AVENUE", 100);
        root.add(oriental, 4, 10);

        BoardTiles readingRR = new BoardTiles("READING RAILROAD");
        root.add(readingRR, 5, 10);

        BoardTiles incomeTax = new BoardTiles("INCOME TAX, PAY", 200);
        root.add(incomeTax, 6, 10);

        BoardTiles baltic = new BoardTiles(Color.BROWN, "BALTIC AVENUE", 60);
        root.add(baltic, 7,10);

        BoardTiles commChest2 = new BoardTiles("COMMUNITY CHEST");
        root.add(commChest2, 8, 10);

        BoardTiles mediterranean = new BoardTiles(Color.BROWN, "MEDITERRANEAN AVENUE", 60);
        root.add(mediterranean, 9, 10);

        BoardTiles go = new BoardTiles("GO");
        root.add(go, 10, 10);


        BoardTiles new_york = new BoardTiles(Color.ORANGE, "NEW YORK AVENUE", 200);
        root.add(new_york, 0, 1);

        BoardTiles tennessee = new BoardTiles(Color.ORANGE, "TENNESSEE", 180);
//        tennessee.setRotate(90);
        root.add(tennessee, 0, 2);

        BoardTiles commChest1 = new BoardTiles("COMMUNITY CHEST");
//        commChest1.setRotate(90);
        root.add(commChest1, 0,3 );

        BoardTiles stJame = new BoardTiles(Color.ORANGE, "ST. JAMES", 180);
        root.add(stJame, 0, 4);

        BoardTiles paRR = new BoardTiles("PENNSYLVANIA RIALROAD", 200);
        root.add(paRR, 0, 5);

        BoardTiles virginia = new BoardTiles(Color.DEEPPINK, "VIRGINIA AVENUA", 160);
        root.add(virginia, 0, 6);

        BoardTiles states = new BoardTiles(Color.DEEPPINK, "STATES AVENUE", 140);
        root.add(states, 0, 7);

        BoardTiles electricity = new BoardTiles("ELECTRIC COMPANY", 150);
        root.add(electricity, 0, 8);

        BoardTiles stCharles = new BoardTiles(Color.DEEPPINK, "ST. CHARLES PLACE", 140);
        root.add(stCharles, 0, 9);

        BoardTiles pacific = new BoardTiles(Color.GREEN, "PACIFIC AVENUE", 300);
        root.add(pacific, 10, 1);

        BoardTiles northCarol = new BoardTiles(Color.GREEN, "NORTH CAROLINA AVENUE", 300);
        root.add(northCarol, 10, 2);

        BoardTiles commChest3 = new BoardTiles("COMMUNITY CHEST");
        root.add(commChest3, 10, 3);

        BoardTiles penn = new BoardTiles(Color.GREEN, "PENNSYLVANIA AVENUE", 320);
        root.add(penn,10, 4 );

        BoardTiles shortRR = new BoardTiles("SHORT LINE", 200);
        root.add(shortRR, 10, 5);

        BoardTiles orangeChance = new BoardTiles("CHANCE");
        root.add(orangeChance, 10, 6);

        BoardTiles park = new BoardTiles(Color.DODGERBLUE , "PARK PLACE", 350);
        root.add(park, 10, 7);

        BoardTiles luxTax = new BoardTiles("LUXURY TAX, PAY", 100);
        root.add(luxTax, 10, 8);

        BoardTiles boardwalk = new BoardTiles(Color.DODGERBLUE, "BOARDWALK", 400);
        root.add(boardwalk, 10,9);
    }
}