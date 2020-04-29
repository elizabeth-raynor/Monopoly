/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 4/29/2020
 * Time: 1:20 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: ObjectsPackage
 * Class: Token
 *
 * Description: Token enums
 *
 * ****************************************
 */

package ObjectsPackage;

/**
 * Enum of possible token choices with their image location reference as its constant
 * @author Michelle Pham
 */
public enum Token {

        CANNON("src/TokenImageStore/cannon.png"), CAR("src/TokenImageStore/car.png"),
        DOG("src/TokenImageStore/dog.png"), HAT("src/TokenImageStore/hat.png"),
        HORSE("src/TokenImageStore/horse.png"), MONEYBAG("src/TokenImageStore/moneybag.png"),
        PENGUIN("src/TokenImageStore/penguin.png"), PURSE("src/TokenImageStore/purse.png"),
        SHOE("src/TokenImageStore/shoe.png"), WHEELBARROW("src/TokenImageStore/wheelbarrow.png");

        public String imagePath;

        /** constructor */
        Token(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getPath() {
            return imagePath;
        }

}
