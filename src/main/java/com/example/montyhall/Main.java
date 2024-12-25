package com.example.montyhall;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberOfGames = 1000;
        int numberOfDoors = 3;

        Random random = new Random();
        Game game = new Game(numberOfDoors, random);

        Map<Integer, Result> resultsWithChange = new HashMap<>();
        Map<Integer, Result> resultsWithoutChange = new HashMap<>();
        int winsWithChange = 0;
        int winsWithoutChange = 0;


        for (int i = 0; i < numberOfGames; i++) {
            Result result = game.play(true);
            resultsWithChange.put(i, result);
            if (result.isWin()) {
                winsWithChange++;
            }
        }

        for (int i = 0; i < numberOfGames; i++) {
            Result result = game.play(false);
            resultsWithoutChange.put(i, result);
            if (result.isWin()) {
                winsWithoutChange++;
            }
        }
        System.out.println("Number of doors:" + numberOfDoors);
        System.out.println("Number of games: " + numberOfGames);
        System.out.println("Wins with change: " + winsWithChange);
        System.out.println("Wins without change: " + winsWithoutChange);
    }
}