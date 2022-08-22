package com.clouza.battleships.resources.Maps;

import java.util.ArrayList;
/**
 * @author Clouza (Siwa)
 * @version 1.0.0
 * @link https://github.com/clouza
 */
public abstract class Coordinates {
    protected String[][] coordinates;

    /**
     * Open the map
     * @return void
     */
    public abstract void openCoordinates();
}