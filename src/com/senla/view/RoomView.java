package com.senla.view;
import com.senla.factory.intf.Room;
import com.senla.factory.RoomFactory;
import com.senla.view.intf.RoomViewBasic;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomView implements RoomViewBasic {

    private Scanner scanner = new Scanner(System.in);
    Room room = null;

    @Override
    public Room createRoom() {
        System.out.println("Укажите номер комнаты: ");
        int numberOfRoom = scanner.nextInt();
        System.out.println("Укажите тип комнаты (VIP/ORDINARY):");
        String switchOnString = scanner.nextLine();
        String typeOfRoom = scanner.nextLine();
        room = RoomFactory.valueOf(typeOfRoom).create();
        room.setNumberOfRoom(numberOfRoom);
        System.out.println("Комната №" + numberOfRoom + ", типа " + typeOfRoom + " успешно создана.");
        return room;
    }

    public int  readRoom() {
        System.out.println("Укажите номер комнаты: ");
        int numberOfDeleteRoom = scanner.nextInt();
        return numberOfDeleteRoom;
    }

    @Override
    public int deleteRoom() {
        System.out.println("Укажите номер комнаты: ");
        int numberOfDeleteRoom = scanner.nextInt();
        return numberOfDeleteRoom;
    }

    @Override
    public int changeStatus () {
        System.out.println("Укажите номер комнаты: ");
        int numberOfStatusRoom = scanner.nextInt();
        System.out.println("Укажите новый статус комнаты (Free/Busy/Fix): ");
        System.out.println(" данный сервис находится в разработке :(");
        String switchOnString2 = scanner.nextLine();
        String status = scanner.nextLine();
        return  numberOfStatusRoom;
    }

    public void printAllRoom(ArrayList<Room> listAllHotelRoom) {
        for (Room room : listAllHotelRoom) {
            System.out.println(room);
        }
    }

    public int importRoom(){
        System.out.println("Выберите id комнаты из списка(файл.csv) которую хотите импортировать в коллекцию: ");
        int id = scanner.nextInt();
        return id;
    }

    public int exportRoom(){
        System.out.println("Укажите номер команты, которую требуется экспортировать из коллекции в файл csv : ");
        int numberOfRoom = scanner.nextInt();
        return numberOfRoom;
    }


    @Override
    public int executeChoice() {
        System.out.println("Выберите один из пунктов нажав соответствующую цифру: ");
        System.out.println("1. Добавить новую комнату ");
        System.out.println("2. Удалить комнату ");
        System.out.println("3. Изменить статус комнаты");
        System.out.println("4. Вывести на экран количество свободных комнат");
        System.out.println("5. Сортировать комнаты по цене");
        System.out.println("6. Импортировать комнату из файла csv в хранилище(коллекцию)");
        System.out.println("7. Экспортировать комнату из хранилища(коллекции) в файл csv");
        System.out.println("8. Просмотреть список комнат из файла csv");
        System.out.println("9. Просмотреть список комнат из хранилиша(коллекции) ");
        System.out.println("10. Вернуться в предыдущее меню");
        int numberOfcase = scanner.nextInt();
        return numberOfcase;
    }

    public void errorSelect (){
        System.err.println("Нет такого пункта в меню. Введите корректное значение");
    }

}
