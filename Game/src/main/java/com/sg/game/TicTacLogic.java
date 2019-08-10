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
    protected char[] board;
    protected char userKey;
    protected char compKey;
    protected char winner;
    protected char currentKey;

    //setting constructor
    public TicTacLogic(char playerToken, char compKey) {
        this.userKey = playerToken;
        this.compKey = compKey;
        this.board = setBoard();
        this.currentKey = userKey;
        this.winner = '-';

    }

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

    public static void printIndexBoard() {
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

    public char[] setBoard() {
        //setting parameters of board
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
        return board;
    }

    //Check if spot selected in on board
    public boolean inRange(int number) {
        return number > 0 && number < board.length + 1;
    }

    //Check if spot selected is available
    public boolean isSpotTaken(int number) {
        return board[number - 1] != '-';
    }

    //Check if it is users turn
    public boolean playTurn(int spot) {
        boolean isValid = inRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentKey;
            currentKey = (currentKey == userKey) ? compKey : userKey;
        }
        return isValid;
    }

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

    public boolean rightDi() {
        return board[2] == board[4] && board[4] == board[6];
    }

    public boolean leftDi() {
        return board[0] == board[4] && board[4] == board[8];
    }

    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }

    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }

    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }

    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }

    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }

    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }

    public boolean anyPlaysLeft() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public String gameOver() {
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return "The winner is " + this.winner + " 's";
        } else if (anyPlaysLeft()) {
            return "Draw: Game Over!";

        } else {
            return "Game is not over";
        }
    }

}
