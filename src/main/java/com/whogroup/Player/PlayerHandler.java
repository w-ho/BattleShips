package com.whogroup.Player;

import com.whogroup.Player.Player;

public class PlayerHandler {

    Player playerOne = new Player("Player One");
    Player playerTwo = new Player("Player Two");

    private Player player = playerOne;

    public Player changePlayer(){
        if (player == playerOne) {
            return player = playerTwo;
        } else {
            return player = playerOne;
        }
    }

    public Player getPlayer() {
        return player;
    }

}