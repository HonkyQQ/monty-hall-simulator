package com.example.montyhall;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Random;

@Data
@AllArgsConstructor
public class Game {
    private int numberOfDoors;
    private Random random;

    public Result play(boolean shouldChange) {
        int winningDoor = random.nextInt(numberOfDoors);
        int playerChoice = random.nextInt(numberOfDoors);

        int revealedDoor;
        do {
            revealedDoor = random.nextInt(numberOfDoors);
        } while (revealedDoor == winningDoor || revealedDoor == playerChoice);


        int finalChoice = playerChoice;
        if (shouldChange) {
            for (int i = 0; i < numberOfDoors; i++) {
                if (i != playerChoice && i != revealedDoor){
                    finalChoice = i;
                    break;
                }
            }
        }

        boolean isWin = finalChoice == winningDoor;
        return new Result(isWin);
    }
}