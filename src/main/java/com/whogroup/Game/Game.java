package com.whogroup.Game;

import com.whogroup.Check.Check;
import com.whogroup.Player.PlayerHandler;
import com.whogroup.Ship.Ship;
import com.whogroup.Ship.ShipHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    Check check = new Check();
    ShipHandler shipHandler = new ShipHandler();
    PlayerHandler player = new PlayerHandler();

    private int place;
    private int place2;
    private boolean ori;
    private boolean endGame = false;

    public Game() {
    }

    public void play() {
        for (int i = 0; i < 2; i++) {
            setup();
            player.changePlayer();
        }
        runGame();
    }

    public void setup() {
        player.getPlayer().getBoard().clearAllBoard();
        for (Ship ship : shipHandler.shiplist) {
            boolean ok = true;
            do {
                try {
                    System.out.println(player.getPlayer() + "'s turn");
                    System.out.println("Please enter starting position of where you want to place your ship " + ship
                            + " which has " + ship.getHits() + " spaces");
                    System.out.println("Enter the number of row within a 10x10 matrix");
                    place = intakePosition();
                    System.out.println("Enter the number of column within a 10x10 matrix");
                    place2 = intakePosition();
                    intakeOrientation();
                    player.getPlayer().getBoard().setShip(place, place2, player, ship.getHits(), ori);
                    player.getPlayer().getBoard().displayBoards();
                    ok = true;
                } catch (InputMismatchException e) {
                    System.out.println("You enter a non valid number");
                    ok = false;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You enter a number not in index");
                    ok = false;
                }
            } while (!ok);
        }
    }

    public void runGame() {
        System.out.println("Let the battle begin");
        while (!endGame) {
            try {
                whosTurn();
                intakePosition();
                player.getPlayer().getBoard().updatefield(place, place2, player);
                player.getPlayer().getBoard().displayBoards();
                if (check.winner(shipHandler, player)) {
                    endGame = true;
                } else {
                    System.out.println("This place is not avaible");
                }
                player.changePlayer();
            } catch (InputMismatchException e) {
                endGame = true;
                System.out.println("You enter a non number, You lose!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You enter a number not in index");
                setup();
            }
        }
        winner();
        scanner.close();
    }

    private int intakePosition() {
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        } else {
            return 0;
        }
    }

    private void intakeOrientation() {
        System.out.println("Please enter 1 for vertical, 2 for horizontal, deafult horizontal");
        if (scanner.hasNextInt()){
            int how = scanner.nextInt();
            if (how == 1) {
                ori = true;
            } else
                ori = false;
        }
    }

    private void winner() {
        player.changePlayer();
        System.out.println("The winner is " + player.getPlayer());
    }

    private void whosTurn() {
        System.out.println(player.getPlayer() + "'s turn");
        System.out.println("Firing Main Cannon");
    }

}