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
import ObjectsPackage.Token;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Allows player's current information to be displayed along side the main board.
 * Shows name, token choice, current money and names of properties owned.
 * Currently displays an example player's information.
 * @author Michelle Pham
 */
public class PlayerView extends VBox {

    VBox root = new VBox(10);

    /** HBox for player name and current money */
    private HBox playerHBox = new HBox(10);
    /** second row formatting horizontal box */
    private HBox attributesHBox = new HBox(15);
    /** vertical box for property list */
    private VBox propertyVBox = new VBox(5);

    /**
     * Constructor that makes root node for board.
     * Calls on helper methods to add child nodes to root.
     * Contains code initializing an example player's info + properties
     * @author Michelle Pham
     */
    public PlayerView() {

        // initializing an example player's information
        Player examplePlayer = new Player("PlayerOne", Token.CANNON);
        MonopolyProperty propOne = new MonopolyProperty(1,"Mediterranean Avenue","Brown",60,50,2,10,30,90,160,250);
        MonopolyProperty propTwo = new MonopolyProperty(19,"New York Avenue","Orange",200,100,16,80,220,600,800,1000);
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

    /**
     * Displays properties information in vertical line
     * @param propertyNames String version of the player's properties names
     * @param attributesHBox the horizontal layout pane to be placed right of the token image
     * @param propertyVBox vertical layout pane used to have "properties owned" above the actual ist of names
     * @author Michelle Pham
     */
    private void initPropertiesLabels(String propertyNames, HBox attributesHBox, VBox propertyVBox) {
        Label propertyLbl = new Label("Properties Owned:");
        propertyLbl.setFont(Font.font("Kabel Heavy", FontWeight.BOLD,11));
        Label playerPropertyLbl = new Label(propertyNames);
        playerPropertyLbl.setWrapText(true);
        propertyVBox.getChildren().addAll(propertyLbl,playerPropertyLbl);
        attributesHBox.getChildren().add(propertyVBox);
        root.getChildren().add(attributesHBox);
    }

    /**
     * Adds a space for the token image to be displayed
     * @param examplePlayer the player whose token is being referenced
     * @param attributesHBox horizontal layout pane used to have property info displayed on right of image
     * @author Michelle Pham
     */
    private void initTokenImage(Player examplePlayer, HBox attributesHBox) {
        TokenView playerToken = new TokenView();
        ImageView tokenImageView = new ImageView();
        tokenImageView.setImage(TokenView.createImage(examplePlayer.getToken()));
        tokenImageView.setFitHeight(100);
        tokenImageView.setFitWidth(100);
        attributesHBox.getChildren().add(tokenImageView);
    }

    /**
     * Adds player name and current money to root node
     * @param examplePlayer Player object being referenced
     * @param playerHBox horizontal layout so name and money are on the same line
     * @author Michelle Pham
     */
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
     * @author Michelle Pham
     */
    public VBox getRoot() {
        return root;}

}