/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.ui;

import com.sg.game.dao.GameDaoImpl;
import com.sg.game.dto.Computer;

/**
 *
 * @author seanking
 */
public class GameView {

    UserIO io = new UserIOImpl();

    public void printIntroduction() {
        io.print(
                "Welcome to Tic Tac Toe. I am your fair but fierce opponent! \n"
                + "Before we start (and I win) you must chose a single character that \n"
                + "each of us will play as. That's right, we can be more than just x's and o's! ");

    }

    public char getPlayerToken() {
        char playerToken = io.readChar("Enter a single character you'd like to play as");

        while (playerToken < 'a' || playerToken > 'z') {
            playerToken = io.readChar("Ops, it looks like"
                    + " you made a mistake. Please enter"
                    + " the single character you'd like to play as");
        }

        return playerToken;
    }

    public char getComputerToken() {
        char compToken = io.readChar("Enter a single character you'd like me to play as");
        while (compToken < 'a' || compToken > 'z') {
            compToken = io.readChar("Ops, it looks like"
                    + " you made a mistake. Please enter"
                    + " the single character you'd like to play as");
        }

        return compToken;
    }

    public void newGame() {

        GameDaoImpl game = new GameDaoImpl(getPlayerToken(), getComputerToken());
        Computer computer = new Computer();

        //Set up the game
        io.print("Now that our letters have been picked, the game can began! \n"
                + " as you can see there a 9 slot on the board. Enter any number 1-9 so your letter can \n"
                + "place. May the best computer win.");
        game.printIndexBoard();

        // Play
        while (game.gameOver().equals("Game is not over")) {
            if (game.getCurrentKey() == game.getUserKey()) {
                //User turn
                int spot = io.readInt("It's your turn! Enter a spot for your token");

                while (!game.playTurn(spot)) {
                    spot = io.readInt("Try again. " + spot + " is valid. This spot is already taken"
                            + " or it is out of range");

                }
                io.print("You picked " + spot + "!");
            } else {
                // Computer's turn
                io.print("Time for the master to make a move");
                // Call it's pick a spot funtion
                int compSpot = computer.pickAspot(game);
                game.playTurn(compSpot);
                io.print("I picked " + compSpot + "!");
            }

            // Print out new board
            game.printBoard();
        }

        io.print(game.gameOver());

    }

    //Ask if user wants to play again
    public char playAgain() {

        char response = io.readChar("Do you want to play? Enter Y  for 'Yes', "
                + "or N for 'No'");
  
        return response;
    }
    
    public void quit(){
        io.print("Thanks for playing!");
        
    }
    
    public void unknownCommand(){
        io.print("Not a recognized command");
    }

}
