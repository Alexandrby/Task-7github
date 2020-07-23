package com.senla.service.intf;
import java.io.IOException;
import java.util.ArrayList;

public interface GuestServiceBasic <T,P>{


    void createHotelGuest(T t) ;

    void updateHotelGuest(T t);

    ArrayList<T> readAllHotelGuest() throws IOException;

    void deleteGuest(P nameGuest);

    void readGuest(P p) ;

    //List of all ordinaryGuests
    void  getTotalGuests() ;

    void importHotelGuest(P id) ;

    void exportHotelGuest(P nameOfGuest) ;

    void addTestGuests();

    void readAll() ;

}
