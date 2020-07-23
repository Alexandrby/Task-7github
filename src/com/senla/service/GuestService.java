package com.senla.service;
import com.senla.factory.intf.Guest;
import com.senla.repository.GuestCSVRepository;
import com.senla.repository.GuestRepository;
import com.senla.repository.RepositoryBasis;
import com.senla.repository.SerialRepositoryGuest;
import com.senla.serial.Serialization;
import com.senla.service.intf.GuestServiceBasic;
import java.io.IOException;
import java.util.ArrayList;

public class GuestService implements GuestServiceBasic <Guest, String> {
    private RepositoryBasis repositoryBasis;
    private GuestCSVRepository guestCSVRepository;
    private SerialRepositoryGuest serialRepositoryGuest;

    public GuestService(GuestRepository guestRepository) {
        this.repositoryBasis = guestRepository;
        this.guestCSVRepository = new GuestCSVRepository(guestRepository);
        this.serialRepositoryGuest = new SerialRepositoryGuest(new Serialization());
    }

    @Override
    public void createHotelGuest(Guest guest) {
        try {
            repositoryBasis.create(guest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(guest.getGuestName() + " успешно заселен в комнату №" + guest.getNumberOfApartment() + "(" + guest.getType() + " гость)");
        try {
            serialRepositoryGuest.create(guest);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Проблема с записью(сериализацией) сущности");
        }
    }

    @Override
    public void updateHotelGuest(Guest guest) {
        repositoryBasis.update(guest);
    }

    @Override
    public ArrayList<Guest> readAllHotelGuest() throws IOException {
        return repositoryBasis.readAll();
    }



     @Override
    public void deleteGuest(String nameGuest) {
        repositoryBasis.delete(nameGuest);
    }

    @Override
    public void readGuest(String nameOfGuest){
        try {
            repositoryBasis.read(nameOfGuest);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Проблема с чтением(десериализацией) сущности");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void  getTotalGuests()  {
        String string = "test";
        ArrayList<Guest> guestHotelList = null;
        try {
            guestHotelList = repositoryBasis.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Общее количество постояльцев в гостинице - " + guestHotelList.size() );
    }

    @Override
    public void exportHotelGuest(String name)  {
        try {
        guestCSVRepository.create((Guest) repositoryBasis.read(name));
        } catch (IOException e) {
            System.err.println("File could not be write");
        } catch (NumberFormatException num) {
            System.err.println("Файл csv поврежден.При неудачной попытке считать файл, появилась пустая строка \"\", удалите её");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importHotelGuest(String nameOfGuest)  {
        try {
            guestCSVRepository.read(nameOfGuest);
        } catch (IndexOutOfBoundsException index) {
            System.err.println("Гостя с таким Id не существует! Проверьте файл csv и введите корректный id ");
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }

    }

    @Override
    public void addTestGuests(){
       repositoryBasis.addTestList();
    }

    @Override
    public void readAll()  {
        try {
            guestCSVRepository.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
