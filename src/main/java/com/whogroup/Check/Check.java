package com.whogroup.Check;

import com.whogroup.Player.PlayerHandler;
import com.whogroup.Ship.ShipHandler;

public class Check {

    int hitcounter = 0;

    public boolean placeAvaible(int place, int place2, PlayerHandler player, int spaces) throws ArrayIndexOutOfBoundsException{
        if(placeNotTaken(place, place2, player, spaces)){
            return true;
        } else {
            return false;
        }
    }

    public boolean winner(ShipHandler Ships, PlayerHandler player){
        numberOfHits(player);
        if (Ships.healthcounter == hitcounter){
            return true;
        }
        hitcounter = 0;
        return false;
    }

    private void numberOfHits(PlayerHandler player) {
        for (int i = 0; i < player.getPlayer().getBoard().firingBoard.length; i++) {
            for (int j = 0; j < player.getPlayer().getBoard().firingBoard.length; j++) {
                if (player.getPlayer().getBoard().firingBoard[i][j] == "2") {
                    hitcounter++;
                }
            }
        }

    }

    private boolean placeNotTaken(int place, int place2, PlayerHandler player, int spaces) throws ArrayIndexOutOfBoundsException{
        int counter = 0;
        for (int i = 0; i < spaces; i++) {
            if (!(player.getPlayer().getBoard().playBoard[(place-1) + i][(place2-1) + i] == ("0"))) {
                counter++;
            }
        }
        if (counter == spaces) {
            return false;
        }
        return true;

    }


}