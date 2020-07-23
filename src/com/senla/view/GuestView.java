package com.senla.view;
import com.senla.factory.intf.Guest;
import com.senla.factory.GuestFactory;
import com.senla.view.intf.GuestViewBasic;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestView implements GuestViewBasic {
    private Guest guest = null;
    public Scanner scanner = new Scanner(System.in);

    @Override
    public Guest createGuest() {
        System.out.println("Укажите имя нового гостя: ");
        String switchOnString = scanner.nextLine();
        String nameOfGuest = scanner.nextLine();
        System.out.println("Укажите статус нового гостя (VIP/ORDINARY):");
        String typeOfGuest = scanner.nextLine();
        System.out.println("Укажите номер комнаты в которой будет проживать " + nameOfGuest);
        int numberOfApartment = scanner.nextInt();
        guest = GuestFactory.valueOf(typeOfGuest).create();
        guest.setGuestName(nameOfGuest);
        guest.setNumberOfApartment(numberOfApartment);
        return guest;
    }

    @Override
    public String readGuest(){
        System.out.println("Укажите имя гостя: ");
        String switchOnString2 = scanner.nextLine();
        String nameOfGuest = scanner.nextLine();
        return nameOfGuest;
    }

    @Override
    public String deleteGuest() {
        System.out.println("Укажите имя гостя который покидает гостиницу: ");
        String switchOnString2 = scanner.nextLine();
        String nameOfDeleteGuest = scanner.nextLine();
        return nameOfDeleteGuest;
    }

    @Override
    public int importGuest() {
        System.out.println("Выберите id гостя из списка(файл.csv) которого хотите импортировать в коллекцию: ");
        int id = scanner.nextInt();
         return id;
    }

    @Override
    public String exportGuest() {
        System.out.println("Укажите имя гостя, которого требуется экспортировать из коллекции в файл csv : ");
        String switchOnString = scanner.nextLine();
        String nameOfGuest = scanner.nextLine();
        return nameOfGuest;
    }

    @Override
    public void printAllGuest(ArrayList<Guest> listAllHotelGuest) {
        for (Guest guest : listAllHotelGuest) {
            System.out.println(guest);
        }
    }
    @Override
    public int executeChoice() {
        System.out.println("Выберите один из пунктов нажав соответствующую цифру: ");
        System.out.println("1. Поселить нового гостя в гостиницу ");
        System.out.println("2. Выселить гостя с гостиницы");
        System.out.println("3. Узнать количество людей живущих в гостинице");
        System.out.println("4. Импортировать гостя из файла csv в хранилище(коллекцию)");
        System.out.println("5. Экспортировать гостя из хранилища(коллекции) в файл csv");
        System.out.println("6. Просмотреть список гостей из файла csv");
        System.out.println("7. Просмотреть список гостей находящихся в хранилище(коллекции) ");
        System.out.println("8. Вернуться в предыдущее меню");

        int numberOfcase = scanner.nextInt();
        return numberOfcase;
    }
    public void errorSelect (){
        System.err.println("Нет такого пункта в меню. Введите корректное значение");
    }

}



