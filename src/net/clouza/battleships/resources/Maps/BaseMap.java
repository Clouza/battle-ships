package net.clouza.battleships.resources.Maps;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
interface BaseMap {

    /**
     * real-time map? (depending on user opinion)
     * change to true if you want to debug the program
     * @param symbol symbol for the computer ships
     * @param computerShipsHidden ships hidden (show the computer ships)
     * @param computerGuessHidden guess hidden (show the computer guess)
     */
    abstract void map(String symbol, boolean computerShipsHidden, boolean computerGuessHidden);

    /**
     * Initialize the map
     * @param start
     * @param size
     * @return Array
     */
    abstract String[][] init(int start, int size);
}
