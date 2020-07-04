package learn.oop.linkeddp.creational.builder;

import java.awt.*;

public class Bedroom extends Room {
    private boolean isDouble;
    private boolean hasEnsuite;

    public Bedroom(Dimension dimension, int ceilingHeight, int floorNumber, Color wallColor,
                   int numberOfWindows, int numberOfDoors, boolean isDouble, boolean hasEnsuite) {
        super(dimension, ceilingHeight, floorNumber, wallColor, numberOfWindows, numberOfDoors);
        this.isDouble = isDouble;
        this.hasEnsuite = hasEnsuite;
    }
}
