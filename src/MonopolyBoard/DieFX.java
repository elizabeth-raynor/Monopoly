package MonopolyBoard;

import DiePackage.Die;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class DieFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //create root node
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        //add button to root
        Button btn = new Button("Click to roll");
        root.getChildren().add(btn);

        DieImages rollOnce = new DieImages();
        DieImages rollTwice = new DieImages();
        ImageView firstRollImageView = new ImageView();
        ImageView secondRollImageView = new ImageView();
        //add dies in HBox
        HBox dieHold = new HBox(10);
        dieHold.getChildren().add(firstRollImageView);
        dieHold.getChildren().add(secondRollImageView);
        root.getChildren().add(dieHold);

        Die dieRoll = new Die();
        dieEventHandleButton(btn, rollOnce, rollTwice, firstRollImageView, secondRollImageView, dieHold, dieRoll);

        //create scene & set scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);

        //add title
        primaryStage.setTitle("DieFX");

        //show
        primaryStage.show();

    }

    private void dieEventHandleButton(Button btn, DieImages rollOnce, DieImages rollTwice, ImageView firstRollImageView, ImageView secondRollImageView, HBox dieHold, Die dieRoll) {
        //event Handle
        btn.setOnAction(event -> {
            int dieRolledNumOne = dieRoll.roll();
            int dieRolledNumTwo = dieRoll.rollTwo();

            Image firstDieView = rollOnce.setDiceNumToImage(dieRolledNumOne);
            //ImageView firstDieView = rollOnce.getDiePic();

            Image secondDieView = rollTwice.setDiceNumToImage(dieRolledNumTwo);
            //ImageView secondDieView = rollTwice.getDiePic();
            firstRollImageView.setImage(firstDieView);
            secondRollImageView.setImage(secondDieView);
            dieHold.getChildren().set(0, firstRollImageView);
            dieHold.getChildren().set(1, secondRollImageView);

        });
    }

}
