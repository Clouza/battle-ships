package net.clouza.battleships.resources;

import java.util.ArrayList;

/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */

/**
 * Random Number Generator (RNG) class, provide random number and utilities for work with the number.
 * @since 1.0.0
 */
public class RandomNumberGenerator {
    private int _max;
    private int _singleNumber;

    /**
     * Constructor of Random Number Generator (RNG) class
     * @param maxNumber The maximum number of Random Number Generator
     * @return int
     */
    public RandomNumberGenerator(int maxNumber) {
        this._max = maxNumber;
    }

    /**
     * Multiple Numbers, only return 2 random number
     * @return ArrayList multipleNumber
     */
    public ArrayList<Integer> multipleNumbers() {
        ArrayList<Integer> multipleNumber = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
             multipleNumber.add((int) (Math.random() * _max));
        }
        return multipleNumber;
    }

    /**
     * Single Number, only return 1 random number
     * @return class RandomNumberGenerator
     */
    public RandomNumberGenerator singleNumber() {
        _singleNumber = (int) (Math.random() * _max);
        return this;
    }

    /**
     * Get the number from singlenumber() method
     * @return int singleNumber
     */
    public int get() {
        return _singleNumber;
    }
}
