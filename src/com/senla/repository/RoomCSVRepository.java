package com.senla.repository;
import com.senla.csv.EntityCSV;
import com.senla.factory.RoomFactory;
import com.senla.factory.intf.Room;
import com.senla.proper.Property;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomCSVRepository implements RepositoryBasis<Room, Integer> {
    private Room room = null;
    RoomRepository roomRepository;
    private EntityCSV entityCsv;
    private Property property = new Property(); // <- не самый удачный способ, но через конструктор не получилось почему-то, надо разбираться.
//   private File fileRoom = new File("C:/WorkJava/Reps/HotelRoomRepos.csv");     //home
//   private File fileRoom = new File("D:/Синёв/разное/Java learn/HotelRoomRepos.csv");     //work
     private  File fileRoom = new File(property.load("room"));

    public RoomCSVRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.entityCsv = new EntityCSV(fileRoom);
    }

    @Override
    public Room create(Room room) throws IOException {
        int numberOfRoom = room.getNumberOfRoom();
        int count=0;
        List<String> listToWrite = new ArrayList<>();
        for (Room room1 : roomRepository.roomsList){
            if (room1.getNumberOfRoom() == numberOfRoom ){
                listToWrite.add(String.valueOf(getLastId()));
                listToWrite.add(String.valueOf(room1.getNumberOfRoom()));
                listToWrite.add(room1.getType());
                listToWrite.add(room1.getStatus());
                listToWrite.add(String.valueOf(room1.getCapacityOfRoom()));
                listToWrite.add(String.valueOf(room1.getStar()));
                listToWrite.add(String.valueOf(room1.getPricePerRoom()));
                count++;
                System.out.println("Комната " + numberOfRoom + " успешно добавлена в файл csv ");
            }
        }
        if(count==0){
            System.err.println("Такой комнаты нет в списке хранилища. Введит корректный номер команты .");
        }
        entityCsv.writeFile(listToWrite);
        return room;
    }

    @Override
    public Room read(Integer id) throws IOException {
        List<List<String>> rooms = entityCsv.readFile();

        String typeOfRoom = rooms.get(id).get(2);
        try {
            room = RoomFactory.valueOf(typeOfRoom).create();
            room.setId(Integer.parseInt(rooms.get(id).get(0)));
            room.setNumberOfRoom(Integer.parseInt(rooms.get(id).get(1)));
            room.setStatus(rooms.get(id).get(3));
            room.setCapacityOfRoom(Integer.parseInt((rooms.get(id).get(4))));
            room.setStar(Integer.parseInt(rooms.get(id).get(5)));
            room.setPrice(Integer.parseInt(rooms.get(id).get(6)));
            roomRepository.roomsList.add(room);
            System.out.println("Комната с id " + id + " успешно импортирован в коллекцию ");
        } catch (IndexOutOfBoundsException index) {
            throw index;
        }
        return null;
    }

    @Override
    public Room update(Room room) {
        return null;
    }

    @Override
    public void delete(Integer nameGuest) {
    }

    @Override
    public ArrayList<Room> createAll(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Room> readAll() throws IOException {
        List<List<String>> rooms = entityCsv.readFile();
        for (List<String> room : rooms){
            System.out.println(room);
        }
        return null;
    }

    @Override
    public void addTestList()  {
    }

        public int getLastId () throws IOException, NumberFormatException {
            int lastId = 0;
            List<List<String>> rooms = entityCsv.readFile();
            try {
                lastId = Integer.parseInt(rooms.get(rooms.size() - 1).get(0)) + 1;
            } catch (NumberFormatException num) {
                throw num;
            }
            return lastId;
        }
}


