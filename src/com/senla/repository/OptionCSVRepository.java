package com.senla.repository;
import com.senla.csv.EntityCSV;
import com.senla.factory.OptionFactory;
import com.senla.factory.intf.Option;
import com.senla.proper.Property;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OptionCSVRepository implements RepositoryBasis<Option, String> {
    private Option option = null;
    OptionRepository optionRepository;
    private EntityCSV entityCsv;
    private Property property = new Property();// <- не самый удачный способ, но через конструктор не получилось почему-то, надо разбираться.
//    File fileOption = new File("C:/WorkJava/Reps/HotelOptionRepos.csv");     //home
//    File fileOption = new File("D:/Синёв/разное/Java learn/HotelOptionRepos.csv");     //work
    private  File fileOption = new File(property.load("option"));
    public OptionCSVRepository(OptionRepository optionRepository) {
        this.entityCsv =new EntityCSV(fileOption);
        this.optionRepository = optionRepository;
    }

    @Override
    public Option create(Option option) throws IOException {
        String nameOfOption = option.getNameOfOption();
        int count =0;
        List<String> listToWrite = new ArrayList<>();
        for (Option option1 : optionRepository.optionsList){
            if (option.getNameOfOption().equals(nameOfOption)){
                listToWrite.add(String.valueOf(getLastId()));
                listToWrite.add(option1.getNameOfOption());
                listToWrite.add(String.valueOf(option1.getPricePerOption()));
                listToWrite.add(option1.getType());
                System.out.println("Услуга " + nameOfOption + " успешно добавлена в файл csv ");
                count++;
            }
        }
        if(count==0){
            System.err.println("Такой услуги в списке хранилища. Введит корректное название услуги.");
        }
        entityCsv.writeFile(listToWrite);
       return option;
    }

    @Override
    public Option read(String stringId) throws IOException {
        int id = Integer.parseInt(stringId);
        List<List<String>> options = entityCsv.readFile();
        try {
            String typeOfOption = options.get(id).get(3);

            option = OptionFactory.valueOf(typeOfOption).create();
            option.setId(Integer.parseInt(options.get(id).get(0)));
            option.setNameOfOption(options.get(id).get(1));
            option.setPricePerOption(Integer.parseInt(options.get(id).get(2)));
            optionRepository.optionsList.add(option);
            System.out.println("Услуга с id " + id + " успешно импортирована в коллекцию ");
        } catch (IndexOutOfBoundsException index) {
            throw index;
        }
        return null;
    }

    @Override
    public Option update(Option option) {
        return null;
    }

    @Override
    public void delete(String nameGuest) {

    }

    @Override
    public ArrayList<Option> createAll(String string) {
        return null;
    }

    @Override
    public ArrayList<Option> readAll() throws IOException {
        List<List<String>> options = entityCsv.readFile();
        for (List<String> option : options){
            System.out.println(option);
        }
        return null;
    }

    @Override
    public void addTestList() {

    }

    public int getLastId() throws IOException,NumberFormatException {
        int lastId =0;
        List<List<String>> options = entityCsv.readFile();
        try {
            lastId = Integer.parseInt(options.get(options.size() - 1).get(0)) + 1;
        } catch (NumberFormatException num) {
            throw num;
        }
        return lastId;
    }
}
