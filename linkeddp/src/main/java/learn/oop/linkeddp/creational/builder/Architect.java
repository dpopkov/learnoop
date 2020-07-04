package learn.oop.linkeddp.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Architect {
    public static void main(String[] args) {
        Room room1 = new RoomBuilder().setFloorNumber(2).createRoom();
        Room room2 = new RoomBuilder().setFloorNumber(1).createRoom();

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        House house1 = new House(rooms);

        List<Room> rooms2 = new RoomListBuilder().addList()
                .addRoom(room1)
                .addRoom(room2)
                .buildList();
        House house2 = new House(rooms2);

        List<Room> rooms3 = new RoomListBuilder().addList()
                .addRoom().setFloorNumber(2).addRoomToList()
                .addRoom().setFloorNumber(1).addRoomToList()
                .buildList();
        House house3 = new House(rooms3);
    }
}
