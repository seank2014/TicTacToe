/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dao;

/**
 *
 * @author seanking
 */
public interface GameDao {
    
    public void printBoard();
    
    public void printIndexBoard();
    
    public boolean inRange(int number);
    
    public boolean isSpotTaken(int number);
    
    public boolean playTurn(int spot);
    
    public boolean isThereAWinner();
    
    public boolean rightDi();
    
    public boolean leftDi();
    
    public boolean middleRow();
    
    public boolean secondCol();
    
    public boolean topRow();
    
     public boolean firstCol();
     
     public boolean bottomRow();
     
     public boolean thirdCol();
     
     public boolean anyPlaysLeft();
     
     public String gameOver();
     
    
    
    
}
