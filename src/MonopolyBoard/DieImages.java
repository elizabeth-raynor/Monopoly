package MonopolyBoard;

import javafx.scene.image.Image;

import java.io.File;

/**
 * @author amishachhetri
 */
public class DieImages {

    private Image diePic;

    /**
     * sets the number rolled to an image inside the DiceImagesStore folder
     * calls createDiceImageView
     * @param dieRolled
     * @return the image
     */
    public Image setDiceNumToImage(int dieRolled) {

        //get image from path and set picture to die
        if (dieRolled == 1) {
            Image dieOneRolled = createDiceImageView("src/DiceImagesStore/dice1.png");
            diePic = dieOneRolled;
        }
        if (dieRolled == 2) {
            Image dieTwoRolled = createDiceImageView("src/DiceImagesStore/dice2.png");
            diePic = dieTwoRolled;
        }
        if (dieRolled ==3) {
            Image dieThreeRolled = createDiceImageView("src/DiceImagesStore/dice3.png");
            diePic = dieThreeRolled;
        }
        if (dieRolled ==4) {
            Image dieFourRolled = createDiceImageView("src/DiceImagesStore/dice4.png");
            diePic = dieFourRolled;
        }
        if (dieRolled == 5) {
            Image dieFiveRolled = createDiceImageView("src/DiceImagesStore/dice5.png");
            diePic = dieFiveRolled;
        }
        if (dieRolled == 6) {
            Image dieSixRolled = createDiceImageView("src/DiceImagesStore/dice6.png");
            diePic = dieSixRolled;
        }
        return diePic;
    }

    /**
     * uses the path to get to the image
     * @param path
     * @return the die image for that path
     */
    public Image createDiceImageView(String path) {
        File file = new File(path);
        Image dieImageFromPath = new Image(file.toURI().toString());
        return dieImageFromPath;
    }

}
