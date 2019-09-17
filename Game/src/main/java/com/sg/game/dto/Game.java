/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dto;

/**
 *
 * @author seanking
 */
public class Game {
     //fields
    public char[] board;
    protected char userKey;
    protected char compKey;
    protected char winner;
    protected char currentKey;

    //setting constructor
    public Game(char playerToken, char compKey) {
        this.userKey = playerToken;
        this.compKey = compKey;
        this.board = setBoard();
        this.currentKey = userKey;
        this.winner = '-';

    }
    
    public char[] setBoard() {
        //setting parameters of board
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
        return board;
    }
    
     public char[] getBoard() {
        return board;
    }


    public char getUserKey() {
        return userKey;
    }

    public void setUserKey(char userKey) {
        this.userKey = userKey;
    }

    public char getCompKey() {
        return compKey;
    }

    public void setCompKey(char compKey) {
        this.compKey = compKey;
    }

    public char getWinner() {
        return winner;
    }

    public void setWinner(char winner) {
        this.winner = winner;
    }

    public char getCurrentKey() {
        return currentKey;
    }

    public void setCurrentKey(char currentKey) {
        this.currentKey = currentKey;
    }   
    
}
