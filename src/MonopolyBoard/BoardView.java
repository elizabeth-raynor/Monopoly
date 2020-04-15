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

        BoardTiles chance = new BoardTiles("CHANCE");
        chance.setRotate(180);
        root.add(chance, 2, 0);

        BoardTiles indiana = new BoardTiles(Color.RED, "INDIANA AVENUE", 220);
        indiana.setRotate(180);
        root.add(indiana , 3, 0);

        BoardTiles illinois = new BoardTiles(Color.RED, "ILLINOIS AVENUE", 220);
        illinois.setRotate(180);
        root.add(illinois, 4, 0);

        BoardTiles rr1 = new BoardTiles("B. & O. RAILROAD", 200);
        rr1.setRotate(180);
        root.add(rr1,5, 0);

        BoardTiles atlantic = new BoardTiles(Color.YELLOW, "ATLANTIC AVENUE", 260);
        atlantic.setRotate(180);
        root.add(atlantic, 6, 0);

        BoardTiles ventor = new BoardTiles(Color.YELLOW, "VETNOR AVENUE", 260);
        ventor.setRotate(180);
        root.add(ventor, 7, 0);

        BoardTiles water_works = new BoardTiles("WATER WORKS", 150);
        water_works.setRotate(180);
        root.add(water_works, 8, 0);

        BoardTiles marvin = new BoardTiles(Color.YELLOW, "MARVIN GARDENS", 260);
        marvin.setRotate(180);
        root.add(marvin, 9, 0);

        BoardTiles jail = new BoardTiles("GO TO JAIL");
        root.add(jail, 10, 0);



    }
}