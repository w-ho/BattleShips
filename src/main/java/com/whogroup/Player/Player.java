package com.whogroup.Player;

import com.whogroup.Game.Board;

public class Player {

    private Board board = new Board();
    private String name;

    public Player(String name){
        this.name = name;
    }

    public Board getBoard(){
        return board;
    }

    @Override
    public String toString() {
        return  name;
    }

}
