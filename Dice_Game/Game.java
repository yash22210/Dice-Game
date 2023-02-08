package Dice_Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A Dice Game GUI
 *
 * @author Yash Patel , july 05 2021
 */

public class Game extends Application {

    private Dice dice;
    private Player player;

        //   1.Define the model
        private Label playerName;
        private Label computerName;
        private TextField playerNameTextField;
        private TextField compNameTextField;
        private Button playerDice;
        private Button computerDice;
        private Button RollDice;
        private Label playerDiceNum;
        private Label computerDiceNum;
        private Label playerDiceLabel;
        private Label computerDiceLabel;
        private Label outputLabel;
        private int userDice;
        private int compDice;
        private Button Reset;
        private Label rolls;


    /**
     * This is where you create your components and the model and add event
     * handlers.
     */

        public void spinHandler (ActionEvent e) {

            if (dice.getRolls() < dice.getMax_ROLLS()) {
                userDice = dice.roll(userDice);
                compDice = dice.roll(compDice);
                playerDiceNum.setText(String.valueOf(userDice));
                computerDiceNum.setText(String.valueOf(compDice));

                player.setUserName(playerNameTextField.getText());
                player.setComputerName(compNameTextField.getText());

                String win = "-fx-background-color:Green";
                String loss = "-fx-background-color:Red";


                if (userDice > compDice) {
                    playerDice.setStyle(win);
                    computerDice.setStyle(loss);
                    outputLabel.setText(player.getUserName() + " Wins!");
                } else if (userDice < compDice) {
                    computerDice.setStyle(win);
                    playerDice.setStyle(loss);
                    outputLabel.setText(player.getComputerName() + "  Wins!");
                } else {
                    computerDice.setStyle(win);
                    playerDice.setStyle(win);
                    outputLabel.setText("Match is tied!");
                }

                rolls.setText("Rolls available: " + dice.rollsAvailable() );

            }
            else if (dice.getRolls() <= dice.getMax_ROLLS())
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR,"No more Rolls, Please Reset");
                    alert.setTitle("No more rolls");
                    alert.showAndWait();
                    dice.reset();
                }

            }
            public void resetHandler(ActionEvent e)
            {
                userDice = 0;
                compDice = 0;
                playerDiceNum.setText(String.valueOf(userDice));
                computerDiceNum.setText(String.valueOf(compDice));
                dice.reset(); // reset the number of rolls
                rolls.setText("Rolls available: " + dice.rollsAvailable() );
                outputLabel.setText("Result");
                playerDice.setStyle("-fx-background-color:Blue");
            }


        /**
         *
         * @param stage The main stage
         * @throws Exception
         */
        @Override
        public void start(Stage stage) throws Exception {
            Pane root = new Pane();
            Scene scene = new Scene(root, 300, 410); // set the size here
            stage.setTitle("Dice Game"); // set the window title here
            stage.setScene(scene);
            // TODO: Add your GUI-building code here

            // 1. Create the model

           dice = new Dice(10);
           player = new Player("player1","Bot"); // Default name for player and Computer



            // 2. Create the GUI components

            playerName = new Label("Player Name");
            playerNameTextField = new TextField(player.getUserName());
            computerName = new Label("Computer Name");
            compNameTextField = new TextField(player.getComputerName());

            playerDice = new Button();
            playerDiceNum = new Label("0");
            playerDiceLabel = new Label("Player Dice");

            computerDice = new Button();
            computerDiceNum = new Label("0");
            computerDiceLabel = new Label("Computer Dice");

            RollDice = new Button("Roll");
            outputLabel = new Label("Result");
            Reset = new Button("Reset");
            rolls = new Label("Rolls available: " + dice.rollsAvailable());







            // 3. Add components to the root
            root.getChildren().addAll(playerName,playerNameTextField,computerName,compNameTextField,
                                    playerDice, computerDice, RollDice, playerDiceNum, computerDiceNum
                                    ,playerDiceLabel,computerDiceLabel,outputLabel ,Reset,rolls);

            // 4. Configure the components (colors, fonts, size, location)
            String css = ("-fx-text-fill:white;");


            playerName.relocate(20, 25);
            playerNameTextField.relocate(120, 20);
            computerName.relocate(20, 65);
            compNameTextField.relocate(120, 60);
            playerName.setStyle(css);
            computerName.setStyle(css);

            //dice button location
            playerDice.relocate(50,150);
            playerDiceLabel.relocate(50,120);
            playerDice.setPrefWidth(60);
            playerDice.setPrefHeight(60);
            playerDiceNum.relocate(66,157);
            playerDiceNum.setStyle("-fx-font-size:24pt;-fx-text-fill:yellow;");
            playerDice.setStyle("-fx-background-color:Blue");
            playerDiceLabel.setStyle(css);

            computerDice.relocate(170,150);
            computerDiceLabel.relocate(170,120);
            computerDice.setPrefWidth(60);
            computerDice.setPrefHeight(60);
            computerDiceNum.relocate(186,157);
            computerDiceNum.setStyle("-fx-font-size:24pt;-fx-text-fill:yellow;");
            computerDice.setStyle("-fx-background-color:red");
            root.setStyle("-fx-background-color:black;");
            computerDiceLabel.setStyle(css);


            RollDice.relocate(120,240);
            Reset.relocate(220,240);
            Reset.setStyle("-fx-background-color:Grey;-fx-text-fill:white;");
            rolls.relocate(0,370);
            rolls.setPrefWidth(120);
            rolls.setStyle(css);

            outputLabel.relocate(20,280);
            outputLabel.setPrefWidth(260);
            outputLabel.setPrefHeight(30);
            outputLabel.setStyle("-fx-background-color:beige;-fx-text-fill:black;-fx-font-size:24pt;-fx-padding:20px;");





            // 5. Add Event Handlers and do final setup
            RollDice.setOnAction(this::spinHandler);
            Reset.setOnAction(this::resetHandler);

            // 6. Show the stage
            stage.show();
        }


    /**
         * Make no changes here.
         *
         * @param args unused
         */
        public static void main(String[] args) {
            launch(args);
        }

    }
