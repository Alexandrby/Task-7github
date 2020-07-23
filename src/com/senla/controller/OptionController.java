package com.senla.controller;
import com.senla.factory.intf.Option;
import com.senla.service.OptionService;
import com.senla.service.intf.OptionServiceBasic;
import com.senla.view.MainView;
import com.senla.view.OptionView;

import java.io.IOException;
import java.util.ArrayList;


public class OptionController implements Controller {

    private OptionServiceBasic optionServiceBasic;
    private OptionView optionView;

    public OptionController (OptionService optionService, OptionView optionView ) {
        this.optionServiceBasic = optionService;
        this.optionView = optionView;
    }

    private  void createOption(){
        Option option = optionView.createOption();
        try {
            optionServiceBasic.createHotelOption(option);
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void readOption () {
        String nameOfOption = optionView.readOption();
        try {
            optionServiceBasic.readOption(nameOfOption);
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void deleteOption(){
        String nameOfDeleteOption = optionView.deleteOption();
        optionServiceBasic.deleteHotelOption(nameOfDeleteOption);
    }

    private void  importOption(){
        String id = String.valueOf(optionView.importOption());
        try {
            optionServiceBasic.importHotelOption(id);
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
        catch (IndexOutOfBoundsException ind){
            System.err.println("Услуги с таким Id не существует! Проверьте файл csv и введите корректный id ");
        }
    }

    private void exportOption(){
        String nameOfOption = optionView.exportOption();
        try {
            optionServiceBasic.exportHotelOption(nameOfOption);
        } catch (IOException e) {
            System.err.println("File could not be write");
        }
        catch (NumberFormatException num){
            System.err.println("Файл csv поврежден.При неудачной попытке считать файл, появилась пустая строка \"\", удалите её");
        }
    }
    private void readAllCSVOption(){
        try {
            optionServiceBasic.readAllCSVOption();
        } catch (IOException e) {
            System.err.println("File could not be readFile");
        }
    }

    private void readAllOption(){
        ArrayList<Option> options = null;
        try {
            options = optionServiceBasic.readHotelOptions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        optionView.printAllOption(options);
    }

    @Override
    public void execute() {
        while (true) {
            int numberOfcase = optionView.executeOption();

            switch (numberOfcase) {
                case 1:
                    createOption();
                    break;
                case 2:
                    deleteOption();
                    break;
                case 3:
                    readAllCSVOption();
                    break;
                case 4:
                    importOption();
                    break;
                case 5:
                    exportOption();
                    break;
                case 6:
                    readAllOption();
                    break;
                case 7:
                    return;
                default:
                   optionView.errorSelect();
            }
        }
    }
}


