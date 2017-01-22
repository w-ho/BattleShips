package com.whogroup.Game;

import com.whogroup.Player.PlayerHandler;

public class Board {

    private int length = 10;
    public String[][] playBoard = new String[length][length];
    public String[][] firingBoard = new String[length][length];

    public void clearAllBoard() {
        clear(playBoard);
        clear(firingBoard);
    }

    public void displayBoards() {
        System.out.println("My Ships");
        display(playBoard);
        System.out.println("Position Fired");
        display(firingBoard);
    }

    public void setShip(int place, int place2, PlayerHandler player, int hits, boolean ori) {
        if (ori == true) {
            for (int i = 0; i < hits; i++) {
                if (i == 0) {
                    playBoard[place - 1][place2 - 1 + i] = "<";
                } else if (i == hits - 1) {
                    playBoard[place - 1][place2 - 1 + i] = ">";
                } else {
                    playBoard[place - 1][place2 - 1 + i] = "=";
                }
            }
        } else if (ori == false) {
            for (int i = 0; i < hits; i++) {
                if (i == 0) {
                    playBoard[place - 1 + i][place2 - 1] = "^";
                } else if (i == hits - 1) {
                    playBoard[place - 1 + i][place2 - 1] = "v";
                } else {
                    playBoard[place - 1 + i][place2 - 1] = "\"";
                }
            }
        }
    }

    public void updatefield(int place, int place2, PlayerHandler player) {
        String fired = firingBoard[place - 1][place2 - 1];
        String ship = player.changePlayer().getBoard().playBoard[place - 1][place2 - 1];

        if (ship == "0") {
            player.changePlayer();
            firingBoard[place - 1][place2 - 1] = "1";
        } else if (ship == "2") {
            System.out.println("You have already fired at this position");
        } else {
            player.changePlayer();
            firingBoard[place - 1][place2 - 1] = "2";
        }
    }

    private void display(String[][] arrayToPassIn) {
        for (int i = 0; i < arrayToPassIn.length; i++) {
            String checker = "|";
            for (int j = 0; j < arrayToPassIn.length; j++) {
                checker += " " + printLayout(arrayToPassIn[i][j]) + " |";
            }
            System.out.println(checker);
        }
    }

    private void clear(String[][] arrayToPassIn) {
        for (int i = 0; i < arrayToPassIn.length; i++) {
            for (int j = 0; j < arrayToPassIn.length; j++) {
                arrayToPassIn[i][j] = "0";
            }
        }
    }


    private String printLayout(String water) {
        if (water == "1") {
            return "O";
        } else if (water == "2") {
            return "X";
        } else if (water == "0") {
            return "~";
        } else {
            return water;
        }
    }
}