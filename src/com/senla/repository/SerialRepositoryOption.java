package com.senla.repository;
import com.senla.factory.intf.Option;
import com.senla.serial.Serialization;

import java.io.IOException;
import java.util.ArrayList;

public class SerialRepositoryOption implements RepositoryBasis<Option, String> {
    private Serialization serial;

    public SerialRepositoryOption(Serialization serial) {
        this.serial = serial;
    }

    @Override
    public Option create(Option option) throws IOException {
        serial.writeSerial(option);
        return option;
    }

    @Override
    public Option read(String s) throws IOException, ClassNotFoundException {
        return (Option) serial.readSerial();
    }

    @Override
    public Option update(Option option) {
        return null;
    }

    @Override
    public void delete(String nameGuest) {

    }

    @Override
    public ArrayList<Option> createAll(String s) {
        return null;
    }

    @Override
    public ArrayList<Option> readAll() throws IOException {
        return null;
    }

    @Override
    public void addTestList() {

    }
}
