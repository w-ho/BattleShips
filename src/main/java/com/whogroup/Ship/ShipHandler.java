package com.whogroup.Ship;

import com.whogroup.Ship.Ship;

import java.util.ArrayList;

public class ShipHandler {

    public ArrayList<Ship> shiplist = new ArrayList<Ship>();

    public int healthcounter;

    Ship carrier = new Ship("Carrier", 5);
    Ship battleship = new Ship("Battleship", 4);
    Ship submarine = new Ship("Submarine", 3);
    Ship cruzier = new Ship("Cruzier", 3);
    Ship destoryor = new Ship("Destoryor", 2);

    public ShipHandler() {
        shiplist.add(carrier);
        shiplist.add(battleship);
        shiplist.add(submarine);
        shiplist.add(cruzier);
        shiplist.add(destoryor);

        for (Ship ship : shiplist) {
            healthcounter += ship.getHits();
        }
    }

}