/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.controller;

import com.sg.game.ui.GameView;

/**
 *
 * @author seanking
 */
public class gameController {

    GameView view = new GameView();

    public void playGame() {

        boolean doYouWantToPlay = true;
        char menuSelection;
        
        while (doYouWantToPlay) {
            
           menuSelection = getMenuSelection();

            switch (menuSelection) {

                
                case 'Y':
                    view.printIntroduction();
                    view.newGame();
                    getMenuSelection();
                    break;
                case 'N':
                    doYouWantToPlay = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exit();
    }

    private char getMenuSelection() {
        return view.playAgain();
    }

    private void unknownCommand() {
        view.unknownCommand();
    }

    private void exit() {
        view.quit();
    }
}
