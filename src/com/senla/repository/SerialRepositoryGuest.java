package com.senla.repository;
import com.senla.factory.intf.Guest;
import com.senla.serial.Serialization;

import java.io.IOException;
import java.util.ArrayList;

public class SerialRepositoryGuest implements RepositoryBasis <Guest,String> {
    private Serialization serial;

    public SerialRepositoryGuest(Serialization serial) {
        this.serial = serial;
    }

    @Override
    public Guest create(Guest guest) throws IOException {
        serial.writeSerial(guest);
        return guest;
    }

    @Override
    public Guest read(String s) throws IOException, ClassNotFoundException {
       return (Guest) serial.readSerial();
    }

    @Override
    public Guest update(Guest guest) {
        return null;
    }


    @Override
    public void delete(String nameGuest) {

    }

    @Override
    public ArrayList<Guest> createAll(String s) {
        return null;
    }

    @Override
    public ArrayList<Guest> readAll() throws IOException {
        return null;
    }

    @Override
    public void addTestList() {

    }
}
