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

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class BoardTiles extends VBox {

//    /** The width of the node */
//    private double width;
//
//    /** The height of the node */
//    private double height;

    /** The name of the property */
    private String sName;

    /** The color of the property */
    private Paint color;

    /** The price of the property */
    private int iCost;

    /** The border of the property */
    private Border border = new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, null));

    /**
     * Constructor for properties
     * @param color
     * @param sName
     * @param iCost
//     * @param height
//     * @param width
     */
//    public BoardTiles(Paint color, String sName, int iCost, double height, double width) {
//        this.color = color;
//        this.sName = sName;
//        this.iCost = iCost;
//        this.height = height;
//        this.width = width;
//        formatProperty();
//    }

    public BoardTiles(Paint color, String sName, int iCost) {
        this.color = color;
        this.sName = sName;
        this.iCost = iCost;
        formatProperty();
    }

    /**
     * Constructor for corners, community chest and chance tiles
     * @param sName
//     * @param size
     */
//    public BoardTiles(String sName, double size) {
//        this.height = size;
//        this.width = size;
//        this.sName = sName;
//        formatCorners();
//    }
    public BoardTiles(String sName) {
        this.sName = sName;
        formatCornerChanComm();
    }

    /**
     * Constructor for chance and community chest tiles
     * @param sName
//     * @param height
//     * @param width
     */
//    public BoardTiles(String sName, double height, double width) {
//        this.sName = sName;
//        this.height = height;
//        this.width = width;
//        formatChanComm();
//    }

//    public BoardTiles(String sName) {
//        this.sName = sName;
//        formatChanComm();
//    }

    /**
     * Constructor for utilities and railroads
     * @param sName
     * @param iCost
     */
//    public BoardTiles(String sName, int iCost, double height, double width) {
//        this.sName = sName;
//        this.iCost = iCost;
//        this.height = height;
//        this.width = width;
//        formatUtRail();
//    }

    public BoardTiles(String sName, int iCost) {
        this.sName = sName;
        this.iCost = iCost;
        formatUtRail();
    }

    private void formatProperty() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(this.getHeight()/3);
//        this.setPrefWidth(this.width);
//        this.setPrefHeight(this.height);
        this.getChildren().add(new Rectangle(50, 88/11, this.color));
        Label lName = getLabel();
        this.getChildren().add(lName);
        this.getChildren().add(new Label(Integer.toString(iCost)));
        this.setBorder(border);
    }

    private void formatCornerChanComm() {
        this.setAlignment(Pos.CENTER);
//        this.setPrefSize(this.height,this.height);
        Label lName = getLabel();
        this.getChildren().add(lName);
        this.setBorder(border);
    }

//    private void formatChanComm() {
//        this.setAlignment(Pos.CENTER);
//        this.setPrefWidth(this.width);
//        this.setPrefHeight(this.height);
//        Label lName = getLabel();
//        this.getChildren().add(lName);
//        this.setBorder(border);
//    }

    private void formatUtRail() {
        this.setAlignment(Pos.CENTER);
//        this.setPrefWidth(this.width);
//        this.setPrefHeight(this.height);
        Label lName = getLabel();
        this.getChildren().add(lName);
        this.getChildren().add(new Label(Integer.toString(iCost)));
        this.setBorder(border);
    }

    /**
     * @return Label with the name of the tile
     */
    private Label getLabel() {
        Label lName = new Label(sName);
        lName.setWrapText(true);
        lName.setAlignment(Pos.CENTER);
        return lName;
    }

    public String getsName() {
        return sName;
    }

    public Paint getColor() {
        return color;
    }

    public int getiCost() {
        return iCost;
    }
}