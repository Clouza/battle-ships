package com.clouza.battleships.resources;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import com.clouza.battleships.Configuration;

/**
 * @author Clouza (Siwa)
 * @link https://github.com/clouza
 * @version 1.0.0
 */
public class Ships {
    private ArrayList<Integer> _temporaryCoordinate = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    RandomNumberGenerator RNG = new RandomNumberGenerator(Configuration.SIZE);

    /**
     * User Ship Deploy
     * @param symbol String
     * @param coordinates String[][] Array 2D
     * @return boolean
     */
    public boolean userShips(String symbol, String[][] coordinates) {
        int x, y, _limit = 1;

        while(_limit <= Configuration.SIZE - 5) {
            try {
                System.out.printf("Enter X coordinate for your ship[%d]. ship: ", _limit);
                x = input.nextInt();

                System.out.printf("Enter Y coordinate for your ship[%d]. ship: ", _limit);
                y = input.nextInt();
            } catch (InputMismatchException err) {
                System.out.printf("%s[!] %sThe numbers must be an integer \n\n", Colors.RED, Colors.NORMAL);
                input.next(); // clear input
                continue; // continue input
            }

            if(x < Configuration.SIZE && y < Configuration.SIZE && x >= 0 && y >= 0) {
                if(_temporaryCoordinate.size() == 0) {
                    _temporaryCoordinate.add(x);
                    _temporaryCoordinate.add(y);
                }
                _temporaryCoordinate.set(0, x);
                _temporaryCoordinate.set(1, y);

                boolean isDeployed = this.setCoordinates(_temporaryCoordinate, coordinates, symbol);

                if(isDeployed) { // coordinates exists
                    System.out.printf("%s[!] %sShip exists! you can NOT place two or more ships on the same location. \n\n", Colors.RED, Colors.NORMAL);
                } else {
                    System.out.printf("%s[*] %sShip placed\n\n", Colors.GREEN, Colors.NORMAL);
                    _limit += 1;
                }
            } else {
                System.out.printf("%s[!] %sYou can't place ships outside the %d by %d grid\n\n", Colors.RED, Colors.NORMAL, Configuration.SIZE, Configuration.SIZE);
            }
        }
        return true;
    }

    /**
     * Computer Ship Deploy
     * @param symbol String
     * @param coordinates String[][] Array 2D
     * @return boolean
     */
    public boolean computerShips(String symbol, String[][] coordinates) {
        int _limit = 1;

        System.out.printf("%s[*] %sComputer turn:\n", Colors.GREEN, Colors.NORMAL);
        while(_limit <= Configuration.SIZE - 5) {
            ArrayList<Integer> multipleNumbers = RNG.multipleNumbers();
            boolean isDeployed = this.setCoordinates(multipleNumbers, coordinates, symbol);

            if(!isDeployed) { // coordinates exists
                System.out.printf("%d. Ship DEPLOYED \n", _limit);
                _limit += 1;
            }
        }
        return true;
    }

    /**
     * Set coordinates for the ships
     * @param sc ArrayList<Integer>
     * @param coordinates String[][] Array 2D
     * @param symbol String
     * @return boolean
     */
    private boolean setCoordinates(ArrayList<Integer> sc, String[][] coordinates, String symbol) { // sc = set coordinates
        int x = sc.get(0);
        int y = sc.get(1);

        if(coordinates[x][y] != null) {
            return true;
        } else {
            coordinates[x][y] = symbol;
            return false;
        }
    }
}
