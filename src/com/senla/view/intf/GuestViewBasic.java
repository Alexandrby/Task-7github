package com.senla.view.intf;

import com.senla.factory.intf.Guest;

import java.util.ArrayList;

public interface GuestViewBasic {

    Guest createGuest();

    String readGuest();

    String deleteGuest();

    int executeChoice();

    int importGuest();

    String exportGuest();

    void printAllGuest(ArrayList<Guest> listAllHotelGuest);


}
