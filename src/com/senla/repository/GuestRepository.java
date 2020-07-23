package com.senla.repository;
import com.senla.factory.intf.Guest;
import com.senla.factory.GuestFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class GuestRepository implements RepositoryBasis<Guest, String> {

    public ArrayList<Guest> guestsList = new ArrayList<>();

    @Override
    public  void addTestList(){

        Guest guest1 = GuestFactory.ORDINARY.create();
        guest1.setGuestName("Alexandr");
        guest1.setStartRental(LocalDate.now());
        guest1.setEndRental(LocalDate.of(2020, 8, 28));
        guest1.setNumberOfApartment(1);
        guestsList.add(guest1);

        Guest guest2 =GuestFactory.ORDINARY.create();
        guest2.setGuestName("John");
        guest2.setStartRental(LocalDate.now());
        guest2.setEndRental(LocalDate.of(2020, 8, 23));
        guest2.setNumberOfApartment(2);
        guestsList.add(guest2);

        Guest vipGuest =  GuestFactory.VIP.create();
        vipGuest.setGuestName("Robert");
        vipGuest.setStartRental(LocalDate.now());
        vipGuest.setEndRental(LocalDate.of(2020, 10, 1));
        vipGuest.setNumberOfApartment(3);
        guestsList.add(vipGuest);

        Guest vipGuest2 =  GuestFactory.VIP.create();
        vipGuest2.setGuestName("Andry");
        vipGuest2.setStartRental(LocalDate.now());
        vipGuest2.setEndRental(LocalDate.of(2020, 9, 7));
        vipGuest2.setNumberOfApartment(4);
        guestsList.add(vipGuest2);

    }

    @Override
    public Guest create(Guest guest) {
        guestsList.add(guest);

        return guest;
    }

    @Override
    public Guest read(String nameOfGuest) {
        for (Guest guest : guestsList){
            if (guest.getGuestName().equalsIgnoreCase(nameOfGuest))
                return guest;
        }
        return null;
    }

    @Override
    public Guest update(Guest guest) {
        for (Guest guest1 : guestsList){
            guest = guest1;
        }
        return guest;
    }

    @Override
    public ArrayList<Guest> readAll() {
        return guestsList;
    }

    @Override
    public void delete(String nameGuest) {
        int count = 0;
        for (int i=0; i<guestsList.size(); i++){
            if (guestsList.get(i).getGuestName().equals(nameGuest)){
                guestsList.remove(guestsList.get(i));
                count++;
                System.out.println(nameGuest + " больше не живет в гостинице");
            }
        }
        if (count==0){
            System.out.println("Гостя с именем " +  "\"" + nameGuest + "\"" + " нет в списках постояльцев");
        }
    }

    @Override
    public ArrayList<Guest> createAll(String string) {
        return guestsList;
    }
}


