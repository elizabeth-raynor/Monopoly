package MonopolyBoard;

import DiePackage.Die;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DieView extends VBox {

    VBox root = new VBox(10);

    /**
     * makes a root node to put in the board.
     * creates button to click to roll
     * creates two nodes for images of the die
     */
    public DieView() {
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
        Die dieRoll = new Die();

        //event Handle
        eventHandleButton(btn, rollOnce, rollTwice, firstRollImageView, secondRollImageView, dieHold, dieRoll);

    }

    /**
     * handles the situation when the button is clicked
     * @param btn
     * @param rollOnce
     * @param rollTwice
     * @param firstRollImageView
     * @param secondRollImageView
     * @param dieHold
     * @param dieRoll
     */
    private void eventHandleButton(Button btn, DieImages rollOnce, DieImages rollTwice, ImageView firstRollImageView, ImageView secondRollImageView, HBox dieHold, Die dieRoll) {
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

    /**
     * getter for root
     * @return returns the root node
     */
    public VBox getRoot() {
        return root;
    }

}
