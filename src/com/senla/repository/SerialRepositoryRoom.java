package com.senla.repository;
import com.senla.factory.intf.Room;
import com.senla.serial.Serialization;

import java.io.IOException;
import java.util.ArrayList;

public class SerialRepositoryRoom implements RepositoryBasis<Room, Integer> {
    Serialization serial;

    public SerialRepositoryRoom(Serialization serial) {
        this.serial = serial;
    }

    @Override
    public Room create(Room room) throws IOException {
        serial.writeSerial(room);
        return room;
    }

    @Override
    public Room read(Integer integer) throws IOException, ClassNotFoundException {
        return (Room) serial.readSerial();
    }

    @Override
    public Room update(Room room) {
        return null;
    }

    @Override
    public void delete(Integer nameGuest) {

    }

    @Override
    public ArrayList<Room> createAll(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Room> readAll() throws IOException {
        return null;
    }

    @Override
    public void addTestList() {

    }
}
