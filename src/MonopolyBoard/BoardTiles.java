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
 * Class: ObjectsPackage.Property
 *
 * Description:
 *
 * ****************************************
 */
package MonopolyBoard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class BoardTiles extends VBox {

    /** The name of the property */
    private String sName;

    /** The color of the property */
    private Paint color;

    /** The price of the property */
    private int iCost;

    /** The border of the property */
    private Border border = new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null));

    /** The monopoly font */
    private String font = "Kabel Heavy";


    /**
     * Constructor for properties
     * @param color the color of the property as a Paint object
     * @param sName the name of the property as a string
     * @param iCost the cost as an integer
     */
    public BoardTiles(Paint color, String sName, int iCost) {
        this.color = color;
        this.sName = sName;
        this.iCost = iCost;
        formatProperty();
    }

    /**
     * Constructor for corners, community chest and chance tiles
     * @param sName the name of the property as a string
     */
    public BoardTiles(String sName) {
        this.sName = sName;
        formatCornerChanComm();
    }

    /**
     * Constructor for utilities and railroads
     * @param sName the name of the property as a string
     * @param iCost the cost as an integer
     */
    public BoardTiles(String sName, int iCost) {
        this.sName = sName;
        this.iCost = iCost;
        formatUtRail();
    }

    /**
     * Formats the properties
     */
    private void formatProperty() {
        this.setAlignment(Pos.CENTER);
//        this.setSpacing(this.getHeight()/3); ****These don't work, this.getHeight returns 0, not sure how to get height of the node
//        System.out.println();
//        System.out.println(this.getWidth());
        // TODO need to figure out how to fit rectangle to size of the tile
        this.getChildren().add(new Rectangle(55, 15, this.color));
        Label lName = getNameLabel();
        this.getChildren().add(lName);
        Label lCost = getCostLabel();
        this.getChildren().add(lCost);
        this.setBorder(border);
    }

    /**
     * Formats the corners, community chest tiles, and the chance tiles
     */
    private void formatCornerChanComm() {
        this.setAlignment(Pos.CENTER);
//        this.setPrefSize(this.height,this.height);
        Label lName = getNameLabel();
        this.getChildren().add(lName);
        this.setBorder(border);
    }

    /**
     * Formats the utility and railroad tiles
     */
    private void formatUtRail() {
        this.setAlignment(Pos.CENTER);
        Label lName = getNameLabel();
        this.getChildren().add(lName);
        Label lCost = getCostLabel();
        this.getChildren().add(lCost);
        this.setBorder(border);
    }

    /**
     * @return Label with the name of the tile
     */
    private Label getNameLabel() {
        Label lName = new Label(sName);
        lName.setTextAlignment(TextAlignment.CENTER);
        lName.setWrapText(true);
        lName.setAlignment(Pos.CENTER);
        lName.setFont(new Font(font, 11));
        lName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return lName;
    }

    /**
     * @return Label with the cost of the property
     */
    private Label getCostLabel() {
        Label lCost = new Label(Integer.toString(iCost));
        lCost.setFont(new Font(font, 11));
        return lCost;
    }
}