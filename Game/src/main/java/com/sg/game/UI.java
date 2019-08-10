/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class UI {

    //Getting input
    Scanner scan = new Scanner(System.in);
    //Allows for continuous rounds of game

    public void playGame() {

        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {

            System.out.println(
                    "Welcome to Tic Tac Toe. I am your fair but fierce opponent! \n"
                    + "Before we start (and I win) you must chose a single character that \n"
                    + "each of us will play as. That's right, we can be more than just x's and o's! ");

            System.out.println();
            System.out.println("Enter a single character you'd like to play as");
            char playerToken = scan.nextLine().charAt(0);
            System.out.println("Enter a single character you'd like me to play as");
            char compToken = scan.nextLine().charAt(0);

            TicTacLogic game = new TicTacLogic(playerToken, compToken);
            Computer computer = new Computer();

            //Set up the game
            System.out.println();
            System.out.println("Now that our letters have been picked, the game can began! \n"
                    + " as you can see there a 9 slot on the board. Enter any number 1-9 so your letter can \n"
                    + "place. May the best computer win.");
            TicTacLogic.printIndexBoard();
            System.out.println();

            // Play
            while (game.gameOver().equals("Game is not over")) {
                if (game.currentKey == game.userKey) {
                    //User turn
                    System.out.println("It's your turn! Enter a spot for your token");
                    int spot = scan.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + " is valid. This spot is already taken"
                                + " or it is out of range");
                        spot = scan.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                } else {
                    // Computer's turn
                    System.out.println("Time for the master to make a move");
                    // Call it's pick a spot funtion
                    int compSpot = computer.pickAspot(game);
                    game.playTurn(compSpot);
                    System.out.println("I picked " + compSpot + "!");
                }

                // Print out new board
                System.out.println();
                game.printBoard();
            }

            System.out.println(game.gameOver());
            System.out.println();
            //Ask if user wants to play again
            System.out.println("Do you want to play again? Enter Y  for 'Yes'. "
                    + "If not, press any key you'd like");
            char response = scan.next().charAt(0);
            if (response == 'y' || response == 'Y') {
                scan.nextLine();
                doYouWantToPlay = true;
            } else {
                System.out.println("Thanks for playing!");
                doYouWantToPlay = false;
            }

        }

    }

}
