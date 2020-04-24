/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 4/22/2020
 * Time: 9:42 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: MonopolyBoard
 * Class: TokenImages
 *
 * Description:
 *
 * ****************************************
 */
package MonopolyBoard;

import javafx.scene.image.Image;

import java.io.File;

public class TokenView {

    private static Image tokenImage;

    /** sets the string token name to an image inside TokenImages folder
     * @param tokenName String representing user's choice (in dropdown menu)
     * @return actual image of token
     */
    static Image setStringToTokenImage(String tokenName) {
        switch (tokenName) {
            case "cannon":
                tokenImage = createImage("src/TokenImageStore/cannon.png");
                break;
            case "car":
                tokenImage = createImage("src/TokenImageStore/car.png");
                break;
            case "dog":
                tokenImage = createImage("src/TokenImageStore/dog.png");
                break;
            case "hat":
                tokenImage = createImage("src/TokenImageStore/hat.png");
                break;
            case "horse":
                tokenImage = createImage("src/TokenImageStore/horse.png");
                break;
            case "moneybag":
                tokenImage = createImage("src/TokenImageStore/moneybag.png");
                break;
            case "penguin":
                tokenImage = createImage("src/TokenImageStore/penguin.png");
                break;
            case "purse":
                tokenImage = createImage("src/TokenImageStore/purse.png");
                break;
            case "shoe":
                tokenImage  = createImage("src/TokenImageStore/shoe.png");
                break;
            case "wheelbarrow":
                tokenImage  = createImage("src/TokenImageStore/wheelbarrow.png");
                break;
        }
        return tokenImage;
    }

    /**
     * Helper method used to convert a URI into abstract pathname
     * @param path abstract pathname
     * @return image from the converted path
     */
    private static Image createImage(String path) {
        File file = new File(path);
        Image imageFromPath = new Image(file.toURI().toString());
        return imageFromPath;
    }

}