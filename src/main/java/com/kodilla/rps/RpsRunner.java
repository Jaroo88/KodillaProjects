package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        IOController ioController = new IOController();
        Game game = new Game(3);
        GameController gameController = new GameController(ioController, game);

        Player player = new Player(ioController.getPlayerInput());
        gameController.playGame(player);
    }
  }