package com.senla.controller;
import com.senla.factory.intf.Guest;
import com.senla.service.intf.GuestServiceBasic;
import com.senla.view.GuestView;
import java.io.IOException;
import java.util.ArrayList;

public class GuestController implements Controller {
    private GuestServiceBasic guestServiceBasic;
    private GuestView guestView;

    public GuestController(GuestServiceBasic guestServiceIt, GuestView guestView) {
        this.guestServiceBasic = guestServiceIt;
        this.guestView = guestView;
    }

    private void createGuest()  {
        Guest guest = guestView.createGuest();
         guestServiceBasic.createHotelGuest(guest);

    }

    private void readGuest(){
        String nameOfGuest = guestView.readGuest();
        guestServiceBasic.readGuest(nameOfGuest);
    }

    private void deleteGuest() {
        String nameGuest = guestView.deleteGuest();
        guestServiceBasic.deleteGuest(nameGuest);
    }

    private void getTotalGuests() {
        guestServiceBasic.getTotalGuests();
    }

    private void importGuest()  {
        String id = String.valueOf(guestView.importGuest());
            guestServiceBasic.importHotelGuest(id);
    }

    private void exportGuest() {
        String nameOfGuest = guestView.exportGuest();
            guestServiceBasic.exportHotelGuest(nameOfGuest);

    }

    private void addTestGuests() {
        guestServiceBasic.addTestGuests();
    }

    private void readAll() {
        guestServiceBasic.readAll();
    }

    public void readAllGuest() {
        ArrayList<Guest> guests = null;
        try {
            guests = guestServiceBasic.readAllHotelGuest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("File could not be readFile");
            guestView.printAllGuest(guests);
    }

    //
    @Override
    public void execute()  {

        while (true) {
            int numberOfcaseController = guestView.executeChoice();
            switch (numberOfcaseController) {
                case 1:
                    createGuest();
                    break;
                case 2:
                    deleteGuest();
                    break;
                case 3:
                    getTotalGuests();
                    break;
                case 4:
                    importGuest();
                    break;
                case 5:
                    exportGuest();
                    break;
                case 6:
                    readAll();
                    break;
                case 7:
                    readAllGuest();
                    break;
                case 8:
                   return;
                default:
                   guestView.errorSelect();
            }

        }
    }
}

