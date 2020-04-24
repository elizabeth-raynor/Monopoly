package MonopolyBoard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//import java.awt.*;

/**
 * This class has a pop up window that would simulate a player choosing their token
 */
public class TokenMain extends Application {

    /** initialize root      */
    private VBox root = new VBox(10);

    /** initialize horizontal row for player info */
    private HBox playerPane = new HBox(10);
    /** instantiating input field for player's name */
    private TextField textFieldInputName = new TextField();
    private String playerName;

    /** initialize horizontal row for token prompts */
    private HBox tokenPane = new HBox(10);
    /** initialize token drop down menu */
    private ChoiceBox<String> tokenDropDown = new ChoiceBox<>();
    /** initialize show token button  */
    private Button btnShowToken = new Button("Show me my token!");
    /** instantiating tokenImage */
    private Image tokenImage;
    /** initializing token ImageView */
    private ImageView tokenImageView = new ImageView();
    /** instantiate tokenChoice String */
    private String tokenChoice;
    /** instantiate label displaying text version of user's choices */
    private Label resultLabel = new Label();


    /**
     * launches the pop up window
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /** setting the scene */
    public void start(Stage primaryStage) {
        initPlayerInput();
        initTokenDropDown();
        initImageView();
        eventHandle();

        //create scene & set scene
        Scene scene = new Scene(root, 400, 400);
        root.setBackground(new Background(new BackgroundFill(Color.web("d4ffde"),null,null)));
        primaryStage.setScene(scene);

        //add title
        primaryStage.setTitle("Choosing Your Player Token");

        //show
        primaryStage.show();
    }

    /** make button actually display player token*/
    private void eventHandle() {
        // updating token image based on drop down choice once clicked
        btnShowToken.setOnAction(event -> {
            tokenChoice = tokenDropDown.getValue();
            tokenImageView.setImage(TokenView.setStringToTokenImage(tokenChoice));
            playerName = textFieldInputName.getText();
            resultLabel.setText("Player " + playerName + " chose to use the " + getTokenChoice());
        });
    }

    /** helper method used to add token image space to scene */
    private void initImageView() {
        // adding token image to pane
        root.getChildren().add(btnShowToken);
        root.getChildren().add(tokenImageView);
        root.getChildren().add(resultLabel);
        root.setAlignment(Pos.TOP_CENTER);
    }

    /** helper method used to set up token drop down menu */
    private void initTokenDropDown() {
        // drop down menu for token choices
        tokenPane.getChildren().add(new Label("Which token would you like to use?"));
        tokenDropDown.getItems().addAll("cannon","car","dog","hat","horse","moneybag","penguin","purse","shoe","wheelbarrow");
        tokenDropDown.getSelectionModel();
        tokenPane.getChildren().add(tokenDropDown);
        tokenPane.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(tokenPane);
    }

    /** helper method used to set up input player information (name) */
    private void initPlayerInput() {
        // set root padding
        root.setPadding(new Insets(15));
        // playerPane setup
        playerPane.getChildren().add(new Label("Player name:"));
        playerPane.getChildren().add(textFieldInputName);
        root.getChildren().add(playerPane);
        playerPane.setAlignment(Pos.TOP_CENTER);
    }

    /**
     * get name from player's input
     * @return string version of player name
     */
    public String getTextFieldInputName() {
        return textFieldInputName.getText();
    }

    /**
     * get token choice
     * @return
     */
    public String getTokenChoice() {
        return tokenChoice;
    }
} // end of TokenFX class
