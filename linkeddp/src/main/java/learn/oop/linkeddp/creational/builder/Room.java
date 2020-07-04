package learn.oop.linkeddp.creational.builder;

import java.awt.*;

public class Room {
    protected Dimension dimension;
    protected int ceilingHeight;
    protected int floorNumber;
    protected Color wallColor;
    protected int numberOfWindows;
    protected int numberOfDoors;

    public Room(Dimension dimension, int ceilingHeight, int floorNumber, Color wallColor,
                int numberOfWindows, int numberOfDoors) {
        this.dimension = dimension;
        this.ceilingHeight = ceilingHeight;
        this.floorNumber = floorNumber;
        this.wallColor = wallColor;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
    }
}
