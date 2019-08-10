/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game;

/**
 *
 * @author seanking
 */
public class TicTacLogic {
    
    //fields
    protected char [] board;
    protected char userKey;
    protected char compKey;
    protected char winner;
    protected char currentKey;
    
    //setting constructor
    
    
   public TicTacLogic(char playerToken, char compKey){
       this.userKey = playerToken;
       this.compKey = compKey;
       this.board = setBoard();
       this.currentKey = userKey;
       this.winner = ' ';
       
   }
   
   public void printBoard(){
       //Creating
       //   | - | - | -
       //   -------------
      //    | - | - | -
       //   -------------
       //   | - | - | -
       //   -------------
       
       System.out.println();
       for(int i = 0; i < board.length; i++){
           //divides the board into section of three
           if(i % 3 == 0 && i != 0){
               System.out.println();
               System.out.println("-------------");
           }
           //will print divided and following "block"
           System.out.println(" | " + board[i]);
       }
       System.out.println();
   }
    
}
