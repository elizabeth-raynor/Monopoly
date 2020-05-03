## Team Name: 
MAZE
## Team Members: 
Amisha Chhertri, Zeke Farkas, Michelle Pham, Elizabeth Raynor
## Project Owner: 
Amisha Chhertri
## Scrum Master: 
Zeke Farkas

### Project summary:

For our project we decided to try and recreate the game of monopoly, on the computer. We wanted the game to be playable for 2 - 4 people. And they should all be able to sit around one computer and play it together. Other than that, there should be a nice GUI with an actual board you can see. And places to click on on the board. We have the dice displayed and it shows your new roll every time you click the roll dice button. We also wanted a console based version of the game, in case people are more inclined to play it that way.
To create this project we went with the object oriented design approach of making good classes for each object we wanted to have and exist on our virtual board. This meant creating things like a player class, and a property class. And as we got further into the project we realized we needed more advanced classes such as jail and token classes.

### Explanation of package structure:

We have five main packages in our project. Three of them are just to store images, so we have two main packages with code in them. We split them into one package for more underlying components of the game, and the other main package for the board. 
So the first package -- named ObjectsPackage -- contains our classes for players, properties, railroads, utilities, die, jail, and tokens. It also contains the console version of our game, which serves as the basis to integrate the game with the board. The main file in this package is the ConsoleGame class, which is where to run our game.
The second package -- named MonopolyBoard -- contains all of the files and classes to create our virtual board. This package relies on the use of the JavaFX library, and creates GUI’s for use in playing the game graphically. Our main file in this package is the BoardMain class, when run it creates a monopoly board almost identical to the real life version of the game.
The other three packages are called BoardImages, DiceImagesStore, and TokenImagesStore. They all contain PNG images that are used to make the board, and our game, look more like the real thing. BoardImages contain pictures used for the board, things like chance and jail. DiceImagesStore contains pictures for each side of a die, so that we can visually display the roll of a player on the board. Lastly, the TokenImageStore contains images for each of the 10 possible tokens players can choose to be, so that they may be displayed on the board.

### Third party libraries used in the project:

In this project we used the JavaFX library.

### Build and run instructions:

The main file to be run is called BoardMain, and it is in the MonopolyBoard package. The project should build and compile normally.

Type the following to run the jar file in the command line:
Java --module-path <path-to>/javafx-sdk-14/lib --add-modules=javafx.controls -jar <path-to>csci205finalprojectSP2020.jar
