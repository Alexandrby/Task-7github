package com.senla.service.intf;

import com.senla.factory.intf.Room;

import java.io.IOException;
import java.util.ArrayList;

public interface RoomServiceBasic <T,C,P> {

    void createHotelRoom(T t) throws IOException;

    void readRoom(C c) throws IOException;

    void updateHotelRoom(T t);

    ArrayList<T> readHotelRooms() throws IOException;

    void deleteHotelRoom(C c);

    void importHotelRoom (C id) throws IOException;

    void exportHotelRoom(C c) throws IOException;

    void readAllCSVRoom() throws IOException;

    void quantityFreeRoom() throws IOException;

    void sortRooms() throws IOException;

    void changeStatus(C c, P p) throws IOException;
}
