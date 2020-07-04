package learn.oop.linkeddp.creational.builder;

import java.awt.*;

public class BedroomBuilder {
    private Dimension dimension;
    private int ceilingHeight;
    private int floorNumber;
    private Color wallColor;
    private int numberOfWindows;
    private int numberOfDoors;
    private boolean isDouble;
    private boolean hasEnsuite;

    public BedroomBuilder setDimension(Dimension dimension) {
        this.dimension = dimension;
        return this;
    }

    public BedroomBuilder setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
        return this;
    }

    public BedroomBuilder setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    public BedroomBuilder setWallColor(Color wallColor) {
        this.wallColor = wallColor;
        return this;
    }

    public BedroomBuilder setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
        return this;
    }

    public BedroomBuilder setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }

    public BedroomBuilder setIsDouble(boolean isDouble) {
        this.isDouble = isDouble;
        return this;
    }

    public BedroomBuilder setHasEnsuite(boolean hasEnsuite) {
        this.hasEnsuite = hasEnsuite;
        return this;
    }

    public Bedroom createBedroom() {
        return new Bedroom(dimension, ceilingHeight, floorNumber, wallColor, numberOfWindows,
                numberOfDoors, isDouble, hasEnsuite);
    }
}