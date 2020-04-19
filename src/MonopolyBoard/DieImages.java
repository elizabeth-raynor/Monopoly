package MonopolyBoard;

import DiePackage.Die;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class DieImages {

    private int dieNum;
    private Image diePic;

    public Image setDiceNumToImage(int dieRolled) {

        if (dieRolled == 1) {
            Image dieOneRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice1.png");
            diePic = dieOneRolled;
        }
        if (dieRolled == 2) {
            Image dieTwoRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice2.png");
            diePic = dieTwoRolled;
        }
        if (dieRolled ==3) {
            Image dieThreeRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice3.png");
            diePic = dieThreeRolled;
        }
        if (dieRolled ==4) {
            Image dieFourRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice4.png");
            diePic = dieFourRolled;
        }
        if (dieRolled == 5) {
            Image dieFiveRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice5.png");
            diePic = dieFiveRolled;
        }
        if (dieRolled == 6) {
            Image dieSixRolled = createDiceImageView("/Users/amishachhetri/Documents/CSCI_205FinalP/csci205finalprojectsp2020/DiceImagesStore/dice6.png");
            diePic = dieSixRolled;
        }
        return diePic;
    }

    public Image createDiceImageView(String path) {
        File file = new File(path);
        Image dieImageFromPath = new Image(file.toURI().toString());
//        ImageView dieImageView = new ImageView(dieImageFromPath);
//        dieImageView.setImage(dieImageFromPath);
        return dieImageFromPath;
    }

//    public ImageView getDiePic() {
//        return diePic;
//    }
}
