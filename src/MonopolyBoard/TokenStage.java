/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 4/22/2020
 * Time: 9:25 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: MonopolyBoard
 * Class: TokenView
 *
 * Description: Creates pop up window to initialize player input
 *
 * ****************************************
 */

package MonopolyBoard;

import ObjectsPackage.Token;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Creates a pop up window that would simulate a player choosing their token
 * @author Michelle Pham
 */
public class TokenStage {

    /** initialize root */
    private VBox root = new VBox(10);

    /** instantiating input field for player's name */
    private TextField textFieldInputName = new TextField();

    /** initialize token drop down menu */
    private ChoiceBox<String> tokenDropDown = new ChoiceBox<>();

    /** initialize show token button  */
    private Button btnShowToken = new Button("Show me my token!");

    /** initializing token ImageView */
    private ImageView tokenImageView = new ImageView();

    /** instantiate tokenChoice as a String */
    private String tokenChoice;

    /** instantiate label displaying text version of user's choices */
    private Label resultLabel = new Label();

    /** Token enum from event handler
     * Initializes once button is clicked and selection is made */
    private Token token;

    /**
     * String of player's name
     * Initialized once button is clicked and name is typed into textfield */
    private String playerName;

    TokenStage() {
        Stage primaryStage = new Stage();

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

    /** Displays correct token image after "show token" button is clicked
     * @author Michelle Pham */
    private void eventHandle() {
        btnShowToken.setOnAction(event -> {
            tokenChoice = tokenDropDown.getValue();
            token = Token.valueOf(tokenChoice);
            tokenImageView.setImage(TokenView.createImage(token));
            playerName = textFieldInputName.getText();
            resultLabel.setText("Player " + playerName + " chose to use the " + tokenChoice);
        });
    }

    /** Helper method used to add token image space to scene
     * @author Michelle Pham */
    private void initImageView() {
        // adding token image to pane
        root.getChildren().add(btnShowToken);
        root.getChildren().add(tokenImageView);
        root.getChildren().add(resultLabel);
        root.setAlignment(Pos.TOP_CENTER);
    }

    /** Helper method used to set up token drop down menu
     * @author Michelle Pham */
    private void initTokenDropDown() {
        // drop down menu for token choices
        HBox tokenPane = new HBox(10);
        tokenPane.getChildren().add(new Label("Which token would you like to use?"));
        tokenDropDown.getItems().addAll("CANNON","CAR","DOG","HAT","HORSE","MONEYBAG","PENGUIN","PURSE","SHOE","WHEELBARROW");
        tokenDropDown.getSelectionModel();
        tokenPane.getChildren().add(tokenDropDown);
        tokenPane.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(tokenPane);
    }

    /** helper method used to set up input player information (name)
     * @author Michelle Pham*/
    private void initPlayerInput() {
        // to display all player information horizontally
        HBox playerPane = new HBox(10);
        // set root padding
        root.setPadding(new Insets(15));
        // playerPane setup
        playerPane.getChildren().add(new Label("Player name:"));
        playerPane.getChildren().add(textFieldInputName);
        root.getChildren().add(playerPane);
        playerPane.setAlignment(Pos.TOP_CENTER);
    }

} // end of TokenFX class
