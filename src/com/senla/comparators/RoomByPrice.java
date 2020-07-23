package com.senla.comparators;
import com.senla.factory.intf.Room;
import java.util.Comparator;

public class RoomByPrice implements Comparator<Room> {

    @Override
    public int compare(Room room1, Room room2) {
            return (int) (room1.getPricePerRoom()-room2.getPricePerRoom());

    }
}
