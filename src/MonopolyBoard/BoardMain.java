/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Elizabeth Raynor
 * Section: 11 am
 * Date: 4/29/2020
 * Time: 9:38 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: BoardMain
 *
 * Description: Runs the board
 *
 * ****************************************
 */

package MonopolyBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Run the monopoly board
 *
 * @author Elizabeth Raynor
 */
public class BoardMain extends Application {

    /** the view */
    private BoardView theView;

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Initializes the BoardView
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new BoardView();
    }

    /**
     * Sets the scene and shows the primary stage
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        // Add the scene graph to the stage
        primaryStage.setScene(new Scene(theView.getRoot()));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);

        // Display the scene
        primaryStage.show();

    }
}
