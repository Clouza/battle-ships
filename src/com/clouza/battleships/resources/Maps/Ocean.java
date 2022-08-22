package com.clouza.battleships.resources.Maps;

import com.clouza.battleships.Configuration;

/**
 * @author Clouza (Siwa)
 * @link https://github.com/clouza
 * @version 1.0.0
 */
public class Ocean extends Coordinates implements BaseMap {
    public Ocean() {
        System.out.println("Map: Ocean");
    }

    @Override
    public void openCoordinates() {
        for (int i = 0; i < this.coordinates.length; i++) {
            if(i == 0) {
                for (int firstRow = 0; firstRow < this.coordinates.length; firstRow++) {
                    if(firstRow == 0) {
                        System.out.print("   " + firstRow);
                    } else {
                        System.out.print("  " + firstRow);
                    }
                }
                System.out.print("\n");
            }

            System.out.print(i + "|");
            for (int j = 0; j < this.coordinates[i].length; j++) {
                System.out.print(this.coordinates[i][j] + " ");
            }
            System.out.print("|" + i + "\n");

            if(i == 9) {
                for (int lastRow = 0; lastRow < this.coordinates.length; lastRow++) {
                    if(lastRow == 0) {
                        System.out.print("   " + lastRow);
                    } else {
                        System.out.print("  " + lastRow);
                    }
                }
                System.out.print("\n");
            }
        }
    }

    @Override
    public String[][] init(int start, int size) {
        this.coordinates = new String[size][size]; // 10 10
        /**
        * [x][y]
         * Examples:
         * [x, x, x, ...](ROWS)
         * [[y, y, y, y, ...], x, x, x](COLS)
         *
         * [[0, 1, 2, 3, ...], [0, 1, 2, 3, ...], [0, 1, 2, 3, ...], [0, 1, 2, 3, ...], ...](ROWS)(COLS)
         */
        return this.coordinates;
    }

    @Override
    public void map(String symbol, boolean computerShipsHidden, boolean computerGuessHidden) {
        for (int row = 0; row < this.coordinates.length; row++) {
            if(row == 0) {
                for (int firstRow = 0; firstRow < this.coordinates.length; firstRow++) {
                    if(firstRow == 0) {
                        System.out.print("   " + firstRow);
                    } else {
                        System.out.print("  " + firstRow);
                    }
                }
                System.out.print("\n");
            }

            System.out.print(row + "|");
            for (int col = 0; col < this.coordinates[row].length; col++) {
                if(this.coordinates[row][col] == null) {
                    System.out.print(" " + " " + " ");
                } else {
                    // computer ships & computer guess
                    if(computerShipsHidden && computerGuessHidden && symbol == Configuration.COMPUTER_SHIPS) {
                        String regex = String.format("[%s|%s]", Configuration.COMPUTER_SHIPS, Configuration.COMPUTER_MISSED);
                        System.out.print(" " + this.coordinates[row][col].replaceAll(regex, " ") + " ");
                    }

                    if(!computerGuessHidden && !computerShipsHidden) {
                        System.out.print(" " + this.coordinates[row][col] + " ");
                    }

                    // computer ships
                    if(computerShipsHidden && symbol == Configuration.COMPUTER_SHIPS && !computerGuessHidden) {
                        System.out.print(" " + this.coordinates[row][col].replace(Configuration.COMPUTER_SHIPS, " ") + " ");
                    }

                    // computer hidden
                    if(computerGuessHidden && symbol == Configuration.COMPUTER_SHIPS && !computerShipsHidden) {
                        System.out.print(" " + this.coordinates[row][col].replace(Configuration.COMPUTER_MISSED, " ") + " ");
                    }
                }


            }
            System.out.print("|" + row + "\n");

            if(row == Configuration.SIZE - 1) {
                for (int lastRow = 0; lastRow < this.coordinates.length; lastRow++) {
                    if(lastRow == 0) {
                        System.out.print("   " + lastRow);
                    } else {
                        System.out.print("  " + lastRow);
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
