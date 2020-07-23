package com.senla.controller;

import com.senla.factory.intf.Room;
import com.senla.service.RoomService;
import com.senla.service.intf.RoomServiceBasic;
import com.senla.view.MainView;
import com.senla.view.RoomView;

import java.io.IOException;
import java.util.ArrayList;

public class RoomController implements Controller {

    private RoomServiceBasic roomServiceBasic;
    private RoomView roomView;


    public RoomController(RoomService roomService, RoomView roomView) {
        this.roomServiceBasic = roomService;
        this.roomView = roomView;
    }

    private void createRoom() {
        Room room = roomView.createRoom();
        try {
            roomServiceBasic.createHotelRoom(room);
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void readRoom() {
        int nameOfRoom = roomView.readRoom();
        try {
            roomServiceBasic.readRoom(nameOfRoom);
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void deleteRoom() {
        int numberOfDeleteRoom = roomView.deleteRoom();
        roomServiceBasic.deleteHotelRoom(numberOfDeleteRoom);
    }

    private void quantityFreeRoom(){
        try {
            roomServiceBasic.quantityFreeRoom();
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void sortRooms(){
        try {
            roomServiceBasic.sortRooms();
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void importRoom () {
    int id = roomView.importRoom();
        try {
            roomServiceBasic.importHotelRoom(id);
        } catch ( IndexOutOfBoundsException index){
            System.err.println("Команты с таким Id не существует! Проверьте файл csv и введите корректный id ");
        }
        catch (IOException e) {
            System.err.println("File could not be readFile");
        }

    }

    private void exportRoom(){
        int numberOfRoom = roomView.exportRoom();
        try {
            roomServiceBasic.exportHotelRoom(numberOfRoom);
        } catch (IOException e) {
            System.out.println("File could not be write");
        }
        catch (NumberFormatException num){
            System.err.println("Файл csv поврежден.При неудачной попытке считать файл, появилась пустая строка \"\", удалите её");
        }
    }

    private void readAllCSV(){
       try {
        roomServiceBasic.readAllCSVRoom();
    } catch (IOException e) {
        System.err.println("File could not be readFile");
    }
    }

    private void readAllRoom(){
        ArrayList rooms = null;
        try {
            rooms = roomServiceBasic.readHotelRooms();
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
        roomView.printAllRoom(rooms);

    }


    public void execute() {

        while (true){
            int numberOfcase = roomView.executeChoice();
            switch (numberOfcase) {
                case 1:
                    createRoom();
                    break;
                case 2:
                    deleteRoom();
                    break;
                case 3:
                    // changeStatus();  //don't work (
                    break;
                case 4:
                    quantityFreeRoom();
                    break;
                case 5:
                    sortRooms();
                    break;
                case 6:
                    importRoom();
                    break;
                case 7:
                    exportRoom();
                    break;
                case 8:
                    readAllCSV();
                    break;
                case 9:
                    readAllRoom();
                    break;
                case 10:
                   return;
                default:
                    roomView.errorSelect();
            }
        }
    }
}

