package com.clouza.battleships.resources;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.clouza.battleships.Configuration;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class Guess {
    private int _currentUserShips, _currentComputerShips;
    private final Scanner input = new Scanner(System.in);
    private final Cannon _cannon;

    /**
     * Guess constructor class
     * @param coordinates
     */
    public Guess(String[][] coordinates) { _cannon = new Cannon(coordinates); }

    /**
     * User turn to guess
     * @return void
     */
    public void userTurn() {
        int x, y;
        boolean isNext = false;
        System.out.printf("%s[*] %sYOUR TURN\n", Colors.GREEN, Colors.NORMAL);

        while(!isNext) {
            try {
                System.out.print("Enter X coordinate: ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate: ");
                y = input.nextInt();
            } catch (InputMismatchException err) { // integer check
                System.out.printf("%s[!] %sThe numbers must be an integer \n\n", Colors.RED, Colors.NORMAL);

                input.next(); // clear input
                continue; // continue input
            }

            // grater than 10 & negative values check
            if(x < Configuration.SIZE && y < Configuration.SIZE && x >= 0 && y >= 0) {
                _cannon.fire(x, y, Configuration.USER_SHIPS);
                System.out.print("\n\n");
                updateScore();

                isNext = true;
            } else {
                System.out.printf("%s[!] %sYou can't guess outside the %d by %d grid\n\n", Colors.RED, Colors.NORMAL, Configuration.SIZE, Configuration.SIZE);
            }
        }

    }

    /**
     * Computer turn to guess
     * @return void
     */
    public void computerTurn() {
        System.out.printf("%s[*] %sCOMPUTER'S TURN\n", Colors.GREEN, Colors.NORMAL);
        int x = new RandomNumberGenerator(Configuration.SIZE).singleNumber().get();
        int y = new RandomNumberGenerator(Configuration.SIZE).singleNumber().get();

        _cannon.fire(x, y, Configuration.COMPUTER_SHIPS);
        System.out.print("\n");

        updateScore();
    }

    /**
     * Update score for the ships
     * @return void
     */
    private void updateScore() {
        _currentUserShips = _cannon.getUserShips();
        _currentComputerShips = _cannon.getComputerShips();
    }

    /**
     * Get current score
     * @return void
     */
    public void currentScore() {
        System.out.printf("Your ships: %s | Computer ships: %s\n", _currentUserShips, _currentComputerShips);
        System.out.println(Configuration.BORDER);
    }

    /**
     * Get result of the game
     * @return boolean
     */
    public boolean end() {
        if(_currentComputerShips == 0) {
            System.out.printf("%s[*] %sHooray! You win the battle :)\n\n", Colors.GREEN, Colors.NORMAL);
            return true;
        }
        if(_currentUserShips == 0) {
            System.out.printf("%s[*] %sBetter next time! You lose the battle :(\n\n", Colors.GREEN, Colors.NORMAL);
            return true;
        }
        return false;
    }
}
