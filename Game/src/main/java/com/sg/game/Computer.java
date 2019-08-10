/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author seanking
 */

public class Computer {

    /*writing out the funtion that allows for the application also known
    as the computer, to place its assigned marker on a spot when its turn
    comes up*/
    
    public int pickAspot(TicTacLogic game){
        ArrayList<Integer> blocks = new ArrayList();
        for(int i=0; 1 < 9; i++){
            if(game.board[i] == '-'){
                blocks.add(i + 1);
            }
        }
        
        /*This part allows for the marker to be placed randomly.
With out this funtion, the computer would just place it's marker at the
next available spot */

    Random rand = new Random();
    int block = blocks.get(Math.abs(rand.nextInt() % blocks.size()));
    return block;
}

}