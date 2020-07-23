package com.senla.repository;
import com.senla.csv.EntityCSV;
import com.senla.factory.GuestFactory;
import com.senla.factory.intf.Guest;
import com.senla.proper.Property;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GuestCSVRepository implements RepositoryBasis<Guest, String> {
    private Guest guest = null;
    private GuestRepository guestRepository;
//    private   File fileGuest = new File("C:/WorkJava/Reps/HotelGuestRepos.csv");      //home
//    private File fileGuest = new File("D:/Синёв/разное/Java learn/HotelGuestRepos.csv");     //work
    private EntityCSV entityCsv;
    Property property = new Property();
    private  File fileGuest = new File(property.load("guest"));

    public GuestCSVRepository(GuestRepository guestRepository) {
        this.entityCsv =new EntityCSV(fileGuest);
        this.guestRepository = guestRepository;

    }

    @Override
    public Guest create(Guest guest) throws IOException {
        String nameOfGuest = guest.getGuestName();
        List<String> listToWrite = new ArrayList<>();
        int count =0;
        for (Guest guest1 : guestRepository.guestsList) {
            if (guest1.getGuestName().equals(nameOfGuest)) {
                listToWrite.add(String.valueOf(getLastId()));
                listToWrite.add(guest1.getGuestName());
                listToWrite.add(String.valueOf(guest.getNumberOfApartment()));
                listToWrite.add(guest1.getType());
                listToWrite.add(String.valueOf(guest.getStartRental()));
                listToWrite.add(String.valueOf(guest.getEndRental()));
                System.out.println("Гость " + nameOfGuest + " успешно добавлен в файл csv ");
                count++;
            }
        }
        if(count==0){
            System.err.println("Такого гостя нет в списке хранилища. Введит корректное имя.");
        }
        entityCsv.writeFile(listToWrite);
         return guest;
    }

    @Override
    public Guest read(String stringId) throws IOException {
        int id = Integer.parseInt(stringId);
        List<List<String>> guests = entityCsv.readFile();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        try {
            LocalDate startRental = LocalDate.parse(guests.get(id).get(4), formatter);
            LocalDate endRental = LocalDate.parse(guests.get(id).get(5), formatter);
            String typeOfGuest = guests.get(id).get(3);

            guest = GuestFactory.valueOf(typeOfGuest).create();
            guest.setId(Integer.parseInt(guests.get(id).get(0)));
            guest.setGuestName(guests.get(id).get(1));
            guest.setNumberOfApartment(Integer.parseInt(guests.get(id).get(2)));
            guest.setStartRental(startRental);
            guest.setEndRental(endRental);
            guestRepository.guestsList.add(guest);
            System.out.println("Гость с id " + id + " успешно импортирован в коллекцию ");
        } catch (IndexOutOfBoundsException index) {
            throw index;
        }

        return null;
   }

    @Override
    public Guest update(Guest guest) {
        return null;
    }

    @Override
    public void delete(String nameGuest) {

    }

    @Override
    public ArrayList<Guest> readAll() throws IOException {
        List<List<String>> guests = entityCsv.readFile();
        for (List<String> guest : guests) {
            System.out.println(guest);
        }
        return null;
    }

    @Override
    public void addTestList() {

    }

    @Override
    public ArrayList<Guest> createAll(String name) {
        return null;
    }

    public int getLastId() throws NumberFormatException, IOException {
        int lastId = 0;
        List<List<String>> guests = entityCsv.readFile();
        try {
            lastId = Integer.parseInt(guests.get(guests.size() - 1).get(0)) + 1;
        } catch (NumberFormatException num) {
            throw num;
        }
        return lastId;
    }

}



