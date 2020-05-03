package MonopolyBoard;

import ObjectsPackage.DieModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author amishachhetri
 */
public class DieRoll extends VBox {

    VBox root = new VBox(10);

    /**
     * makes a root node to put in the board.
     * creates button to click to roll
     * creates two nodes for images of the die
     */
    public DieRoll() {
        //Create root
        root.setPadding(new Insets(15));

        //add button to root
        Button btn = new Button("Click to roll");
        root.getChildren().add(btn);

        //get Images from DieImages
        DieImages rollOnce = new DieImages();
        DieImages rollTwice = new DieImages();
        ImageView firstRollImageView = new ImageView();
        ImageView secondRollImageView = new ImageView();

        //add dies to HBox
        HBox dieHold = new HBox(10);
        dieHold.getChildren().add(firstRollImageView);
        dieHold.getChildren().add(secondRollImageView);
        root.getChildren().add(dieHold);

        //roll Die
        DieModel dieRoll = new DieModel();

        //event Handle
        btn.setOnAction(event -> {
            dieRoll.roll();
            dieRoll.rollTwo();
            int dieRolledNumOne = dieRoll.getDiceRollNum();
            int dieRolledNumTwo = dieRoll.getDiceRollNumTwo();

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

    /**
     * getter for root
     * @return returns the root node
     */
    public VBox getRoot() {
        return root;
    }

}
