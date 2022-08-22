package com.clouza.battleships;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public class Configuration {
    public static final String USER_SHIPS = "@";
    public static final String COMPUTER_SHIPS = "2";
    public static final String USER_SHIP_DESTROYED = "x";
    public static final String COMPUTER_SHIP_DESTROYED = "!";
    public static final String MISSED = "-";
    public static final String BORDER = "--------------------------------------------------";
    public static final String COMPUTER_MISSED = "*";
    public static final int SIZE = 10; // default size
    public static final int MAX_GUESS = 0; // change the value to 0 for infinity guess
}
