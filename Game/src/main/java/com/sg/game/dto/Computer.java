/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dto;

import com.sg.game.dao.GameDaoImpl;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author seanking
 */
public class Computer {
    
    //need to instatiate logic
         /*writing out the function that allows for the application also known
    as the "computer", to place its assigned rep on a spot when its turn
    comes up*/
    public int pickAspot(GameDaoImpl game) {
        ArrayList<Integer> blocks = new ArrayList();
        for (int i = 0; i < 9; i++) {
            if (game.board[i] == '-') {
                blocks.add(i + 1);
            }
        }
        
        /*This part allows for the rep to be placed randomly.
With out this function, the computer would just place it's marker at the
next available spot */

        Random rand = new Random();
        int block = blocks.get(Math.abs(rand.nextInt() % blocks.size()));
        return block;
    }
    
}
