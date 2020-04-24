/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2020
 * Instructor: Prof. Chris Dancy
 *
 * Name: Michelle Pham
 * Section: 11am
 * Date: 4/22/2020
 * Time: 9:25 AM
 *
 * Project: csci205finalprojectsp2020
 * Package: MonopolyBoard
 * Class: TokenView
 *
 * Description: Allows correct token image to be displayed
 *
 * ****************************************
 */
package MonopolyBoard;

import ObjectsPackage.MonopolyProperty;
import ObjectsPackage.Player;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerView extends VBox {

    VBox root = new VBox(10);

    /** HBox for player name and current money */
    private HBox playerHBox = new HBox(10);
    /** second row formatting horizontal box */
    private HBox attributesHBox = new HBox(15);
    /** vertical box for property list */
    private VBox propertyVBox = new VBox(5);

    /**
     * Constructor that makes root node for board
     * Update player information
     * creates one node for player token
     */
    public PlayerView() {

        // initializing an example player's information
        Player examplePlayer = new Player("PlayerOne","cannon");
        MonopolyProperty propOne = new MonopolyProperty("Mediterranean Ave.","purple",60,50, 2,10,30,90,160,250);
        MonopolyProperty propTwo = new MonopolyProperty("New York Ave.", "orange", 200, 100, 16, 80, 220, 600, 800,1000);
        examplePlayer.addProperty(propOne);
        examplePlayer.addProperty(propTwo);
        String propertyNames = "";
        for (MonopolyProperty p : examplePlayer.getProperties()) {
            propertyNames += "• " + p.getPropertyName() + "\n";
        }

        // create root
        root.setPadding(new Insets(15));

        // Add Player label to root
        initPlayerLabels(examplePlayer, playerHBox);

        initTokenImage(examplePlayer, attributesHBox);

        // adding properties to VBox
        initPropertiesLabels(propertyNames, attributesHBox, propertyVBox);
    }

    private void initPropertiesLabels(String propertyNames, HBox attributesHBox, VBox propertyVBox) {
        Label propertyLbl = new Label("Properties Owned:");
        propertyLbl.setFont(Font.font("Kabel Heavy", FontWeight.BOLD,11));
        Label playerPropertyLbl = new Label(propertyNames);
        playerPropertyLbl.setWrapText(true);
        propertyVBox.getChildren().addAll(propertyLbl,playerPropertyLbl);
        attributesHBox.getChildren().add(propertyVBox);
        root.getChildren().add(attributesHBox);
    }

    private void initTokenImage(Player examplePlayer, HBox attributesHBox) {
        TokenView playerToken = new TokenView();
        ImageView tokenImageView = new ImageView();
        tokenImageView.setImage(TokenView.setStringToTokenImage(examplePlayer.getToken()));
        tokenImageView.setFitHeight(100);
        tokenImageView.setFitWidth(100);
        attributesHBox.getChildren().add(tokenImageView);
    }

    private void initPlayerLabels(Player examplePlayer, HBox playerHBox) {
        Label nameLbl = new Label("Name: ");
        nameLbl.setFont(Font.font("Kabel Heavy", FontWeight.BOLD,11));
        Label playerNameLbl = new Label(examplePlayer.getName() + "    ");
        Label moneyLbl = new Label("Current money: ");
        moneyLbl.setFont(Font.font("Kabel Heavy",FontWeight.BOLD,11));
        Label playerMoneyLbl = new Label("$" + Integer.toString(examplePlayer.getMoney()));
        playerHBox.getChildren().addAll(nameLbl,playerNameLbl,moneyLbl,playerMoneyLbl);
        root.getChildren().add(playerHBox);
    }

    /** getter for root
     * @return root node
     */
    public VBox getRoot() {
        return root;}

}