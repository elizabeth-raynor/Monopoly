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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.io.File;


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

    /** The image of the tile */
    private String imagePath;

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
     * Constructor for corners, community chest and chance tiles with an image
     * @param sName the name of the property as a string
     */
    public BoardTiles(String sName, String imagePath, double imageSize) {
        this.sName = sName;
        formatCornerChanComm();
        addImage(imageSize, imagePath);
    }

    /**
     * Constructor for corners, community chest, and change tiles without an image
     * @param sName
     */
    public BoardTiles(String sName) {
        this.sName = sName;
        formatCornerChanComm();
    }


    /**
     * Constructor for utilities and railroads with an image
     * @param sName the name of the property as a string
     * @param iCost the cost as an integer
     */
    public BoardTiles(String sName, String imagePath, int iCost, double imageSize) {
        this.sName = sName;
        this.iCost = iCost;
        formatUtRail();
        addImage(imageSize, imagePath);
    }


    /**
     * Constructor for utilities and rails without an image
     * @param sName
     * @param iCost
     */
    public BoardTiles(String sName,  int iCost) {
        this.sName = sName;
        this.iCost = iCost;
        formatUtRail();
    }

    /**
     * Formats the properties
     */
    private void formatProperty() {
        this.setAlignment(Pos.CENTER);
        // TODO need to figure out how to fit rectangle to size of the tile
        this.getChildren().add(new Rectangle(60, 10, this.color));
        Label lName = addNameLabel();
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
        Label lName = addNameLabel();
        this.getChildren().add(lName);
        this.setBorder(border);

    }

    /**
     * Formats the utility and railroad tiles
     */
    private void formatUtRail() {
        this.setAlignment(Pos.CENTER);
        Label lName = addNameLabel();
        this.getChildren().add(lName);
        Label lCost = getCostLabel();
        this.getChildren().add(lCost);
        this.setBorder(border);
    }

    /**
     * @return Label with the name of the tile
     */
    private Label addNameLabel() {
        Label lName = new Label(sName);
        lName.setTextAlignment(TextAlignment.CENTER);
        lName.setWrapText(true);
        lName.setAlignment(Pos.CENTER);
        lName.setFont(new Font(font, 9));
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

    /**
     * Create the image to add to the board
     * @param imageSize
     */
    private void addImage(double imageSize, String imagePath) {
        File imageFile = new File(imagePath);
        Image image = new Image(imageFile.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(imageSize);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
    }
}