package learn.oop.linkeddp.creational.builder;

import java.awt.*;

public interface Builder {
    Builder setDimension(Dimension dimension);

    Builder setCeilingHeight(int ceilingHeight);

    Builder setFloorNumber(int floorNumber);

    Builder setWallColor(Color wallColor);

    Builder setNumberOfWindows(int numberOfWindows);

    Builder setNumberOfDoors(int numberOfDoors);
}
