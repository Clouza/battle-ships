package com.clouza.battleships;

import com.clouza.battleships.resources.Guess;
import com.clouza.battleships.resources.Ships;
import com.clouza.battleships.resources.Maps.Ocean;
import com.clouza.battleships.resources.Colors;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class Plays {
    // fields (properties)
    private boolean _isPlaying = true, _isOver = false;
    private int max = 0;
    private boolean _isComputerDeployed = false, _isUserDeployed = false, _isEnd = false;

    private Ships Ship = new Ships();

    // story ( if any :D )
    private boolean _story() {
        return false;
    }

    public void battleships() {
        _welcomeMessage("Welcome to Battle Ships game");
        System.out.println("Right now, the sea is empty...");

        Ocean ocean = new Ocean();
        String[][] coordinates = ocean.init(0, Configuration.SIZE);

        Guess guess = new Guess(coordinates);

        while(_isPlaying && max <= Configuration.MAX_GUESS) {

            ocean.map(Configuration.COMPUTER_SHIPS, true, true);
            System.out.print("\n");

            // user deploy their own ship
            if(!_isUserDeployed) {
                System.out.printf("%s[*] %sDeploy your ships\n", Colors.GREEN, Colors.NORMAL);
                _isUserDeployed = Ship.userShips(Configuration.USER_SHIPS, coordinates); // true
            } else {
                if(!_isComputerDeployed) {
                    // computer deploy the ships
                    _isComputerDeployed = Ship.computerShips(Configuration.COMPUTER_SHIPS, coordinates); // true
                    System.out.println(Configuration.BORDER);
                    System.out.printf("%s[*] %sTime to battle!\n\n", Colors.GREEN, Colors.NORMAL);
                }
            }

            // battle
            if(_isComputerDeployed) {
                guess.userTurn();
                guess.computerTurn();
                guess.currentScore();

                if(Configuration.MAX_GUESS != 0) {
                    max++;
                }

                _isEnd = guess.end();
                if(_isEnd) {
                    ocean.map(Configuration.COMPUTER_SHIPS, false, false); // result
                    this._isPlaying = false; // disable next move [*]
                }
            }
        }
    }

    private void _welcomeMessage(String message) {
        System.out.println("+------------------------------+");
        System.out.printf("| %s |\n", message);
        System.out.println("+------------------------------+");
    }

    /**
     * Clear Console, tested on Git bash
     * currently work on unix command line (not 100% works. but, it's quite good to see)
     * @return void
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
