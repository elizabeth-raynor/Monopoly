/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: YOUR NAME
 * Section: YOUR SECTION
 * Date: 4/14/2020
 * Time: 7:53 PM
 *
 * Project: csci205finalprojectsp2020
 * Package: MonopolyBoard
 * Class: Property
 *
 * Description:
 *
 * ****************************************
 */
package MonopolyBoard;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class PropertyFX extends VBox {

    /** The width of the node */
    private double width;

    /** The height of the node */
    private double height;

    /** The name of the property */
    private String sName;

    /** The color of the property */
    private Paint color;

    /** The price of the property */
    private int iCost;

    public PropertyFX(Paint color, String sName, int iCost, double height, double width) {
        this.color = color;
        this.sName = sName;
        this.iCost = iCost;
        this.height = height;
        this.width = width;
        formatProperty();
    }

    private void formatProperty() {
        this.getChildren().add(new Rectangle(width, height/10, color));

        // TODO- this is where the error is
        this.getChildren().add(new Label(sName));
        this.getChildren().add(new Label(Integer.toString(iCost)));
    }

}