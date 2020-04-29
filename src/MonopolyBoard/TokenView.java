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

import ObjectsPackage.Token;
import javafx.scene.image.Image;

import java.io.File;

/** Method used to view proper token
 * @author Michelle Pham */
public class TokenView {

    /**
     * Helper method used to convert a URI into abstract pathname
     * @param token the referenced token whose path we need
     * @return image from the converted path
     * @author Michelle Pham
     */
    static Image createImage(Token token) {
        String path = token.getPath();
        File file = new File(path);
        Image imageFromPath = new Image(file.toURI().toString());
        return imageFromPath;
    }

}