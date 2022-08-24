package net.clouza.battleships.resources;

import net.clouza.battleships.Configuration;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class Cannon {
    /**
     * Messages available
     */
    private final String NICE_TRY = "%s[!] %sSorry, you missed";
    private final String NEED_IMPLEMENT_AN_AI = "%s[!] %sComputer missed";
    private final String GOOD_ONE = "%s[!] %sBoom! You sunk the ship!";
    private final String THIS_IS_NOT_17TH_CENTURY = "%s[!] %sThe Computer sunk one of your ships!";
    private final String IMAGINE_YOUR_OWN_SHIP_XD = "%s[!] %sOh no, you sunk your own ship :(";
    private final String FRIENDLY_FIRE = "%s[!] %sThe Computer sunk one of its own ships";

    /**
     * Properties
     */
    private String[][] _coordinates;
    private int _currentUserShips = Configuration.SIZE - 5, _currentComputerShips = Configuration.SIZE - 5;
    private int _x, _y;

    /**
     * The constructor of Cannon class
     * @param coordinates
     * @return void
     */
    public Cannon(String[][] coordinates) { this._coordinates = coordinates; }

    /**
     * An important method used for in-game mechanics
     * @param x The x coordinate
     * @param y The y coordinate
     * @param whoIsCurrentlyFire The symbol of the ships
     */
    public void fire(int x, int y, String whoIsCurrentlyFire) {
        _x = x;
        _y = y;

        // missed
        if(_coordinates[x][y] == null) {
            missed(whoIsCurrentlyFire);
        }
        else {
            // not missed
            if (whoIsCurrentlyFire == Configuration.USER_SHIPS) { // user
                // ============================================ Custom Message
                if(_coordinates[x][y].equals(Configuration.USER_SHIP_DESTROYED)) {
                    System.out.printf(IMAGINE_YOUR_OWN_SHIP_XD + " ...again??", Colors.RED, Colors.NORMAL);
                }
                if(_coordinates[x][y].equals(Configuration.COMPUTER_SHIP_DESTROYED)) {
                    System.out.printf("Please guess another coordinate ...", Colors.RED, Colors.NORMAL);
                }
                if(_coordinates[x][y].equals(Configuration.MISSED) || _coordinates[x][y].equals(Configuration.COMPUTER_MISSED)) {
                    missed(whoIsCurrentlyFire);
                }

                // ============================================ Normal Message
                if (_coordinates[x][y].equals(whoIsCurrentlyFire)) {
                    _userShip(IMAGINE_YOUR_OWN_SHIP_XD, false);
                }
                if(_coordinates[x][y].equals(Configuration.COMPUTER_SHIPS)) {
                    _userShip(GOOD_ONE, true);
                }
            } else { // computer
                if(_coordinates[x][y].equals(Configuration.COMPUTER_MISSED) || _coordinates[x][y].equals(Configuration.MISSED) || _coordinates[x][y].equals(Configuration.USER_SHIP_DESTROYED) || _coordinates[x][y].equals(Configuration.COMPUTER_SHIP_DESTROYED)) {
                    checkDuplicate(x, y, whoIsCurrentlyFire);
                } else {
                    if (_coordinates[x][y].equals(whoIsCurrentlyFire)) { // ?
                        _computerShip(FRIENDLY_FIRE, false);
                    }

                    if(_coordinates[x][y].equals(Configuration.USER_SHIPS)) { // @
                        _computerShip(THIS_IS_NOT_17TH_CENTURY, true);
                    }
                }


            }
        }
    }

    /**
     * User ships
     * @param message The message
     * @param isEnemyShip True or False
     */
    private void _userShip(String message, boolean isEnemyShip) {
        if(isEnemyShip) {
            _coordinates[_x][_y] = Configuration.COMPUTER_SHIP_DESTROYED;
            _currentComputerShips -= 1;
        } else {
            _coordinates[_x][_y] = Configuration.USER_SHIP_DESTROYED;
            _currentUserShips -= 1;
        }
        System.out.printf(message, Colors.RED, Colors.NORMAL);
    }

    /**
     * Computer ships
     * @param message The message
     * @param isEnemyShip True or False
     */
    private void _computerShip(String message, boolean isEnemyShip) {
        if(isEnemyShip) {
            _coordinates[_x][_y] = Configuration.USER_SHIP_DESTROYED;
            _currentUserShips -= 1;
        } else {
            _coordinates[_x][_y] = Configuration.COMPUTER_SHIP_DESTROYED;
            _currentComputerShips -= 1;
        }
        System.out.printf(message, Colors.RED, Colors.NORMAL);
    }

    /**
     * Missed method used for user & computer
     * @param ship
     * @return int
     */
    private int missed(String ship) {
        if(ship.equals(Configuration.USER_SHIPS)) {
            _coordinates[_x][_y] = Configuration.MISSED;
            System.out.printf(NICE_TRY, Colors.RED, Colors.NORMAL);
            return _currentUserShips;
        } else {
            _coordinates[_x][_y] = Configuration.COMPUTER_MISSED;
            System.out.printf(NEED_IMPLEMENT_AN_AI, Colors.RED, Colors.NORMAL);
            return _currentComputerShips;
        }
    }

    /**
     * Check duplicate number
     * @param x The x coordinate
     * @param y The y coordinate
     * @param whoIsCurrentlyFire The symbol of the ship
     */
    private void checkDuplicate(int x, int y, String whoIsCurrentlyFire) {
        int tempX = new RandomNumberGenerator(Configuration.SIZE).singleNumber().get();
        int tempY = new RandomNumberGenerator(Configuration.SIZE).singleNumber().get();

        if(x == tempX && y == tempY) {
            checkDuplicate(x, y, whoIsCurrentlyFire);
        }

        fire(tempX, tempY, whoIsCurrentlyFire);
    }

    public int getUserShips() {
        return _currentUserShips;
    }
    public int getComputerShips() {
        return _currentComputerShips;
    }

}
