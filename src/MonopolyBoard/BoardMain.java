package MonopolyBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardMain extends Application {

    /** the view */
    private BoardView theView;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new BoardView();
    }

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
