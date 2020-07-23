package com.senla.view;
import com.senla.view.intf.MainViewBasic;
import java.util.Scanner;

public class MainView implements MainViewBasic {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int executeChoice() {
        System.out.println("Выберите один из пунктов нажав соответствующую цифру: ");
        System.out.println("1. Войти в меню \"Гость\" ");
        System.out.println("2. Войти в меню \"Комната\" ");
        System.out.println("3. Войти в меню  \"Услуги\" ");
        System.out.println("4. Закончить работу программы");

        int numberOfcase = scanner.nextInt();
        return numberOfcase;

    }
    public void errorSelect (){
        System.err.println("Нет такого пункта в меню. Введите корректное значение");
    }
}
