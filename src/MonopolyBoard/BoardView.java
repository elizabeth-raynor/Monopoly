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
    private final double BOARD_SIZE = 600;

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
        root.setPrefSize(BOARD_SIZE, BOARD_SIZE);

        // Fill background of root
        root.setBackground(new Background(new BackgroundFill(BACKGROUND, null, null)));


        initProperties();


//        // Create Monopoly name
//        monopolyName = new Label("MONOPOLY");
//        monopolyName.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
    }

    public GridPane getRoot() {
        return root;
    }

    public void initProperties() {
        /** the width of the property tiles */
        double PROP_WIDTH = BOARD_SIZE / 12.09;
        /** The height of the property tiles */
        double PROP_HEIGHT = BOARD_SIZE / 7.72;
        root.getChildren().add(new PropertyFX(Color.SKYBLUE, "CONNECTICUT AVENUE", 120, PROP_HEIGHT, PROP_WIDTH));
//        root.add(new PropertyFX(Color.ORANGE, "NEW YORK AVENUE", 200, PROP_HEIGHT, PROP_WIDTH));
    }
}