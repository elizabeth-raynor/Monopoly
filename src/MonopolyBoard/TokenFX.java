package MonopolyBoard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.awt.*;

public class TokenFX extends Application {

    /** instance variable initializing HBox with spacing*/
    private HBox topPane = new HBox(10); //HBox layout arranges nodes in single row
    /** instance variable initializing token entered on screen */
    private TextField textFieldInputToken = new TextField();  // place for user input
    /** initializing new button      */
    private Button btn = new Button("Show my token!");
    /** instantiating tokenImage */
    private static Image tokenImage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // initialize root node
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        //root.getChildren().add(topPane);

        // textfield to choose image
        topPane.getChildren().add(new Label("Your token choice:"));
        topPane.getChildren().add(textFieldInputToken);
        root.getChildren().add(btn);

        /*Image testImage = new Image("TokenImages/cannon.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(testImage);
        topPane.getChildren().add(iv1);
*/
        // btn action
        btn.setOnAction(event -> {
            String tokenChoice = textFieldInputToken.getText();
            // Image display
            ImageView tokenImageView = new ImageView();
            tokenImageView.setImage(setStringToTokenImage(tokenChoice));
            root.getChildren().add(tokenImageView);
        });

        root.getChildren().add(topPane);

        //create scene & set scene
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);

        //add title
        primaryStage.setTitle("TokenFX");

        //show
        primaryStage.show();

    }

    public static Image setStringToTokenImage(String tokenName) {
        switch (tokenName) {
            case "cannon":
                tokenImage = new Image("src/TokenImageStorage/cannon.png");
            case "dog":
                tokenImage = new Image("src/TokenImageStorage/dog.png");
                break;
            case "hat":
                tokenImage = new Image("src/TokenImageStorage/hat.png");
                break;
            case "horse":
                tokenImage = new Image("src/TokenImageStorage/horse.png");
                break;
            case "money":
                tokenImage = new Image("src/TokenImageStorage/money.png");
                break;
            case "penguin":
                tokenImage = new Image("src/TokenImageStorage/penguin.png");
                break;
            case "purse":
                tokenImage = new Image("src/TokenImageStorage/purse.png");
                break;
            case "shoe":
                tokenImage  = new Image("src/TokenImageStorage/shoe.png");
                break;
            case "wheelbarrow":
                tokenImage  = new Image("src/TokenImageStorage/wheelbarrow.png");
                break;
        }

        return tokenImage;
    }
}
