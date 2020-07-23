package com.senla.service.intf;
import java.io.IOException;
import java.util.ArrayList;

public interface OptionServiceBasic <T,P> {

    void createHotelOption(T t) throws IOException;

    void readOption(P p) throws IOException;

    void updateHotelOption(T t);

    ArrayList<T> readHotelOptions() throws IOException;

    void deleteHotelOption(P nameOfOption);

    void importHotelOption (P id) throws IOException;

    void exportHotelOption(P nameOfGuest) throws IOException;

    void readAllCSVOption() throws IOException;
}
