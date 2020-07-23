package com.senla.repository;
import com.senla.factory.intf.Room;
import com.senla.factory.RoomFactory;

import java.io.IOException;
import java.util.ArrayList;

public class RoomRepository implements RepositoryBasis<Room, Integer> {

    public  ArrayList<Room> roomsList = new ArrayList<>();

    @Override
    public void addTestList() {
        Room room = RoomFactory.ORDINARY.create();
        for (int i = 1; i < 8; i++){
            Room ordinaryRoom = RoomFactory.ORDINARY.create();
            ordinaryRoom.setNumberOfRoom(i);
            ordinaryRoom.setStatus("Free");
            roomsList.add(ordinaryRoom);}

        for (Room room1 : roomsList) {
            if (room1.getNumberOfRoom() <= 4) {
                room1.setCapacityOfRoom(1);
                room1.setStar(3);
                room1.setPrice(50);
                room1.setType("Ordinary");
            } else if (room1.getNumberOfRoom() > 4 && room1.getNumberOfRoom() < 8) {
                room1.setCapacityOfRoom(2);
                room1.setStar(4);
                room1.setPrice(30);
                room1.setType("Ordinary");
            }
        }

        for (int i = 8; i < 11; i++){
            Room vipRoom = RoomFactory.VIP.create();
            vipRoom.setType("Vip");
            vipRoom.setNumberOfRoom(i);
            vipRoom.setStatus("Busy");
            vipRoom.setCapacityOfRoom(1);
            vipRoom.setStar(5);
            vipRoom.setPrice(100);
            roomsList.add(vipRoom);
        }
    }

    @Override
    public Room create(Room room) {
        roomsList.add(room);
        return room;
    }

    @Override
    public Room read(Integer NumberOfRoom) throws IOException {
        for (Room room : roomsList) {
            if (room.getNumberOfRoom()==(NumberOfRoom))
                return room;
        }
        return null;
    }

    @Override
    public Room update(Room room) {
        for (Room rooms : roomsList ){
            rooms = room;
        }
    return room;
    }

    @Override
    public ArrayList<Room> readAll() {
        return roomsList;
    }

    @Override
    public void delete (Integer numberOfRoom) {
        int count = 0;
        for (int i =0; i<roomsList.size(); i++) {
            if (roomsList.get(i).getNumberOfRoom() == numberOfRoom) {
                count++;
                roomsList.remove(roomsList.get(i));
                System.out.println("Комната №" + numberOfRoom + " успешно удалена.");
            }
        }
         if (count==0){
            System.out.println("Комната №" + numberOfRoom + " не существует.");
                }
            }

     @Override
    public ArrayList<Room> createAll(Integer numberOfRoom) {
     return roomsList;
    }
}


