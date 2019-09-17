/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.game.dao;



public class GameDaoImpl implements GameDao {
         //fields
    public char[] board;
    protected char userKey;
    protected char compKey;
    protected char winner;
    protected char currentKey;

    //setting constructor
    public GameDaoImpl(char playerToken, char compKey) {
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

    
    @Override
    public void printBoard() {
        //Creating
        //   | - | - | -
        //   -------------
        //    | - | - | -
        //   -------------
        //   | - | - | -
        //   -------------

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            //divides the board into section of three
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("-------------");
            }
            //will print divided and following "block"
            System.out.print(" | " + board[i]);
        }
        System.out.println();

    }

    @Override
    public void printIndexBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }

    @Override
    public boolean inRange(int number) {
        return number > 0 && number < board.length + 1;
    }

    @Override
    //Check if spot selected is available
    public boolean isSpotTaken(int number) {
        return board[number - 1] != '-';
    }

    @Override
//Check if it is users turn
    public boolean playTurn(int spot) {
        boolean isValid = inRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentKey;
            currentKey = (currentKey == userKey) ? compKey : userKey;
        }
        return isValid;
    }

    @Override

    public boolean isThereAWinner() {
        boolean diagonalAndMiddleCol = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        //   | - | - | -
        //   -------------
        //    | - | x | -
        //   -------------
        //   | - | - | -
        //   -------------

        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
        //  | x | - | -
        //   -------------
        //    | - | - | -
        //   -------------
        //   | - | - | -
        //   -------------

        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';
        //   | - | - | -
        //   -------------
        //    | - | - | -
        //   -------------
        //   | - | - | x
        //   -------------

        if (diagonalAndMiddleCol) {
            System.out.println("Won diagonally/Middle");
            this.winner = board[4];
        } else if (topAndFirst) {
            System.out.println("Won from the top/first column");
            this.winner = board[0];
        } else if (bottomAndThird) {
            System.out.println("Won from the last row/column");
            this.winner = board[8];
        }
        return diagonalAndMiddleCol || topAndFirst || bottomAndThird;
    }

    @Override
    public boolean rightDi() {
        return board[2] == board[4] && board[4] == board[6];
    }

    @Override
    public boolean leftDi() {
        return board[0] == board[4] && board[4] == board[8];
    }

    @Override
    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }

    @Override
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }

    @Override
    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }

    @Override
    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }

    @Override
    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }

    @Override
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }

    @Override
    public boolean anyPlaysLeft() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                return true;
            }
        }
        return false;
    }

    @Override
    public String gameOver() {

        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return "The winner is " + this.winner + " 's";
        } else if (!anyPlaysLeft()) {
            return "Draw: Game Over!";
        } else {
            return "Game is not over";
        }
    }

}
