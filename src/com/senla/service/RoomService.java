package com.senla.service;
import com.senla.comparators.RoomByPrice;
import com.senla.factory.intf.Room;
import com.senla.model.OrdinaryRoom;
import com.senla.repository.RoomCSVRepository;
import com.senla.repository.RoomRepository;
import com.senla.repository.RepositoryBasis;
import com.senla.repository.SerialRepositoryRoom;
import com.senla.serial.Serialization;
import com.senla.service.intf.RoomServiceBasic;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class RoomService implements RoomServiceBasic <Room, Integer, String> {
    private RepositoryBasis repositoryBasis;
    private RoomCSVRepository roomCSVRepository;
    private SerialRepositoryRoom serialRepositoryRoom;


    public RoomService(RoomRepository roomRepository) {
        this.repositoryBasis = roomRepository;
        this.roomCSVRepository = new RoomCSVRepository(roomRepository);
        this.serialRepositoryRoom = new SerialRepositoryRoom(new Serialization());
    }

    public void createListHotelRooms() throws IOException {
        repositoryBasis.addTestList();
    }

    @Override
    public void createHotelRoom(Room room)  {
        try {
            repositoryBasis.create(room);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serialRepositoryRoom.create(room);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Проблема с записью(сериализацией) сущности");
        }
    }

    @Override
    public void readRoom(Integer numberOfRoom) throws IOException {
        try {
            repositoryBasis.read( numberOfRoom);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHotelRoom(Room room) {
        repositoryBasis.update(room);
        }

    @Override
    public ArrayList<Room> readHotelRooms() throws IOException {
        return repositoryBasis.readAll();
    }

    @Override
    public void importHotelRoom(Integer id) throws IOException,IndexOutOfBoundsException {
    roomCSVRepository.read(id);
    }

    @Override
    public void exportHotelRoom(Integer numberOfRoom) throws IOException,NumberFormatException {
        try {
            roomCSVRepository.create((Room) repositoryBasis.read(numberOfRoom));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readAllCSVRoom() throws IOException {
    roomCSVRepository.readAll();
    }

    @Override
    public void deleteHotelRoom(Integer numberOfRoom) {
        repositoryBasis.delete(numberOfRoom);
    }

    @Override
    public void changeStatus(Integer roomNumber, String status) throws IOException {
        for (Room room : readHotelRooms()) {
            if (room.getNumberOfRoom()==roomNumber)
                    room.setStatus(status);
        }
        System.out.println("Статус комнаты №" + roomNumber + " - " + status);
    }

    //List of free Rooms
    public static ArrayList<Room> getAllFreeRooms(ArrayList<Room> roomsList) {
        ArrayList<Room> freeRoomsList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < roomsList.size(); i++) {
            if (roomsList.get(i).getStatus().equals("Free")) {
                freeRoomsList.set(count, roomsList.get(i));
                count++;
            }
        }
        return freeRoomsList;
    }

    // Sort freeRoom by price, capacity and stars
    public static ArrayList<OrdinaryRoom> sortFreeRooms(ArrayList<OrdinaryRoom> ordinaryRooms) {
        Collections.sort(ordinaryRooms, new RoomByPrice());
        return ordinaryRooms;
    }

    // Quantity freeRoom
    @Override
    public void quantityFreeRoom() throws IOException {

        int count = 0;
        for (Room room :readHotelRooms() ) {
            if (room.getStatus().equals("Free")) {
                count++;
            }
        }
        System.out.println("Количество свободных номеров в отеле - " + count);
    }

    // Sort rooms by price
    @Override
    public void   sortRooms() throws IOException {
        ArrayList<Room> sortList = readHotelRooms();
        Collections.sort(sortList , new RoomByPrice());
        for (int i =0; i<sortList.size(); i++){
            System.out.println(sortList.get(i));
        }
    }

    // get list of free rooms by date (don't work now)
    public ArrayList<Room> getListOfFreeRoomByDate (ArrayList<Room> roomsList, LocalDate stardRental, LocalDate endRental){
        return roomsList;
    }
}
