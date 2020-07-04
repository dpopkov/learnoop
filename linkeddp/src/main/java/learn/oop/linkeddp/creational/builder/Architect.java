package learn.oop.linkeddp.creational.builder;

import java.awt.*;

public class Architect {
    public static void main(String[] args) {
        Bedroom room = new BedroomBuilder().setDimension(new Dimension(200, 100))
                .setCeilingHeight(132).setFloorNumber(2).setWallColor(Color.yellow)
                .setNumberOfWindows(2).setNumberOfDoors(1).setIsDouble(true).setHasEnsuite(true)
                .createBedroom();
    }
}
