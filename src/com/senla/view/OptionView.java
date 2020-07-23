package com.senla.view;
import com.senla.factory.intf.Option;
import com.senla.factory.OptionFactory;
import com.senla.view.intf.OptionViewBasic;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionView implements OptionViewBasic {

    private Scanner scanner = new Scanner(System.in);
    Option option = null;

    @Override
    public Option createOption() {

        System.out.println("Укажите наименование услуги: ");
        String switchOnString = scanner.nextLine();
        String nameOfOption = scanner.nextLine();
        System.out.println("Укажите статус новой услуги (VIP/ORDINARY):");
        String typeOfOption = scanner.nextLine();
        System.out.println("Укажите цену за услугу " + "\"" + nameOfOption + "\"");
        double pricePerOption = scanner.nextDouble();
        option = OptionFactory.valueOf(typeOfOption).create();
        option.setNameOfOption(nameOfOption);
        option.setPricePerOption(pricePerOption);
        System.out.println("Услуга " + "\"" + nameOfOption + "\"" + " успешно добавлена в список услуг гостиницы");

           return option;
    }

    @Override
    public String readOption(){
        System.out.println("Укажите название услуги: ");
        String switchOnString2 = scanner.nextLine();
        String nameOfOption = scanner.nextLine();
        return nameOfOption;
    }

    @Override
    public String deleteOption(){
        System.out.println("Укажите наименование услуги, котоую требуется удалить: ");
        String switchOnString2 = scanner.nextLine();
        String nameOfDeleteOption= scanner.nextLine();
        return nameOfDeleteOption;
    }

    @Override
    public int importOption() {
        System.out.println("Выберите id услуги из списка(файл.csv) которого хотите импортировать в коллекцию: ");
        int id = scanner.nextInt();
        return id;
    }

    @Override
    public String exportOption() {
        System.out.println("Укажите наименование услуги, которую требуется экспортировать из коллекции в файл csv : ");
        String switchOnString = scanner.nextLine();
        String nameOfOption = scanner.nextLine();
        return nameOfOption;

    }

    @Override
    public void printAllOption(ArrayList<Option> listAllHotelOption) {
        for (Option option : listAllHotelOption) {
            System.out.println(option);
        }
    }

    @Override
    public int executeOption(){

        System.out.println("Выберите один из пунктов нажав соответствующую цифру: ");
        System.out.println("1. Добавить новую услугу для клиентов ");
        System.out.println("2. Убрать услугу из списка услуг");
        System.out.println("3. Просмотреть список услуг из файла csv");
        System.out.println("4. Импортировать услугу из файла csv в хранилище(коллекцию)");
        System.out.println("5. Экспортировать услугу из хранилища(коллекции) в файл csv");
        System.out.println("6. Просмотреть список услуг из файла хранилища (коллекции) ");
        System.out.println("7. Вернуться в предыдущее меню");
        int numberOfcase = scanner.nextInt();
        return numberOfcase;
    }
    public void errorSelect (){
        System.err.println("Нет такого пункта в меню. Введите корректное значение");
    }
}
